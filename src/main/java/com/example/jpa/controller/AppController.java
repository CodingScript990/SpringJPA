package com.example.jpa.controller;

import com.example.jpa.dto.StudentDto;
import com.example.jpa.entities.StudentEntity;
import com.example.jpa.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController // 모든 메서드에 @ResponseBody 를 붙이는 용도이다
// Controller(의존성) => Service(의존성)
public class AppController {
    /**
     * Client 의 입력을 받는 Element(요소)를 말함
     * RequestMapping 과 같이 사용함
     */

    // 사용자의 입력을 받는 Element(요소)
    private final AppService service; // Service 의존성을 주입 받는다는 의미

    // AppController => service
    public AppController(AppService service) {
        this.service = service;
    }

    /*

    // AppController Constructor => service 를 받아와 주는 작업
    public AppController(AppService service) {
        this.service = service;
    }

    // students method => student url 을 받아서 사용하겠다는 의미로 정의하는 것임
    @RequestMapping("students")
    public void students() {
        List<Object> result = service.readStudentAll();
    }

    // home method => html file 을 받아오겠다는 의미로 정의하는 작업
    @GetMapping("home") // url
    public String home() {
        return "home"; // view => html, data(식별 가능한)
    }

    // body method => ResponseBody annotation 을 사용하여 controller method 의 반환값을
    // json, xml, html 등 http 응답을 전송한다는 의미
    @GetMapping("body")
    public @ResponseBody String body() { // @ResponseBody : data 를 전송한다는 의미
        return "body"; 
    }
     */

    // Create
    @GetMapping("create")
    public @ResponseBody String create() {
        this.service.createStudent(
                "alex",
                35,
                "010-1234-5678",
                "alex@gmail.com"
        );
        // view 에는 결과로 done 이 보여지게 됨
        return "done";
    }

    // Read All
    @GetMapping("read-all")
    public @ResponseBody List<StudentDto> readAll() {
        this.service.readStudentAll();
//        return "done-read-all";
        return this.service.readStudentAll();
    }

    // Read
    @GetMapping("read")
    public @ResponseBody String readOne() {
        this.service.readStudent(1L);
        return "don-read-one";
    }

    // Update
    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L, "alexander");
        return "done-update";
    }

    // Delete
    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    // Find Test
    @GetMapping("find")
    public @ResponseBody String  find() {
        this.service.findAllByTest();
        return "done-find";
    }
}
