package com.maringa.frotas.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {

    private static SimpleDateFormat stfNormal = new SimpleDateFormat("dd/MM/yyyy");

    public static String DateToString(Date data){
        return stfNormal.format(data);
    }

}
