package org.example.items.mainitems.attributesItems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

public class GauntletsOfStrength {

    private static final String URL = "https://dota2.fandom.com/wiki/Gauntlets_of_Strength";
    private static final String URLDB = "https://www.dotabuff.com/items/gauntlets-of-strength";
    private static final String bonuses = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[4]/td/table/tbody/tr[4]/td[2]";
    private static final String cost = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[4]/td/table/tbody/tr[2]";
    private static final String sell = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[4]/td/table/tbody/tr[3]";

    public static void getInfoAboutGauntletsOfStrength() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        System.out.println(doc.selectXpath(bonuses).text());

    }

    public static void getInfoAboutGauntletsOfStrengthBuildsInto() throws IOException {

        Document db = Jsoup.connect(URLDB).get();

        System.out.println("Gauntlets of strength можно собрать в следующие предметы: ");
        for (Element table : db.select("div.order")) {
            for (Element row : table.select("div.image-container.image-container-icon.image-container-item")) {
                System.out.println(row.getElementsByAttribute("title").attr("title"));
            }
        }
    }

    public static void getInfoAboutGauntletsOfStrengthCost() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        System.out.println(doc.selectXpath(cost).text());
        System.out.println(doc.selectXpath(sell).text());

    }

    public static void getInfoAboutChangelogs() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        Elements entries = doc.select(".updatetablebody #entry");

        System.out.println("Item Gauntlets of strength");

        for (Element entry: entries) {
            Element version = entry.selectFirst("#version");
            assert version != null;
            String versionText = version.text();

            Element description = entry.selectFirst("#description");
            assert description != null;
            String descriptionText = description.text();

            System.out.println("Version: " + versionText);
            System.out.println("Description: " + descriptionText);
        }
    }
}
