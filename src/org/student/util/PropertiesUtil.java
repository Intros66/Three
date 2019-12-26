package org.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static String getValue(String key){
        Properties properties = new Properties();
        InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/db.properties");
        try {
            properties.load(in);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取失败");
        }
        return properties.getProperty(key);
    }

//    public static void main(String[] args) {
//        System.out.println(PropertiesUtil.getValue("dbUserName"));
//    }
}
