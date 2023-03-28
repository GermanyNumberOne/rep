package com.example.dyplom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "languages")
public class Language extends BaseEntity{
    private String name;
}
