package com.ktb.basic.io;

import java.io.*;
import java.util.Scanner;
/**
 * Created by dell on 2018-10-19.
 * <p>
 * BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter
 * (new FileOutputStream("E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src\\io\\SystemOut.txt"),"UTF-8"));
 * <p>
 * 字符输入
 */
public class ByteArray {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(next);*/
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //File file = new File("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\FileReader");
        byte[] array = "我爱你中国".getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringWriter writer = null;
        try {
            writer = new StringWriter();
            byte[] buffer = new byte[1024];
            int length= 0;
            while (( length= byteArrayInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer,0,length);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
