package com.zakaria;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * public class GameGetPropertyValues
 * configuration des parametres application
 */

public class GameGetPropertyValues {

    String result = "";
    public InputStream inputStream;

    public Properties getPropValues () {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {

                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            return prop;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}















//
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class LoadPropClasspath {
//
//    public static void main(String[] args) {
//
//        try {
//            InputStream input = LoadPropClasspath.class.getClassLoader().getResourceAsStream("config.properties");
//
//            Properties prop = new Properties();
//
//            if (input == null) {
//                System.out.println("Sorry, unable to find config.properties");
//                return;
//            }
//
//            //load a properties file from class path, inside static method
//            prop.load(input);
//
//            //get the property value and print it out
//            System.out.println(prop.getProperty("taille"));
//            System.out.println(prop.getProperty("nombEssais"));
//            System.out.println(prop.getProperty("modeDeveloppeur"));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//}
//



