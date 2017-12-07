package interfaces;

import models.Url;

import java.util.Set;

/**
 * Created by val on 06/12/17.
 */
public interface UrlRepository {
    void provideUrl(Crawler crawler);
    void registerUrls(Set<Url> urls);
}
