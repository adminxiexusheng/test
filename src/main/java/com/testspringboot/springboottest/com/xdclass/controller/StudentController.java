package com.testspringboot.springboottest.com.xdclass.controller;

import com.testspringboot.springboottest.annotation.MyAnno;
import com.testspringboot.springboottest.model.Student;
import com.testspringboot.springboottest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xiexusheng
 * @date 2020/12/22 - 22:31
 */
@RestController
public class StudentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/f01")
    @MyAnno
    public List<Student> query(@RequestBody Student student){
        System.out.println("执行了方法");
        List<Student> map= studentService.selectAll();
        System.out.println("切点方法执行完毕");
        System.out.println("新增一行代码");
        System.out.println("test冲突");
        return map;

    }


    @RequestMapping("/f02")
    public List<Student> selectAll(){
       return studentService.selectAll();
    }
}
