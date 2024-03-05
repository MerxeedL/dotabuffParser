package org.example.heroes.agility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Morphling {
    private static final String URLLogs = "https://dota2.fandom.com/ru/wiki/Morphling/Изменения";
    private static final String URLTalents = "https://dota2.fandom.com/ru/wiki/Morphling/Таланты";
    public static void getInfoAboutMorphling() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/morphling").get();

        for (Element table : doc.select("table.other")) {
            for (Element row : table.select("td")) {
                System.out.println(row.select("td").text());
            }
        }
    }

    public static void getInfoAboutMorphlingIsCounteredBy() throws IOException {

        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/morphling/counters/").get();

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

    public static void getInfoAboutMorphlingCounters() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/morphling/counters/").get();

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

    public static void getInfoAboutMorphlingChangelogs() throws IOException {

        Document doc = Jsoup.connect(URLLogs).get();

        Element updatetablebodyElements = doc.selectFirst(".updatetablebody");

        if (updatetablebodyElements != null) {
            Elements entries = updatetablebodyElements.select("#entry");
            for (Element entry : entries) {
                Element version = entry.selectFirst("#version");

                String versionText = version.text();

                Element description = entry.selectFirst("#description");
                String descriptionText = description.text();

                System.out.println("Version: " + versionText);
                System.out.println("Description: " + descriptionText);
            }
        }
    }

    public static void getInfoAboutMorphlingChangeUpdateLogs() throws IOException {
        Document doc = Jsoup.connect(URLLogs).get();

        Elements updatetablebodyElements = doc.select(".updatetablebody");

        if (updatetablebodyElements.size() >= 2) {
            Element secondUpdatetablebody = updatetablebodyElements.get(1);
            Elements entries = secondUpdatetablebody.select("#entry");

            for (Element entry : entries) {
                Element patch = entry.selectFirst("#patch");
                String patchText = patch.text();

                Element description = entry.selectFirst("#description");
                String descriptionText = description.text();

                System.out.println("Patch: " + patchText);
                System.out.println("Description: " + descriptionText.replaceAll("Н\\s", ""));
            }
        }
    }

    public static void getInfoAboutMorphlingTalents() throws IOException {

        Document doc = Jsoup.connect(URLTalents).get();

        for (Element table : doc.select("table.wikitable")) {
            for (Element row : table.select("tr")) {
                System.out.println(row.select("tr").text()
                        .replaceAll("\\s25\\s", " / ")
                        .replaceAll("\\s20\\s", " / ")
                        .replaceAll("\\s15\\s", " / ")
                        .replaceAll("\\s10\\s", " / "));
            }
        }
    }

}
