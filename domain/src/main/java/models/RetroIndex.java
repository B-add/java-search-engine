package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RetroIndex {
    private final Map<String, ArrayList<Document>> index = new HashMap<String, ArrayList<Document>>();

    private static RetroIndex instance = new RetroIndex();

    public static RetroIndex getInstance() {
        return instance;
    }

    public ArrayList<Document> getDocs(String key) {
        return index.get(key);
    }

    public void addDocument(String key, Document doc) {
        ArrayList<Document> docs = index.containsKey(key) ? index.get(key) : new ArrayList<Document>();
        docs.add(doc);
        index.put(key, docs);
    }
}
