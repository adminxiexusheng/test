package com.testspringboot.springboottest.reflect;


import com.testspringboot.springboottest.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author xiexusheng
 * @date 2021/1/1 - 20:35
 */
public class ReflectDemo1 {

    /**
     * 获取构造器的使用方法
     * @param args
     * @throws Exception
     */

    public static void main (String[] args) throws Exception{

        Class<Person> personClass = Person.class;
        //获取无参的构造方法
        Constructor<Person> constructor = personClass.getConstructor();
        //通过构造器来进行创建对象
        Person person = constructor.newInstance();
        //或者也可以通过class对象有个自带的方法newInstance（）直接创建对象
        Person person1 = personClass.newInstance();

    }

}
