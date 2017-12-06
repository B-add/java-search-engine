package services;

import models.Document;
import models.Term;
import models.Url;
import models.RetroIndex;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IndexerService {

    public static models.Document IndexUrl(Url url) {
        models.Document result = new models.Document(url);
        org.jsoup.nodes.Document doc;
        Map<String, ArrayList<Integer>> tokens = new HashMap<String, ArrayList<Integer>>();
        try {
            doc = Jsoup.connect(url.getValue()).get();
            String text = doc.body().text();
            Pattern p = Pattern.compile("[\\w&&\\D]{2,}");
            Matcher m = p.matcher(text);
            String token;
            int i = 0;
            while (m.find()) {
                token = text.substring(m.start(), m.end());
                if (tokens.containsKey(token)) {
                    tokens.get(token).add(i);
                } else {
                    tokens.put(token, new ArrayList<Integer>(Arrays.asList(i)));
                }
                i++;
            }
            result.setTerms(tokens);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public RetroIndex retroIndex = new RetroIndex();

    public void RetroIndexer(Document document) {
        ArrayList<Term> documentTerms = document.getTerms();

        for (Term term : documentTerms) {
            this.retroIndex.Index.put(term.getToken(), document);
        }
    }
}
