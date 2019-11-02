package Extras.Pramp;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

    static void helper (String initialKey, HashMap<String, String> returnDict, HashMap<String, Object> dict) {
        for (Map.Entry<String, Object> entry : dict.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                if (initialKey == null || initialKey.equals("")) {
                    returnDict.put(key, (String)value);
                } else {
                    returnDict.put(initialKey + "." + key, (String)value);
                }
            } else {
                if (initialKey == null || initialKey.equals("")) {
                    helper(key, returnDict, (HashMap<String, Object>) value);
                } else {
                    helper(initialKey + "." + key, returnDict, (HashMap<String, Object>) value);
                }
            }
        }
    }

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> returnDict = new HashMap<>();
        helper("", returnDict, dict);
        return returnDict;
    }

    public static void main(String[] args) {
        HashMap<String, Object> dict = new HashMap<>();
        dict.put("Key1", "1");
        dict.put("Key2", new HashMap<String, Object>());
        ((HashMap<String, Object>)(dict.get("Key2"))).put("a", "2");
        ((HashMap<String, Object>)(dict.get("Key2"))).put("b", "3");
        ((HashMap<String, Object>)(dict.get("Key2"))).put("c", new HashMap<String, Object>());
        ((HashMap<String, Object>)((HashMap<String, Object>)(dict.get("Key2"))).get("c")).put("d", "3");
        ((HashMap<String, Object>)((HashMap<String, Object>)(dict.get("Key2"))).get("c")).put("e", new HashMap<String, Object>());
        ((HashMap<String, Object>)((HashMap<String, Object>)((HashMap<String, Object>)(dict.get("Key2"))).get("c")).get("e")).put("", "1");
        HashMap<String, String> dict2 = flattenDictionary(dict);
    }

}
