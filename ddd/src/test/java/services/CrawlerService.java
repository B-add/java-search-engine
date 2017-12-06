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

    public String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public ArrayList<Url> Crawl(Url url) throws IOException, URISyntaxException {
        Document doc = Jsoup.connect(url.getValue()).get();
        Elements links = doc.select("a");

        ArrayList<Url> listUrl = new ArrayList<Url>();

        for (Element l : links) {
            String linkValue = l.attr("href");
            if (linkValue.substring(0, 1).equals("/")) {
                linkValue = "http://" + this.getDomainName(url.getValue()) + linkValue;
            }
            listUrl.add(new Url(linkValue));
            System.out.println(linkValue);
        }

        return listUrl;
    }
}
