package com.example.dyplom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actors")
public class Actor extends BaseEntity {
    private String firstname;
    private String surname;

    private String image;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}
