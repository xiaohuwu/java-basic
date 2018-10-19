package com.ktb.basic.FanXing;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Created by dell on 2018-10-19.
 */
public class Question {
    private String title;
    private List<Option> list;
    private char right_answer;

    public Question(String title, List<Option> list, char right_answer) {
        this.title = title;
        this.list = list;
        this.right_answer = right_answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Option> getList() {
        return list;
    }

    public void setList(List<Option> list) {
        this.list = list;
    }

    public char getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(char right_answer) {
        this.right_answer = right_answer;
    }

    public boolean checkAnwser(char param) {
        if (param == right_answer) {
            return true;
        }
        return false;
    }

    public void show() {
        System.out.println(this.title);
        for (Option option : list) {
            System.out.print(option.toString() + "\t");
        }
        System.out.println();
    }


    /**
     * 可看作完全独立
     * @param args
     */
    public static void main(String[] args) {
        Option[] array  ={new Option('A',"下载"),
                           new Option('B',"xiaophu"),
                         };
        Question question= new Question("谁是最可爱的人", Arrays.asList(array),'A');
        question.show();
        System.out.println("请输入你的答案:");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char c = next.charAt(0);
        if(question.checkAnwser(c)){
            System.out.println("right");
        }else {
            System.out.println("fail");
        }
    }

}
