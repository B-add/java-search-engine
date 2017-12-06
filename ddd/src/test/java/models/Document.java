package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by val on 06/12/17.
 */
public final class Document {
    private Url url;
    private ArrayList<Term> terms;

    public Document(Url url) {
        this.url = url;
    }

    public Url getUrl() {
        return url;
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<Term> terms) {
        this.terms = terms;
    }

    public void setTerms(Set<Term> terms) {
        this.terms.addAll(terms);
    }

    public void setTerms(Map<String, ArrayList<Integer>> terms) {
        if (this.terms == null) {
            this.terms = new ArrayList<Term>();
        }
        for (Map.Entry<String, ArrayList<Integer>> entry: terms.entrySet()) {
            this.terms.add(new Term(entry.getKey(), entry.getValue()));
        }
    }
}
