package services;

import models.Document;
import models.RetroIndex;
import models.Term;
import models.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IndexerService {

    private static final String pattern = "[\\w&&\\D]{2,}";

    public static Document indexUrl(Url url) {
        Document result = new Document(url);
        org.jsoup.nodes.Document doc;
        Map<String, ArrayList<Integer>> tokens = new HashMap<String, ArrayList<Integer>>();
        try {
            System.out.println(url.value);
            doc = Jsoup.connect(url.value).get();
            Element body = doc.body();
            if (!body.hasText()) {
                return null;
            }
            String text = body.text();
            Pattern p = Pattern.compile(pattern);
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
            return result;
        } catch (org.jsoup.HttpStatusException e) {
            System.out.println("404");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void retroIndex(Document document) {
        ArrayList<Term> documentTerms = document.terms;

        for (Term term : documentTerms) {
            RetroIndex.getInstance().addDocument(term.token, document);
        }
    }
}
