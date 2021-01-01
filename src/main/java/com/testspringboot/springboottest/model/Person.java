package com.testspringboot.springboottest.model;

/**
 * @author xiexusheng
 * @date 2021/1/1 - 20:36
 */
public class Person {

    private String sex;
    private String age;

    public String a;
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public  void eat(){
        System.out.println("吃东西");
    }
    public  void eat(String dongxi){
        System.out.println("吃东西"+dongxi);
    }
    public  void eat(int dongxi){
        System.out.println("吃东西"+dongxi);
    }
}
