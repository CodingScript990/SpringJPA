package com.example.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * create table students (
 *  id integer primary key autoincrement,
 *  name text,
 *  age integer,
 *  phone text,
 *  email text
 */

@Data
@Entity // 데이터베이스 테이블의 레코드를 나타냄
@Table(name = "students") // table 정의
public class StudentEntity { // student_entity
    // Member Field
    @Id // Pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 생성 해달라는 의미
    private Long id;

    // Column 어노테이션에 인자를 전달해서 table Constraint 추가 가능
//    @Column(name = "username", nullable = false, unique = true)
    private String name;
    private Integer age;
//    @Column(unique = true)
    private String phone;
    private String email;
}
