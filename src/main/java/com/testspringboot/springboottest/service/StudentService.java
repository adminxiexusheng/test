package com.testspringboot.springboottest.service;

import com.testspringboot.springboottest.dao.StudentMapper;
import com.testspringboot.springboottest.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiexusheng
 * @date 2020/12/22 - 22:44
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public List<Student> selectAll(){
        List<Student> student=studentMapper.selectAll();
        System.out.println("student"+student.size());
        return student;
    }
}
