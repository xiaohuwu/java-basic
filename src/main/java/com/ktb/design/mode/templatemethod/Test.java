package com.ktb.design.mode.templatemethod;


public class Test {

    public static void main(String[] args) {
        Book book = new Book();
        book.setBookName("Thinking in Java");
        book.setPages(880);
        book.setPrice(68);
        book.setAuthor("Bruce Eckel");
        book.setIsbn("9787111213826");
        //XMLFormatter xmlFormatter  =new XMLFormatter();
        //FormaterUtils.format(new XMLFormatter(),book);
        // 1 策略模式
        String formating1 = FormaterUtils.format(new XMLFormatter(),book);
        // 2  它定义了算法家庭，分别封装起来。让它们之间可以互相替换
        String formating2 = FormaterUtils.format(new JsonFormatter(),book);
        System.out.println(formating1);
        System.out.println(formating2);

    }
}
