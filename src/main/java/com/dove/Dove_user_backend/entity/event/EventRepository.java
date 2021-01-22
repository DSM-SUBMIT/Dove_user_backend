package com.dove.Dove_user_backend.entity.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findAllByEventDateBetween(LocalDate start, LocalDate end);
}
