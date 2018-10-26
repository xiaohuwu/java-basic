package com.ktb.basic.valuepass;

/**
 * Created by dell on 2018-10-25.
 */
public class Test2 {
    public static void main(String[] args) {
        Person person = new Person("xioahu",12);
        Person person_1 = new Person("xiaozhang",24);
        swap(person,person_1);
        System.out.println("[person]:"+person);
        System.out.println("[person_1]:"+person_1);
       /* Person temp  = person;
        person = person_1;
        person_1 = temp;
        System.out.println("[person]:"+person);
        System.out.println("[person_1]:"+person_1);*/
    }
    // not work
    private static void swap(Person person, Person person_1) {
        Person temp  = person;
        person = person_1;
        person_1 = temp;
    }

    /*private static Person[] swapReal(Person person, Person person_1) {
        Person temp  = person;
        person = person_1;
        person_1 = temp;
    }*/
}

class Person{
    private String name;
    private int age;

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "[name]:"+name+"[age]:"+age;
    }

/*    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
    }*/
}