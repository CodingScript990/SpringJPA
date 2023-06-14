package com.example.jpa.repos;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
// Repository(의존성)
public class AppRepository {
    /**
     * DB의 소통을 담당함
     * @Transactional
     */

    // selectStudentAll method => ArrayList type 값 반환
    public List<Object> selectStudentAll() {
        return new ArrayList<>();
    }
}
