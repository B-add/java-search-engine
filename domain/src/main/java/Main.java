import models.Document;
import models.RetroIndex;
import models.Term;
import models.Url;
import services.CrawlerService;
import services.IndexerService;
import services.QueryService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by val on 06/12/17.
 */
public class Main {
    public static void main(final String[] args) {
        ArrayList<Url> urls = CrawlerService.crawl(new Url("https://fr.wikipedia.org/wiki/R%C3%A9seau_des_sports"));
        Document tmpDoc;
        int i = 20;
        assert urls != null;
        for (Url url: urls) {
            if (i == 0) {
                break;
            }
            tmpDoc = IndexerService.indexUrl(url);
            if (tmpDoc != null) {
                IndexerService.retroIndex(tmpDoc);
            }
            i--;
        }
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a research: ");
        String query;
        while (!(query = reader.next()).isEmpty()) {
            for (Url url: QueryService.query(query, RetroIndex.getInstance())) {
                System.out.println(url.value);
            }
            System.out.println("Enter a research: ");
        }
        reader.close();

    }
}