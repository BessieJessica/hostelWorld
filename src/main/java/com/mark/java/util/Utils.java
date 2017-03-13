package com.mark.java.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lois on 2017/3/12.
 */
public class Utils {
    public static boolean isMobileNumber(String phone) {
        Pattern p = Pattern.compile("^\\d{11}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }


    /**
     * 系统随机分配注册码
     */
    public static int generateCode() {
        int min = 1000000;
        int max = 9999999;
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }
}
