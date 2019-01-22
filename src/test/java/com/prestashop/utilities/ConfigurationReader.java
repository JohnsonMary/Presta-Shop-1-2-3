package com.prestashop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader{

    private static Properties properties;

    static {
        String path = "configuration.properties";

        try {
            // java can not read files directly, it needs inputstream to read files
            // input stream takes the location
            FileInputStream fileInputStream = new FileInputStream(path);

            // properties is used to read specifically properties files, files with key value pairs
            properties = new Properties();

            // file contents are load to properties from the input stream
            properties.load(fileInputStream);

            // all input streams must be closed
            fileInputStream.close();

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    // returns the value of specific property
    public static String getProperty(String property){

        return properties.getProperty(property);


    }

}
