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
        for (Document docs: rIndex.Index.get(query)) {
            result.add(docs.getUrl());
        }
        return result;
    }


}
