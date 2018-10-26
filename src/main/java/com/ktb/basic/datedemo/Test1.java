package com.ktb.basic.datedemo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
/**
 * Created by dell on 2018-10-24.
 *
 * Monday(星期一)、Tuesday(星期二)、Wednesday(星期三)、Thursday(星期四)、Friday(星期五)、Saturday(星期六),Sunday
 *一个小日历
 */
public class Test1 {
   static String[] header  ={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    public static void main(String[] args) {
      for(String item: header){
          System.out.format("%-4s",item);
      }
        System.out.println();
        LocalDate localDate = LocalDate.now();
        int need = localDate.getDayOfMonth();
        localDate = localDate.plusDays(-(need-1));
        int dayOfWeek = localDate.getDayOfWeek().getValue()%7;
        for(int k=0;k<dayOfWeek;k++){
            System.out.format("%-4s"," ");
        }
        Month now_month = localDate.getMonth();
        while(now_month==localDate.getMonth()){
            int dayOfMonth = localDate.getDayOfMonth();
            System.out.format("%-4s",String.valueOf(dayOfMonth));
            localDate = localDate.plusDays(1);
            if(localDate.getDayOfWeek().getValue()%7==0){
                System.out.println();
            }
        }
        System.out.println();
    }
}
