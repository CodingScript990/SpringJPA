package com.example.jpa.repos;

import com.example.jpa.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    // JpaRepository<내가 사용할 Entity, 그 Entity 의 ID 컬럼의 타입>

    // Spring Data JPA - Query Method
    // 메서드 이름을 우리가 조회하고 싶은 조건을 붙여서 만든다

    // 하나 or 많이
    // (findBy || findAllBy) * [(Column + 조건) * n] + [OrderBy + Column]

    // select * from students order by name
    // findAllByOrderByName method
    List<StudentEntity> findAllByOrderByName();

    // select * from students order by age;
    // findAllByOrderByAge method
    List<StudentEntity> findAllByOrderByAgeDesc();

    // select * from students where age < 21;
    List<StudentEntity> findAllByAgeLessThan(Integer age);

    // select * from students where phone like '010-%'
    List<StudentEntity> findAllByPhoneStartingWith(String phone);
}
