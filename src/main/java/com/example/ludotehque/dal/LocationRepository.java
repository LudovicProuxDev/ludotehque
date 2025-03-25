package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
