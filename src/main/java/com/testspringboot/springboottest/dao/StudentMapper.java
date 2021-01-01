package com.testspringboot.springboottest.dao;

import com.testspringboot.springboottest.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiexusheng
 * @date 2020/12/22 - 22:42
 */
@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> selectAll();
}
