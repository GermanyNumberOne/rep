package com.example.dyplom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @Column(name = "token", unique = true, nullable = false)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "user-token")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
