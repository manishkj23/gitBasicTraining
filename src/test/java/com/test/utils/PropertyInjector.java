package com.test.utils;

import java.util.Properties;

public class PropertyInjector extends Properties {

    @Override
    public String getProperty(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        } else {
            return super.getProperty(key);
        }
    }
}