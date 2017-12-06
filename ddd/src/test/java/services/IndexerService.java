package services;

import models.Term;
import models.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by val on 06/12/17.
 */
public class IndexerService {

    public static models.Document IndexUrl(Url url) {
        models.Document result = new models.Document(url);
        Document doc;
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
}
