package org.example.heroes.agility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.RMI.Ability.getAbility;

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

    public static void getInfoAboutPhantomLancerFirstAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Element firstAbilityEffect = doc.selectFirst(".effects");
        Element firstAbility = doc.selectFirst(".stats");
        Element firstAbilityCooldown = doc.selectFirst(".cooldown_and_cost");
        Element firstAbilityManacost = doc.selectFirst(".cooldown_and_cost");
        Element firstAbilityDescription = doc.selectFirst(".description");
        Element firstAbilityLore = doc.selectFirst(".lore");

        if (firstAbility != null) {

            for (Element big : doc.getElementsByTag("big")) {
                big.remove();
            }

            System.out.println(doc.selectFirst("header")
                    .text()
                    .toUpperCase());

            assert firstAbilityCooldown != null;
            assert firstAbilityManacost != null;
            assert firstAbilityDescription != null;
            assert firstAbilityLore != null;

            getAbility(firstAbilityEffect, firstAbility, firstAbilityCooldown, firstAbilityManacost, firstAbilityDescription, firstAbilityLore);
        }
    }

    public static void getInfoAboutPhantomLancerSecondAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements effects = doc.select(".effects");
        Elements stats = doc.select(".stats");
        Elements cooldown = doc.select(".cooldown_and_cost");
        Elements manacost = doc.select(".cooldown_and_cost");
        Elements description = doc.select(".description");
        Elements lore = doc.select(".lore");

        if (stats.size() >= 2) {

            for (Element big : doc.getElementsByTag("big")) {
                big.remove();
            }

            System.out.println(doc.getElementsByTag("header")
                    .get(1)
                    .text()
                    .toUpperCase());

            Element secondEffects = effects.get(1);
            Element secondAbility = stats.get(1);
            Element secondAbilityCooldown = cooldown.get(1);
            Element secondAbilityManacost = manacost.get(1);
            Element secondAbilityDescription = description.get(1);
            Element secondAbilityLore = lore.get(1);
            getAbility(secondEffects, secondAbility, secondAbilityCooldown, secondAbilityManacost, secondAbilityDescription, secondAbilityLore);
        }
    }

    public static void getInfoAboutPhantomLancerThirdAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements effects = doc.select(".effects");
        Elements stats = doc.select(".stats");
        Elements cooldown = doc.select(".cooldown_and_cost");
        Elements manacost = doc.select(".cooldown_and_cost");
        Elements description = doc.select(".description");
        Elements lore = doc.select(".lore");

        if (stats.size() >= 3) {

            for (Element big : doc.getElementsByTag("big")) {
                big.remove();
            }

            System.out.println(doc.getElementsByTag("header")
                    .get(2)
                    .text()
                    .toUpperCase());

            Element thirdEffects = effects.get(2);
            Element thirdAbility = stats.get(2);
            Element thirdAbilityCooldown = cooldown.get(2);
            Element thirdAbilityManacost = manacost.get(2);
            Element thirdAbilityDescription = description.get(2);
            Element thirdAbilityLore = lore.get(2);
            getAbility(thirdEffects, thirdAbility, thirdAbilityCooldown, thirdAbilityManacost, thirdAbilityDescription, thirdAbilityLore);
        }
    }

    public static void getInfoAboutPhantomLancerUltimateAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements effects = doc.select(".effects");
        Elements stats = doc.select(".stats");
        Elements cooldown = doc.select(".cooldown_and_cost");
        Elements manacost = doc.select(".cooldown_and_cost");
        Elements description = doc.select(".description");
        Elements lore = doc.select(".lore");

        if (stats.size() >= 4) {

            for (Element big : doc.getElementsByTag("big")) {
                big.remove();
            }

            System.out.println(doc.getElementsByTag("header")
                    .get(3)
                    .text()
                    .toUpperCase());

            Element ultimateAbilityEffects = effects.get(3);
            Element ultimateAbility = stats.get(3);
            Element ultimateAbilityCooldown = cooldown.get(3);
            Element ultimateAbilityManacost = manacost.get(3);
            Element ultimateAbilityDescription = description.get(3);
            Element ultimateAbilityLore = lore.get(3);
            getAbility(ultimateAbilityEffects, ultimateAbility, ultimateAbilityCooldown, ultimateAbilityManacost, ultimateAbilityDescription, ultimateAbilityLore);
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