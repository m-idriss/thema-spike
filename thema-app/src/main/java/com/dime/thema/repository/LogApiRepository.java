package com.dime.thema.repository;

import com.dime.thema.entity.LogApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogApiRepository extends JpaRepository<LogApi, Long> {
}
