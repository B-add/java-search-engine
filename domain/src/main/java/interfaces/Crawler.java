package interfaces;

import models.Document;
import models.Url;

import java.util.Set;

/**
 * Created by val on 06/12/17.
 */
public interface Crawler {
    Set<Url> getUrls();
    Document crawl();
    void requestNextUrl();
}
