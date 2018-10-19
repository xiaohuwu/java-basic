package com.ktb.basic.io;

import java.io.*;

/**
 * Created by dell on 2018-10-19.
 * <p>
 * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.txt文件中用回车或空格进行分隔
 */

public class Test2 {
    public static void main(String[] args) {
        File a = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\io\\a.txt");
        File b = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\io\\b.txt");
        File c = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\io\\c.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(c));
            FileManager fileManager_a = new FileManager(a, "\r\n");
            FileManager fileManager_b = new FileManager(b, "\r\n|\\s+");
            String a_word = null;
            String b_word = null;
            while ((a_word = fileManager_a.nextWord()) != null) {
                writer.write(a_word);
                String s = fileManager_b.nextWord();
                if (s != null) {
                    writer.write(s);
                }
            }
            while ((b_word = fileManager_b.nextWord()) != null) {
                writer.write(b_word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
