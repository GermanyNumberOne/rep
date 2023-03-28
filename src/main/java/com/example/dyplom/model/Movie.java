package com.example.dyplom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {
    private String title;
    private String description;
    private String poster;
    private Integer rating;
    private Integer budget;
    private Date year;
    private String tagline;

    @ManyToMany
    @JoinTable(name = "movies_actors", joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")})
    private List<Actor> actors;

}
