package com.example.dyplom.dao;

import com.example.dyplom.model.Actor;
import com.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Long> {
}
