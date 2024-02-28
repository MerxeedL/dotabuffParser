package org.example.items.mainitems.consumablesItems;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.xml.xpath.*;

import java.io.IOException;

public class ObserverWard {

    private static final String URL = "https://dota2.fandom.com/ru/wiki/Observer_Ward";
    private static final String duration = "//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr[4]/td/table/tbody/tr[5]";
    private static final String viewingRange = "//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr[4]/td/table/tbody/tr[10]";
    private static final String reward = "//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr[4]/td/table/tbody/tr[11]";
    private static final String experience = "//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr[4]/td/table/tbody/tr[12]";
    private static final String cost = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[4]/td/table/tbody/tr[2]";

    public static void getInfoAboutObserverWard() throws IOException {

        Document doc = Jsoup.connect(URL).get();
        System.out.println("Observer ward info: ");

        System.out.println(doc.selectXpath(cost).text());
        System.out.println(doc.selectXpath(duration).text() + " секунд");
        System.out.println(doc.selectXpath(viewingRange).text().replaceAll("\\s\\(Н\\)", ""));
        System.out.println(doc.selectXpath(reward).text());
        System.out.println(doc.selectXpath(experience).text());
        System.out.println("Способности нет");

    }
}
