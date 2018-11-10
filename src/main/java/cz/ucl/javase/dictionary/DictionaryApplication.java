package cz.ucl.javase.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DictionaryApplication {

    public static void main(String[] args) {
        new DictionaryApplication().start();
    }

    private void start() {
        PropertyReader propertyReader = new PropertyReader();

        Properties dictionaryCsDe = propertyReader.readProperties("cs_de.properties");
        Properties dictionaryDeEn = propertyReader.readProperties("de_en.properties");
        Properties dictionaryEnCs = propertyReader.readProperties("en_cs.properties");

        Map<String, String> mapCsDe = getMapFromProperties(dictionaryCsDe);
        Map<String, String> mapDeEn = getMapFromProperties(dictionaryDeEn);
        Map<String, String> mapEnCs = getMapFromProperties(dictionaryEnCs);

        for (String cs : mapCsDe.keySet()) {
            String de = mapCsDe.get(cs);
            if (de != null) {
                String en = mapDeEn.get(de);
                if (en != null) {
                    System.out.println(cs + "," + de + "," + en);
                }
            }
        }

        Map<String, String> mapDeCs = invertMap(mapCsDe);
        Map<String, String> mapCsEn = invertMap(mapEnCs);
        Map<String, String> mapEnDe = invertMap(mapDeEn);

        Map<String, String> mapCsDeDerived = new HashMap<>();

        for (String cs: mapCsEn.keySet()) {
            if (!mapCsDe.containsKey(cs)) {
                String en = mapCsEn.get(cs);
                String de = mapEnDe.get(en);

                if (de != null) {
                    mapCsDeDerived.put(cs, de);
                }
            }
        }

        for (String key : mapCsDeDerived.keySet()) {
            System.out.println(key + ":" + mapCsDeDerived.get(key));
        }

    }

    private Map<String,String> invertMap(Map<String, String> map) {
        Map<String, String> invertedMap = new HashMap<>();
        for (String key : map.keySet()) {
            invertedMap.put(map.get(key), key);
        }
        return invertedMap;
    }


    private Map<String, String> getMapFromProperties(Properties properties) {
        Map<String, String> map = new HashMap<>();
        for (final String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name));
        }
        return map;
    }

}
