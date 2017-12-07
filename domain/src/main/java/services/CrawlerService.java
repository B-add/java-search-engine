package services;

import models.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.io.*;

public class CrawlerService {

    private static String getDomainName(String url) {
        try {
            URI uri = new URI(url);
            String domain = uri.getHost();
            return domain.startsWith("www.") ? domain.substring(4) : domain;
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static ArrayList<Url> crawl(Url url) {
        try {
            Document doc = Jsoup.connect(url.value).get();
            Elements links = doc.select("a");

            ArrayList<Url> listUrl = new ArrayList<Url>();

            for (Element l : links) {
                String linkValue = l.attr("href");
                if (linkValue.length() < 1 || linkValue.charAt(0) == '#') {
                    continue;
                }
                if (linkValue.charAt(0) == '/') {
                    String tmpDomain = getDomainName(url.value);
                    if (tmpDomain == null) {
                        continue;
                    }
                    linkValue = "http://" + tmpDomain + linkValue;
                }
                listUrl.add(new Url(linkValue));
            }
            return listUrl;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
