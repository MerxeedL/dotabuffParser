package org.example.items.mainitems.consumablesItems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class SentryWard {

    private static final String URL = "https://dota2.fandom.com/ru/wiki/Sentry_Ward";
    private static final String duration = "//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[4]/td/table/tbody/tr[5]";
    private static final String reward = "//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[4]/td/table/tbody/tr[11]";
    private static final String experience = "//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[4]/td/table/tbody/tr[12]";
    private static final String cost = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[4]/td/table/tbody/tr[2]";
    private static final String ability = "//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[4]/td/table/tbody/tr[13]";
    private static final String sellingPrice = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[4]/td/table/tbody/tr[3]";

    public static void getInfoAboutSentryWard() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        System.out.println("Sentry ward info: ");

        System.out.println(doc.selectXpath(cost).text());
        System.out.println(doc.selectXpath(sellingPrice).text());
        System.out.println(doc.selectXpath(duration).text() + " секунд");
        System.out.println(doc.selectXpath(reward).text());
        System.out.println(doc.selectXpath(experience).text());
        System.out.println(doc.selectXpath(ability).text());
    }

}
