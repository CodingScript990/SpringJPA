package com.example.jpa.service;

import com.example.jpa.dto.StudentDto;
import com.example.jpa.entities.StudentEntity;
import com.example.jpa.repos.AppRepository;
import com.example.jpa.repos.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Service(의존성) => Repository(의존성)
@Service
public class AppService {
    /**
     * 주된 비즈니스 로직이 구현되는 공간을 말함
     * Controller -> Service
     * Service
     * 데이터베이스 조회
     * Component 사용
     * 모든 데이터를 가지고 응답(의사결정)
     */

//  List<Student> studentList = new ArrayList<>(); 구버전
    // AppRepository 를 이용하겠다는 의미[DB 의존성 주입]
    private final AppRepository repository;
    // JpaRepository
    private final StudentRepository studentRepository;

    // AppService Constructor add => AppRepository 를 사용하겠다는 의미
    public AppService(AppRepository repository, StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    // List 형태 Object 타입 readStudentAll method
    /*
    public List<Object> readStudentAll() {
        // Repository 의존성을 주입 받고 해당 메서드를 사용하겠다는 의미
        List<Object> queryResult = repository.selectStudentAll();
        // queryResult 의 값을 반환 받겠다는 의미
        return queryResult;
    }
     */

    // Create
    // createStudent method
    public StudentDto createStudent(String name, Integer age, String phone, String email) {
        // 새로운(new) Student(Entity)를 만들고 싶음
        StudentEntity newEntity = new StudentEntity();
        newEntity.setName(name);
        newEntity.setAge(age);
        newEntity.setPhone(phone);
        newEntity.setEmail(email);

        // repository.save()
        // save() 메서드는 생성된 Entity 를 반환한다
        newEntity = this.studentRepository.save(newEntity);
        return StudentDto.fromEntity(newEntity);
    }

    // Read
    // readStudent method => id
    public void readStudent(Long id) {
        // 조회할 Entity 를 회수
        Optional<StudentEntity> optionalStudentEntity = this.studentRepository.findById(id);
        // 1. 실제 데이터가 온 경우
        if (optionalStudentEntity.isPresent()) {
            // 출력한다
            System.out.println(optionalStudentEntity.get());
        }
        // 2. 결과가 null 이 되었을 경우
        else {
            // 값이 없다면 message no result 를 표기하라
            System.out.println("no result");
        }
    }

    // Read All
    // readStudentAll => list type
    public List<StudentDto> readStudentAll() {
        System.out.println(this.studentRepository.findAll());
        // Entity 와 Dto 의 값을 분리함
        // Entity 를 받아오는 작업
        List<StudentEntity> studentEntityList = this.studentRepository.findAll();
        // Dto 를 받아오는 작업
        List<StudentDto> studentDtoList = new ArrayList<>();
        // Entity 를 받아와주는 작업
        for (StudentEntity studentEntity : this.studentRepository.findAll()) {
            // StudentDto 를 인스턴스화 함
            //StudentDto studentDto = new StudentDto();
            // Entity 값을 받고 보여줌 => id, name, email
//            studentDto.setId(studentEntity.getId());
//            studentDto.setName(studentEntity.getName());
//            studentDto.setEmail(studentEntity.getEmail());
            studentDtoList.add(StudentDto.fromEntity(studentEntity)); // StudentDto 를 부여받아 재사용성을 높여줌
        }
        // studentDtoList 를 반환받음
        return studentDtoList;
    }

    // Update
    // updateStudent => id
    public void updateStudent(
            // 어떤 대상을 수정할지 지정해줘야함 => id
            Long id,
            // 수정할 데이터 => name
            String name
    ) {
        // 수정할 Entity 를 회수
        Optional<StudentEntity> optionalStudentEntity = this.studentRepository.findById(id);
        // 수정할 Entity 를 찾은 경우
        if (optionalStudentEntity.isPresent()) {
            // 실제 객체 회수
            StudentEntity target = optionalStudentEntity.get();
            // 수정할 데이터 적용
            target.setName(name);
            // save
            this.studentRepository.save(target);
        } else {
            // 없으면 없다고 알려줌
            System.out.println("Couldn't find");
        }
    }

    // Delete
    // deleteStudent => id
    public void deleteStudent(Long id) {
        // 삭제할 Entity 를 회수
        Optional<StudentEntity> optionalStudentEntity = this.studentRepository.findById(id);
        // 삭제할 Entity 를 찾은 경우
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();
            // Delete
            this.studentRepository.delete(studentEntity);
        } else {
            System.out.println("Couldn't find");
        }
    }

    // findAllBy
    public void findAllByTest() {
        System.out.println("--- findAllByOrderByName ---");

        // findAllByOrderByName
        List<StudentEntity> studentEntities = this.studentRepository.findAllByOrderByName();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("--------------------------");

        // findAllByOrderByAgeDesc
        System.out.println("--- findAllByOrderByAgeDesc ---");
        studentEntities = this.studentRepository.findAllByOrderByAgeDesc();

        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("--------------------------");

        // findAllByAgeLessThan
        System.out.println("--- findAllByAgeLessThan ---");
        studentEntities = this.studentRepository.findAllByAgeLessThan(21);

        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("--------------------------");

        // findAllByPhoneStartingWith
        System.out.println("--- findAllByPhoneStartingWith ---");
        studentEntities = this.studentRepository.findAllByPhoneStartingWith("010-");

        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("--------------------------");
    }
}
