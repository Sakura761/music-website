package com.sakura.domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String  formatCSTDate(String cstDateStr) {
        Date date = null;
        SimpleDateFormat sdf1 = null;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date = sdf1.parse(cstDateStr);
        } catch (ParseException e) {
            sdf1 = new SimpleDateFormat("yyyy'年' MM'月' dd'日' EEE HH:mm:ss Z", Locale.CHINA);
            try {
                date = sdf1.parse(cstDateStr);
            } catch (ParseException e1) {
                System.out.println("CST日期格式转换出错，原因：" + e.getMessage());
                return null;
            }
        }
        return sdf2.format(date);
    }
}
