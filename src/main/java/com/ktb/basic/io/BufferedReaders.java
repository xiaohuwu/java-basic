package com.ktb.basic.io;
import java.io.*;
/**
 * Created by dell on 2018-10-19.
 * <p>
 * BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter
 * (new FileOutputStream("E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src\\io\\SystemOut.txt"),"UTF-8"));
 * <p>
 * 字符输入
 */

public class BufferedReaders {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(next);*/
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\FileReader");
        File newFile = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\newFile");
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedWriter = new BufferedWriter(new FileWriter(newFile));
            String temp;
            while (( temp= bufferedReader.readLine()) != null) {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            System.out.println(bufferedWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
