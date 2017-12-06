package main.interfaces;

import main.java.models.Document;
import main.java.models.Url;

import java.util.Set;

/**
 * Created by val on 06/12/17.
 */
public interface ICrawler {
    public Set<Url> getUrls();
    public Document crawl();
    public void requestNextUrl();
}
