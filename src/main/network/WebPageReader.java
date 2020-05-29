package network;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebPageReader {

    public static String webPage() throws IOException {

        String webPage = "https://www.stack.com/a/heres-what-a-full-day-of-lebrons-meals-and-snacks-look-like";

        String html = Jsoup.connect(webPage).get().html();

        Document html1 = Jsoup.parse(html);

        String h1 = html1.body().getElementsByTag("ul").text();

        String[] tokens1 = h1.split(" Hotel Discounts ");

        String[] tokens2 = tokens1[2].split(" Lunch:");


        return tokens2[0];

    }


}

