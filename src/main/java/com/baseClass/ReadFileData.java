package com.baseClass;

import java.io.*;
import java.util.Properties;

public class ReadFileData {

    public static Properties getConfigProperties(){

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }
}
