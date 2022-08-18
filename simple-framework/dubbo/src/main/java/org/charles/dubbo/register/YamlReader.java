package org.charles.dubbo.register;

import org.yaml.snakeyaml.Yaml;

//import org.ho.yaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class YamlReader {

    private static Map<String, Map<String, Object>> properties = new HashMap<>();
    private static String ymlPath = "classpath:application.yml";
    /**
     * 单例
     */
    public static final YamlReader instance = new YamlReader();

    static {
//        File dumpFile = new File(System.getProperty("user.dir") + "/test/src/main/conf/testYaml.yaml");
//        try {
//            Object yml = Yaml.load(dumpFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        String path = YamlReader.class.getResource("/").getPath().toString();
//        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("/application.yml");
        Yaml yaml = new Yaml();
        try (InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.yml")) {
            properties = yaml.loadAs(resource, HashMap.class);
        } catch (Exception e) {
            System.out.println("Init yaml failed !");
            ;
        }
    }

    /**
     * get yaml property
     *
     * @param key
     * @return
     */
    public Object getValueByKey(String key) {
        String separator = ".";
        String[] separatorKeys = null;
        if (key.contains(separator)) {
            separatorKeys = key.split("\\.");
        } else {
            return properties.get(key);
        }
        Map<String, Map<String, Object>> finalValue = new HashMap<>();
        for (int i = 0; i < separatorKeys.length - 1; i++) {
            if (i == 0) {
                finalValue = (Map) properties.get(separatorKeys[i]);
                continue;
            }
            if (finalValue == null) {
                break;
            }
            finalValue = (Map) finalValue.get(separatorKeys[i]);
        }
        return finalValue == null ? null : finalValue.get(separatorKeys[separatorKeys.length - 1]);
    }
}
