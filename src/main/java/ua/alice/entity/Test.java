package ua.alice.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Лис on 05.06.2016.
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd\\MM\\yyyy");
       System.out.print( format1.format(new Date()));
    }
}
