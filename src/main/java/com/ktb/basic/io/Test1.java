package com.ktb.basic.io;

import java.io.*;

/**
 * Created by dell on 2018-10-19.
 * <p>
 * <p>
 * <p>
 * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.txt文件中用回车或空格进行分隔
 */

public class Test1 {
    public static void main(String[] args) {
        File a = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\io\\a.txt");
        File b = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\io\\b.txt");
        File c = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\io\\c.txt");

        StringBuffer aResult = new StringBuffer();
        StringBuffer bResult = new StringBuffer();
        BufferedReader aReader = null;
        BufferedReader bReader = null;
        BufferedWriter writer = null;
        try {
            aReader = new BufferedReader(new FileReader(a));
            bReader = new BufferedReader(new FileReader(b));
            writer = new BufferedWriter(new FileWriter(c));
            String temp = null;
            while ((temp = aReader.readLine()) != null) {
                String s = temp.replaceAll("\\s+", "");
                aResult.append(s);
            }
            while ((temp = bReader.readLine()) != null) {
                String s = temp.replaceAll("\\s+", "");
                bResult.append(s);
            }
            char[] array_a = aResult.toString().toCharArray();
            char[] array_b = bResult.toString().toCharArray();
            for (int k = 0; k < array_a.length; k++) {
                writer.write(array_a[k]);
                if (k <= array_b.length - 1) {
                    writer.write(array_b[k]);
                }
            }
            if (array_b.length > array_a.length) {
                for (int k = array_a.length; k < array_b.length; k++) {
                    writer.write(array_b[k]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                aReader.close();
                bReader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
