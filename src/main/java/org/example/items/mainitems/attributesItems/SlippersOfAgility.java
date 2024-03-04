package org.example.items.mainitems.attributesItems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SlippersOfAgility {
    private static final String URL = "https://dota2.fandom.com/ru/wiki/Slippers_of_Agility";
    private static final String URLDB = "https://www.dotabuff.com/items/slippers-of-agility";

    public static void getInfoAboutSlippersOfAgilityBuildsInto() throws IOException {

        Document db = Jsoup.connect(URLDB).get();

        System.out.println("Slippers of agility можно собрать в следующие предметы: ");
        for (Element table : db.select("div.order")) {
            for (Element row : table.select("div.image-container.image-container-icon.image-container-item")) {
                System.out.println(row.getElementsByAttribute("title").attr("title"));
            }
        }
    }

    public static void getInfoAboutChangelogs() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        Elements entries = doc.select(".updatetablebody #entry");

        System.out.println("Item slippers of Agility");

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
