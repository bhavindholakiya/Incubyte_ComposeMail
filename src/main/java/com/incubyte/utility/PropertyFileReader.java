package com.incubyte.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    public Properties prop;
    public FileReader reader = null;
    public String value = "";

    public String getProperty(String key) throws IOException {
        try {
            String filePath = System.getProperty("user.dir")+"/src/test/java/resources/GlobalData.properties";
            System.out.println("File path is: "+filePath);
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        }

        try {
            prop = new Properties();
            prop.load(reader);
            value = prop.getProperty(key);
        } catch (IOException e){
            e.printStackTrace();
        }
        return value;
    }
    /*public static void main(String[] args) throws IOException {
        PropertyFileReader obj = new PropertyFileReader();
        System.out.println(obj.getProperty("baseURL"));
    }*/
}
