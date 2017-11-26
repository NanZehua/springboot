package com.zehua.asj.utils;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ProperUtil {

    private static final Logger log = Logger.getLogger(ProperUtil.class);

    public static final String CONF_FILE_NAME = "application.properties";
    public static final String DB_USER_NAME = null;
    public static final String DB_PASSWORD = null;
    public static final String DB_URL = null;

    private ProperUtil() {
    }

    private static class ProperiesUtil {
        private static final ProperUtil INSTANCE = new ProperUtil();
    }

    public static ProperUtil getInstance() {
        return ProperiesUtil.INSTANCE;
    }

    static Properties prop;
    static {
        prop = new Properties();
    }

    public Properties getProperties() {
        return prop;
    }

    public void GetProperties() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(ProperUtil.CONF_FILE_NAME);
        try {
            prop.load(in);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        log.info("properties info : " + prop);
    }


    public static void SetConfInfo() {

        FileOutputStream fos = null;
        Map<String, String> confMaps = null;

        log.info("Initing DataBase driver config file.");

        prop.clear();
        try {
            fos = new FileOutputStream(CONF_FILE_NAME, true);
            confMaps = new HashMap<String, String>();

            String dbUserName = System.getenv("DB_USER_NAME");
            if (!"".equals(dbUserName) && null != dbUserName) {
                confMaps.put("spring.datasource.username", dbUserName);
            }

            String dbPassword = System.getenv("DB_PASSWORD");
            if (!"".equals(dbPassword) && null != dbPassword) {
                confMaps.put("spring.datasource.password", dbPassword);
            }

            String dbUrl = System.getenv("DB_URL");
            if (!"".equals(dbUrl) && null != dbUrl) {
                confMaps.put("spring.datasource.url", dbUrl);
            }

            log.debug("DB info : "+ confMaps);

            prop.putAll(confMaps);
            prop.store(fos, CONF_FILE_NAME);

            log.info("DataBase driver config file loading Successful. ");
        }catch (IOException e) {
            log.error("Write DataBase driver config file faild." + e.getMessage());
        } catch (Exception e) {
            log.error("Loading DataBase driver " + CONF_FILE_NAME + " error." + e.getMessage());
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public static void main(String[] args) {
//        ProperUtil prop = ProperUtil.getInstance();
//        prop.SetConfInfo();
//    }
}