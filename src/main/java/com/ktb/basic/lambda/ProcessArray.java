package com.ktb.basic.lambda;

/**
 * Created by dell on 2018-10-22.
 */
public class ProcessArray {

    public interface Command{
        public void process(int[] array);
    }

    public void process(int[] array,Command command){

        command.process(array);

    }
}
