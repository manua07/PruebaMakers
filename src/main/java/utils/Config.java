package utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    static {
        initialize();
    }

    public static void initialize(){

        // load default properties
        properties = loadProperties();

        // override properties
        for (String key: properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }

        for (String key: properties.stringPropertyNames()){
            log.info("{}={}", key, properties.getProperty(key));
        }
    }

    public static String get(String key){
        return  properties.getProperty(key);
    }

    public static Properties loadProperties(){
        Properties properties = new Properties();
        try(InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)){
            properties.load(stream);
        }catch (Exception e) {
            log.error(DEFAULT_PROPERTIES, e);
        }
        return properties;
    }


}
