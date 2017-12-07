package services;

import models.Document;
import models.RetroIndex;
import models.Url;

import java.util.ArrayList;

/**
 * Created by val on 06/12/17.
 */
public class QueryService {
    public static ArrayList<Url> query(String query, RetroIndex rIndex) {
        ArrayList<Url> result = new ArrayList<Url>();
        ArrayList<Document> docs = rIndex.getDocs(query);
        if (docs == null) {
            return result;
        }
        for (Document doc: docs) {
            result.add(doc.url);
        }
        return result;
    }
}
