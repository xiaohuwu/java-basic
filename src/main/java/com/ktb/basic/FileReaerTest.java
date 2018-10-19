package com.ktb.basic;
import java.io.*;
/**
 * Created by dell on 2018-10-18.
 */
public class FileReaerTest {
    public static final String last = "";
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("F:\\spring_boot\\java-basic\\src\\main\\java\\com\\ktb\\basic\\FileReader");
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            char[] array = new char[1024];
            int lengh = 0;
            while ((lengh = fileReader.read(array)) != -1) {
                charArrayWriter.write(array, 0, lengh);
            }
            String temp = charArrayWriter.toString();
            System.out.println("[before]:" + temp.toString());
            char[] chars = temp.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (int k = 0; k < chars.length; k++) {
                String other = String.valueOf(chars[k]);
                if (other.matches("[a-z]")) {
                    char need = 0;
                    if (chars[k] == 'z') {
                        need = 'a';
                    } else {
                        need = (char) (chars[k] + 1);
                    }
                    stringBuffer.append(need);
                } else if (other.matches("[A-Z]")) {
                    char need = 0;
                    if (chars[k] == 'Z') {
                        need = 'A';
                    } else {
                        need = (char) (chars[k] + 1);
                    }
                    stringBuffer.append(need);
                } else if (other.matches("[0-9]")) {
                    int need = 0;
                    if (chars[k] == '9') {
                        need = 0;
                    } else {
                        //字符在做运算的时候 其实是取的Assic码的值
                        need = Integer.valueOf(String.valueOf(chars[k])) + 1;
                    }
                    stringBuffer.append(need);
                } else {
                    stringBuffer.append(chars[k]);
                }
            }
            System.out.println("[after]: " + stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
