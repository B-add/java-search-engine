package main.java.models;

import java.util.ArrayList;

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
}
