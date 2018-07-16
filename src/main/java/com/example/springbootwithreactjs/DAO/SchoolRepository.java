package com.example.springbootwithreactjs.DAO;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SchoolRepository extends CrudRepository<SchoolTable, Long> {
    List<SchoolTable> findBySchoolName(String schoolName);
}
