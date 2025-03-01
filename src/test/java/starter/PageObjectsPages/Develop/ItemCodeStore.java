package starter.PageObjectsPages.Develop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCodeStore {

    public static Map<String, String> uniqueCodes = new HashMap<>();
    public static Map<String, String> DataStore = new HashMap<>();
    public static Map<String, List<String>> storeLists = new HashMap<>();
    public static void addUniqueCode(String example, String uniqueCode) {
        uniqueCodes.put(example, uniqueCode);
    }
    public static void storeTheData(String example, String data) {
        DataStore.put(example, data);
    }

    public static void storeLists(String example, List<String> listValues) {
        storeLists.put(example, listValues);
    }

    public static String getUniqueCode(String example) {
        return uniqueCodes.get(example);
    }
    public static String getStoredData(String example) {
        return DataStore.get(example);
    }
    public static List<String> getStoreList(String example) {
        return storeLists.get(example);
    }

    public static void clear() {
        uniqueCodes.clear();
    }
}
