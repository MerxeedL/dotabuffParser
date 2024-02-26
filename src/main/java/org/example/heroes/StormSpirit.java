package org.example.heroes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StormSpirit {

    public static void getInfoAboutStormSpirit() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/storm-spirit").get();

        for (Element table : doc.select("table.other")) {
            for (Element row : table.select("td")) {
                System.out.println(row.select("td").text());
            }
        }
    }

    public static void getInfoAboutStormSpiritIsCounteredBy() throws IOException {

        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/storm-spirit/counters/").get();

        List<String> list = new ArrayList<>();


        for (Element table : doc.select("table.sortable")) {
            for (Element row : table.select("td.cell-xlarge")) {
                list.add(row.select("a").text());
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void getInfoAboutStormSpiritCounters() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/storm-spirit/counters/").get();

        List<String> list = new ArrayList<>();


        for (Element table : doc.select("table.sortable")) {
            for (Element row : table.select("td.cell-xlarge")) {
                list.add(row.select("a").text());
            }
        }
        for (int i = list.size() - 1; i >= list.size() - 5; i--) {
            System.out.println(list.get(i));
        }
    }
}
