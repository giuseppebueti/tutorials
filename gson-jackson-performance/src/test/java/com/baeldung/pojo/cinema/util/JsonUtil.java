package com.baeldung.pojo.cinema.util;

import java.text.SimpleDateFormat;

/**
 * Created by giuse on 16/07/2016.
 */
public class JsonUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static SimpleDateFormat getDateFormat(){
        return sdf;
    }


}
