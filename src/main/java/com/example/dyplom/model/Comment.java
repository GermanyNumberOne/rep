package com.example.dyplom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
}
