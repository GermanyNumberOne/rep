package com.example.dyplom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private String name;

    @JsonIgnore
    //@JsonBackReference(value = "user-role")
    @ManyToMany(mappedBy = "roles")
    private List<User> user;
}
