package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by val on 06/12/17.
 */
public final class Document {
    public final Url url;
    public final ArrayList<Term> terms = new ArrayList<Term>();

    public Document(Url url) {
        this.url = url;
    }

    public void setTerms(Map<String, ArrayList<Integer>> terms) {
        for (Map.Entry<String, ArrayList<Integer>> entry: terms.entrySet()) {
            this.terms.add(new Term(entry.getKey(), entry.getValue()));
        }
    }
}
