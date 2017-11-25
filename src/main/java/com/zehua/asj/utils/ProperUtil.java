package com.zehua.asj.utils;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ProperUtil {

    private static final Logger log = Logger.getLogger(ProperUtil.class);

    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "password";
    public static final String DB_URL = "127.0.0.1";
    public static final String DB_PORT = "3306";
    public static final String CONF_FILE_NAME = "application.properties";

    private ProperUtil() {
    }

    private static class ProperiesUtil {
        private static final ProperUtil INSTANCE = new ProperUtil();
    }

    public static ProperUtil getInstance() {
        return ProperiesUtil.INSTANCE;
    }

    public List<Map<String, String>> GetDBEnvInfo() {

        List<Map<String, String>> confList = new ArrayList<Map<String, String>>();
        Map<String, String> confMaps = new HashMap<String, String>();

        String dbUserName = System.getenv("DB_USER_NAME");
        if ("".equals(dbUserName) || null == dbUserName) {
            dbUserName = DB_USER_NAME;
//            log.debug("Get ENV BD_USER_NAME faild.");
        }
        confMaps.put("DB_USER_NAME", dbUserName);

        String dbPassword = System.getenv("DB_PASSWORD");
        if ("".equals(dbPassword) || null == dbPassword) {
            dbPassword = DB_PASSWORD;
//            log.debug("Get ENV DB_PASSWORD faild.");
        }
        confMaps.put("DB_PASSWORD", dbPassword);

        String dbUrl = System.getenv("DB_URL");
        if ("".equals(dbUrl) || null == dbUrl) {
            dbUrl = DB_URL;
//            log.debug("Get ENV DB_URL faild.");
        }
        confMaps.put("DB_URL", dbUrl);

        String dbPort = System.getenv("DB_PORT");
        if ("".equals(dbPort) || null == dbPort) {
            dbPort = DB_PORT;
        }
        confMaps.put("DB_PORT", dbPort);

        confList.add(confMaps);
        return confList;
    }

    public void SetConfInfo() {

        Properties prop = new Properties();
        FileOutputStream fos = null;
        Map<String, String> toSaveConf = null;
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(CONF_FILE_NAME);

        log.info("Loading config start.");

        try {
            prop.load(in);
            List<Map<String, String>> configList = ProperUtil.getInstance().GetDBEnvInfo();

            fos = new FileOutputStream(CONF_FILE_NAME, true);

            toSaveConf = new HashMap<String, String>();
            for (int i = 0 ; i < configList.size() ; i++ ) {
                for (Map.Entry<String, String> info : configList.get(i).entrySet()) {
                    if (info.getKey() == "DB_USER_NAME") {
                        toSaveConf.put("spring.datasource.username", info.getValue());
                    } else if (info.getKey() == "DB_PASSWORD") {
                        toSaveConf.put("spring.datasource.password", info.getValue());
                    } else if (info.getKey() == "DB_URL") {
                        toSaveConf.put("spring.datasource.url", "jdbc:mysql://" + info.getValue() + ":3306/spring?characterEncoding=utf8&useSSL=false");
                    } else {
                        continue;
                    }
                }
            }
            prop.putAll(toSaveConf);
            prop.store(fos, CONF_FILE_NAME);

            log.info("Config file has loaded. ");
        } catch (Exception e) {
            log.error("Loading " + CONF_FILE_NAME + "error." + e.getMessage());
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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