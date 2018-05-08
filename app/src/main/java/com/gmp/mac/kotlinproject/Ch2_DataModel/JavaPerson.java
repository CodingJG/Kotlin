package com.gmp.mac.kotlinproject.Ch2_DataModel;

public class JavaPerson {

    private String name;
    private  int age;

    public JavaPerson() {
    }

    public JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "JavaPerson{ "+ "name = "+name+'\''+" ,age = "+age+" }";
    }
}
