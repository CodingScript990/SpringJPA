package com.example.jpa.dto;

import com.example.jpa.entities.StudentEntity;
import lombok.Data;

@Data
public class StudentDto {
    private Long id; // Entity.id
    private String name; // Entity.name
    private String email; // Entity.email

    // 정적 메서드 생성
    // Dto 를 이용하여 service 에서 재사용성이 용이하도록 작업함
    public static StudentDto fromEntity(StudentEntity studentEntity) {
        // 인스턴스화를 함
        StudentDto dto = new StudentDto();

        dto.setId(studentEntity.getId());
        dto.setName(studentEntity.getName());
        dto.setEmail(studentEntity.getEmail());

        return dto;
    }
}
