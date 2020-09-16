package com.liust.jd.designpatterns.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
       return properties.get(key);
    }

    public static void main(String[] args) {
        Object o = properties.get("initTankCount");

        System.out.println(o);
    }
}
