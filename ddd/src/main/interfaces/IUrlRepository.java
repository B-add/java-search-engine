package main.interfaces;

import main.java.models.Url;

import java.util.Set;

/**
 * Created by val on 06/12/17.
 */
public interface IUrlRepository {
    public void provideUrl(ICrawler crawler);
    public void registerUrls(Set<Url> urls);
}
