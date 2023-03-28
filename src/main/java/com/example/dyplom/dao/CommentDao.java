package com.example.dyplom.dao;

import com.example.dyplom.model.Comment;
import com.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {
}
