package com.testspringboot.springboottest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiexusheng
 * @date 2020/12/25 - 21:46
 */
//type 可以作用于类上 method可以作用于方法上 field 可以作用于成员变量上
//RetentionPolicy.RUNTIME 当前被描述的注解会被保存到class文件中并被jvm读取到，一般多设置为runtime

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

    //注解本质就是个接口
/*    定义的返回值类型
        基本数据类型
        String
        枚举
        注解
        以上类型的数组*/
/*        int show1();
        String show2();
        MyAnno2 myanno();
        String [] strs();
        Person per();*/

}
