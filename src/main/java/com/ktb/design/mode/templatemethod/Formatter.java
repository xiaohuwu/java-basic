package com.ktb.design.mode.templatemethod;


//模板方法设计模式 的精髓在於定义好执行顺序 留出钩子方法
public abstract class Formatter {

    public String formatBook(Book book) {
         beforeFormat();
         String result = formating(book);
         afterFormat();
         return result;
    }

    protected abstract String formating(Book book);

    protected void beforeFormat(){
        System.out.println("format begins");
    }
    protected  void afterFormat(){
        System.out.println("format fininsh");
    }
}
