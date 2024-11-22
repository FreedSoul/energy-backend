package com.energy_backend.energy_api.repository;

import com.energy_backend.energy_api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    //to-do fix the query
    @Query("SELECT c FROM comment c JOIN c.news s WHERE s.id = :newsId")
    List<Comment> findCommentsByNewsId(@Param("newsId") Integer newsId);
}
