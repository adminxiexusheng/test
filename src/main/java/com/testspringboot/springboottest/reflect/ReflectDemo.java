package com.testspringboot.springboottest.reflect;


import com.testspringboot.springboottest.model.Person;

import java.lang.reflect.Field;

/**
 * @author xiexusheng
 * @date 2021/1/1 - 20:35
 */
public class ReflectDemo {


    public static void main (String[] args) throws Exception{

        Class<Person> personClass = Person.class;

        //只会获取public修饰的属性的成员变量
        //public java.lang.String com.testspringboot.springboottest.model.Person.a
        Field[] fields = personClass.getFields();
        for (int i = 0; i <fields.length ; i++) {
            System.out.println(fields[i]);
        }
        //获取public修饰的指定名称的成员变量
        Field a = personClass.getField("a");
        //获取到成员变量可以进行get和set值
        //set值方式
        Person person = new Person();
        a.set(person,"张三");
        //get值方式
        Object result = a.get(person);
        System.out.println(result);

        //获取所有的成员变量 不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (int i = 0; i <declaredFields.length ; i++) {
            System.out.println(declaredFields[i]);
        }
        //获取指定的成员变量，不考虑修饰符
        Field a1 = personClass.getDeclaredField("age");
        //如果使用private修饰的成员变量时需要忽略掉访问权限修饰符的安全检查
        //即暴力反射
        a1.setAccessible(true);
        Object o = a1.get(person);
        System.out.println(o);
    }

}
