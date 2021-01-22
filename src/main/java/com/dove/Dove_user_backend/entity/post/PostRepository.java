package com.dove.Dove_user_backend.entity.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    Page<Post> findAllByOrderByEventDateDesc(Pageable page);
}
