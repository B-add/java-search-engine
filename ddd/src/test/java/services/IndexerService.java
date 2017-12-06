package services;

import models.Document;
import models.Term;
import models.Url;
import models.RetroIndex;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IndexerService {

    public RetroIndex retroIndex = new RetroIndex();

    public static Document IndexUrl(Url url) {
//        Document doc = Jsoup.connect(url.getValue()).get();
//        Elements newsHeadlines = doc.select("#mp-itn b a");
//        for (Element headline : newsHeadlines) {
//            log("%s\n\t%s",
//                    headline.attr("title"), headline.absUrl("href"));
//        }
        return null;
    }

    public void RetroIndexer(Document document) {
        ArrayList<Term> documentTerms = document.getTerms();

        for (Term term : documentTerms) {
            this.retroIndex.Index.put(term.getToken(), document);
        }
    }
}
