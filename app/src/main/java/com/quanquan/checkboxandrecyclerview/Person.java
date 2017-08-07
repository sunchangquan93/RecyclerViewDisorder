package com.quanquan.checkboxandrecyclerview;

import java.io.Serializable;

/**
 * Created by qGod on 2017/8/4
 * Thank you for watching my code
 */

public class Person implements Serializable {
    private String Name;
    private String age;

    public Person() {
    }

    public Person(String name, String age) {
        Name = name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
