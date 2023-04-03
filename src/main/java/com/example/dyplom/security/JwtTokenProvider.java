package com.example.dyplom.security;

import com.example.dyplom.dto.TokenDto;
import com.example.dyplom.services.UserDetailsServiceImpl;
import com.example.dyplom.services.api.TokenService;
import com.example.dyplom.services.api.UserService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtTokenProvider {

    private String secret;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    public JwtTokenProvider(){
        this.secret = "secret";
    }


    public String generateToken(User user){
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("roles", user.getAuthorities());
        Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        Date exp = Date.from(LocalDateTime.now().plusYears(3).atZone(ZoneId.systemDefault()).toInstant());

        String token = "";
        try {
            token = Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();

        } catch (JwtException e){
            e.printStackTrace();
        }

        saveToken(token,user.getUsername());

        return token;
    }

    public void saveToken(String token, String email){
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setUserDto(userService.findByEmail(email));
        tokenService.save(tokenDto);
    }

    public void deleteToken(String token){
        tokenService.deleteByToken(token);
    }


    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(token != null && token.startsWith("Bearer")){
            return token.substring(7, token.length());
        }
        return null;
    }

    public boolean validateToken(String token, HttpServletRequest request) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            log.warn("resolve token" + claims.getBody().getExpiration().toString());
            TokenDto tokenDto = tokenService.findByToken(token);

            if(tokenService.findByToken(token).getToken() == null){
                log.warn("token Dto: " + tokenDto);
                log.warn("token Dto token: " + tokenDto.getToken());
                return false;
            }

            if (claims.getBody().getExpiration().before(new Date())) {
                log.warn("expired");
                return false;
            }

            return true;
        }
        catch (JwtException | IllegalArgumentException e){

            throw new BadCredentialsException("Token is expired or invalid");
        }

    }
    public Authentication getAuthentication(String token){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getLogin(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }

    public String getLogin(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public List<String> getRolesNames(List<GrantedAuthority> authorities){
        return authorities.stream().map(authority -> authority.getAuthority().toString()).collect(Collectors.toList());
    }
}
