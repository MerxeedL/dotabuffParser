package org.example.items.mainitems.secretShopItems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UltimateOrb {

    private static final String URL = "https://dota2.fandom.com/ru/wiki/Ultimate_Orb";

    public static void getInfoAboutChangelogs() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        Elements entries = doc.select(".updatetablebody #entry");

        for (Element entry: entries) {
            Element version = entry.selectFirst("#version");
            String versionText = version.text();

            Element description = entry.selectFirst("#description");
            String descriptionText = description.text();

            System.out.println("Version: " + versionText);
            System.out.println("Description: " + descriptionText);
        }
    }

}
