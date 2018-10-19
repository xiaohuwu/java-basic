package com.ktb.basic.io;

import java.io.*;

/**
 * Created by dell on 2018-10-19.
 */
public class FileManager {
    public String[] array;
    public int position = 0;

    public FileManager(File file, String regex) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        char[] buffere = new char[(int) file.length()];
        int read = bufferedReader.read(buffere);
        String str = new String(buffere, 0, read);
        array = str.split(regex);
    }

    public String nextWord() {
        if (position == array.length) {
            return null;
        }
        return array[position++];
    }
}
