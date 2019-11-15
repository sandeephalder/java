package com.java.algo1;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test {
    ZonedDateTime st,end;

    Test(){
        st = ZonedDateTime.now();
    }

    long t(){
        return ChronoUnit.MILLIS.between(st, ZonedDateTime.now());
    }
    public static void main(String... ar ){

        Test t = new Test();

      /*  ZonedDateTime d1 = ZonedDateTime.now();*/

        try{
            Thread.sleep(20);
        }
        catch (Exception e){

            System.out.println(e);

        }
        //ZonedDateTime d2 = ZonedDateTime.now();

        System.out.println(t.t());
    }
}
