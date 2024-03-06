package org.example.heroes.agility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhantomLancer {

    private static final String URLLogs = "https://dota2.fandom.com/ru/wiki/Phantom_Lancer/Изменения";
    private static final String URLTalents = "https://dota2.fandom.com/ru/wiki/Phantom_Lancer/Таланты";
    private static final String URLCounters = "https://www.dotabuff.com/heroes/phantom-lancer/counters/";
    private static final String URLHero = "https://www.dotabuff.com/heroes/phantom-lancer";
    private static final String URLAbilities = "https://www.dotabuff.com/heroes/phantom-lancer/abilities";


    public static void getInfoAboutPhantomLancer() throws IOException {
        Document doc = Jsoup.connect(URLHero).get();

        for (Element table : doc.select("table.other")) {
            for (Element row : table.select("td")) {
                System.out.println(row.select("td").text());
            }
        }
    }

    public static void getInfoAboutPhantomLancerIsCounteredBy() throws IOException {

        Document doc = Jsoup.connect(URLCounters).get();

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
        Document doc = Jsoup.connect(URLCounters).get();

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

    private static void Ability(Element ability) {
        Elements entries = ability.select("div.stat.effect");

        for (Element entry : entries) {

            Element label = entry.selectFirst("span.label");
            assert label != null;
            String labelText = label.text();

            Element values = entry.selectFirst("span.values");
            assert values != null;
            String valueText = values.text();

            System.out.println(labelText + " " + valueText);
        }
    }

    public static void getInfoAboutPhantomLancerFirstAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Element firstAbility = doc.selectFirst(".stats");

        if (firstAbility != null) {

            System.out.println(doc.selectFirst("header")
                    .text()
                    .toUpperCase()
                    .replaceAll("Q", ""));

            Ability(firstAbility);
        }
    }

    public static void getInfoAboutPhantomLancerSecondAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements stats = doc.select(".stats");

        if (stats.size() >= 2) {

            System.out.println(doc.getElementsByTag("header")
                    .get(1)
                    .text()
                    .toUpperCase()
                    .replaceAll("W", ""));

            Element SecondAbility = stats.get(1);
            Ability(SecondAbility);
        }
    }

    public static void getInfoAboutPhantomLancerThirdAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements stats = doc.select(".stats");

        if (stats.size() >= 3) {

            System.out.println(doc.getElementsByTag("header")
                    .get(2)
                    .text()
                    .toUpperCase()
                    .replaceAll("E", ""));

            Element ThirdAbility = stats.get(2);
            Ability(ThirdAbility);
        }
    }

    public static void getInfoAboutPhantomLancerUltimateAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements stats = doc.select(".stats");

        if (stats.size() >= 4) {

            System.out.println(doc.getElementsByTag("header")
                    .get(3)
                    .text()
                    .toUpperCase()
                    .replaceAll("R", ""));

            Element UltimateAbility = stats.get(3);
            Ability(UltimateAbility);
        }
    }

    public static void getInfoAboutPhantomLancerChangelogs() throws IOException {

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

    public static void getInfoAboutPhantomLancerChangeUpdateLogs() throws IOException {
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

    public static void getInfoAboutPhantomLancerTalents() throws IOException {

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