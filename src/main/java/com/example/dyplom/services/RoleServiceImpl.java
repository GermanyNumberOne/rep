package com.example.dyplom.services;

import com.example.dyplom.dao.RoleDao;
import com.example.dyplom.dto.RoleDto;
import com.example.dyplom.model.Role;
import com.example.dyplom.services.api.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private ModelMapper modelMapper;
    private RoleDao roleDao;

    @Transactional
    @Override
    public RoleDto save(RoleDto dto) {
        Role role = roleDao.save(modelMapper.map(dto, Role.class));
        return modelMapper.map(role, RoleDto.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

    @Transactional
    @Override
    public RoleDto findById(Long id) {
        return modelMapper.map(roleDao.findById(id), RoleDto.class);
    }

    @Transactional
    @Override
    public List<RoleDto> getAll() {
        return roleDao.findAll().stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public RoleDto getRoleByName(String name) {
        return modelMapper.map(roleDao.findByName(name), RoleDto.class);
    }
}
