package com.example.dyplom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country extends BaseEntity{
    private String name;
}
