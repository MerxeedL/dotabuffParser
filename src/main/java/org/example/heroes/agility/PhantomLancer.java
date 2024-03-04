package org.example.heroes.agility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhantomLancer {

    private static final String URL = "https://dota2.fandom.com/ru/wiki/Phantom_Lancer/%D0%98%D0%B7%D0%BC%D0%B5%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F";


    public static void getInfoAboutPhantonLancer() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/phantom-lancer").get();

        for (Element table : doc.select("table.other")) {
            for (Element row : table.select("td")) {
                System.out.println(row.select("td").text());
            }
        }
    }

    public static void getInfoAboutPhantomLancerIsCounteredBy() throws IOException {

        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/phantom-lancer/counters/").get();

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

    public static void getInfoAboutPhantomLancerCounters() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/phantom-lancer/counters/").get();

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

    public static void getInfoAboutChangelogs() throws IOException, NullPointerException {

        Document doc = Jsoup.connect(URL).get();

        Elements entries = doc.select(".updatetablebody #entry");

        System.out.println("Phantom lancer: ");

        for (Element entry : entries) {
            Element version = entry.selectFirst("#version");
            assert version != null;
            String versionText = Objects.requireNonNull(version).text();

            Element description = entry.selectFirst("#description");
            assert description != null;
            String descriptionText = Objects.requireNonNull(description).text();

            System.out.println("Version: " + versionText);
            System.out.println("Description: " + descriptionText);
        }
    }
}
