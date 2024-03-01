package org.example.items.mainitems.attributesItems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Diadem {

    private static final String URL = "https://dota2.fandom.com/ru/wiki/Diadem";
    private static final String URLDB = "https://www.dotabuff.com/items/diadem";
    private static final String cost = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[3]/td/table/tbody/tr[2]";
    private static final String sell = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[3]/td/table/tbody/tr[3]";
    private static final String bonuses = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[3]/td/table/tbody/tr[4]/td[2]";


    public static void getInfoAboutDiadem() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        System.out.println(doc.selectXpath(bonuses).text());

    }

    public static void getInfoAboutDiademBuildsInto() throws IOException {

        Document db = Jsoup.connect(URLDB).get();

        System.out.println("Diadem можно собрать в следующие предметы: ");
        for (Element table : db.select("div.order")) {
            for (Element row : table.select("div.image-container.image-container-icon.image-container-item")) {
                System.out.println(row.getElementsByAttribute("title").attr("title"));
            }
        }
    }

    public static void getInfoAboutDiademsCost() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        System.out.println(doc.selectXpath(cost).text());
        System.out.println(doc.selectXpath(sell).text());

    }
}
