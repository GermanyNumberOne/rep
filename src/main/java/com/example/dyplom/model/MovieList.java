package com.example.dyplom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "movie_lists")
public class MovieList extends BaseEntity {
}
