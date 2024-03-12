package org.example.heroes.agility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.RMI.Ability.getAbility;

public class AntiMage {
    private static final String URLLogs = "https://dota2.fandom.com/ru/wiki/Anti-Mage/%D0%98%D0%B7%D0%BC%D0%B5%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F    ";
    private static final String URLTalents = "https://dota2.fandom.com/ru/wiki/Anti-Mage/%D0%A2%D0%B0%D0%BB%D0%B0%D0%BD%D1%82%D1%8B";
    private static final String URLAbilities = "https://www.dotabuff.com/heroes/anti-mage/abilities";

    public static void getInfoAboutAntiMage() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/anti-mage").get();

        for (Element table : doc.select("table.other")) {
            for (Element row : table.select("td")) {
                System.out.println(row.select("td").text());
            }
        }
    }

    public static void getInfoAboutAntiMageIsCounteredBy() throws IOException {

        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/anti-mage/counters/").get();

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

    public static void getInfoAboutAntiMageCounters() throws IOException {
        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/anti-mage/counters/").get();

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
    public static void getInfoAboutAntiMageFirstAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();

        Element firstAbilityEffects = doc.selectFirst(".effects");
        Element firstAbilityStats = doc.selectFirst(".stats");
        Element firstAbilityCooldown = doc.selectFirst(".cooldown_and_cost");
        Element firstAbilityManacost = doc.selectFirst(".cooldown_and_cost");
        Element firstAbilityNotes = doc.selectFirst(".notes");
        Element firstAbilityDescription = doc.selectFirst(".description");
        Element firstAbilityLore = doc.selectFirst(".lore");

        if (firstAbilityStats != null) {

            for (Element big : doc.getElementsByTag("big")) {
                big.remove();
            }

            System.out.println(doc.selectFirst("header")
                    .text()
                    .toUpperCase());

            assert firstAbilityEffects != null;
            assert firstAbilityCooldown != null;
            assert firstAbilityManacost != null;
            assert firstAbilityNotes != null;
            assert firstAbilityDescription != null;
            assert firstAbilityLore != null;

            getAbility(firstAbilityEffects, firstAbilityNotes, firstAbilityStats, firstAbilityCooldown, firstAbilityManacost, firstAbilityDescription, firstAbilityLore);
        }
    }

    public static void getInfoAboutAntiMageSecondAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();

        Elements secondAbilityEffects = doc.select(".effects");
        Elements secondAbilityStats = doc.select(".stats");
        Elements secondAbilityCooldowns = doc.select(".cooldown_and_cost");
        Elements secondAbilityManacosts = doc.select(".cooldown_and_cost");
        Elements secondAbilityNotes = doc.select(".notes");
        Elements secondAbilityDescriptions = doc.select(".description");
        Elements secondAbilityLores = doc.select(".lore");

        for (Element big : doc.getElementsByTag("big")) {
            big.remove();
        }

        System.out.println(doc.getElementsByTag("header")
                .get(1)
                .text()
                .toUpperCase());

        Element secondAbilityEffect = secondAbilityEffects.get(1);
        Element secondAbilityStat = secondAbilityStats.get(1);
        Element secondAbilityCooldown = secondAbilityCooldowns.get(1);
        Element secondAbilityManacost = secondAbilityManacosts.get(1);
        Element secondAbilityNote = secondAbilityNotes.get(1);
        Element secondAbilityDescription = secondAbilityDescriptions.get(1);
        Element secondAbilityLore = secondAbilityLores.get(1);
        getAbility(secondAbilityEffect, secondAbilityNote, secondAbilityStat, secondAbilityCooldown, secondAbilityManacost, secondAbilityDescription, secondAbilityLore);
    }

    public static void getInfoAboutAntiMageThirdAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();

        Elements thirdAbilityEffects = doc.select(".effects");
        Elements thirdAbilityStats = doc.select(".stats");
        Elements thirdAbilityCooldowns = doc.select(".cooldown_and_cost");
        Elements thirdAbilityManacosts = doc.select(".cooldown_and_cost");
        Elements thirdAbilityNotes = doc.select(".notes");
        Elements thirdAbilityDescriptions = doc.select(".description");
        Elements thirdAbilityLores = doc.select(".lore");

        for (Element big : doc.getElementsByTag("big")) {
            big.remove();
        }

        System.out.println(doc.getElementsByTag("header")
                .get(2)
                .text()
                .toUpperCase());

        Element thirdAbilityEffect = thirdAbilityEffects.get(2);
        Element thirdAbilityStat = thirdAbilityStats.get(2);
        Element thirdAbilityCooldown = thirdAbilityCooldowns.get(2);
        Element thirdAbilityManacost = thirdAbilityManacosts.get(2);
        Element thirdAbilityNote = thirdAbilityNotes.get(2);
        Element thirdAbilityDescription = thirdAbilityDescriptions.get(2);
        Element thirdAbilityLore = thirdAbilityLores.get(2);
        getAbility(thirdAbilityEffect, thirdAbilityNote, thirdAbilityStat, thirdAbilityCooldown, thirdAbilityManacost, thirdAbilityDescription, thirdAbilityLore);
    }

    public static void getInfoAboutAntiMageOptionalFirstAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();

        Elements firstOptionalAbilityEffects = doc.select(".effects");
        Elements firstOptionalAbilityStats = doc.select(".stats");
        Elements firstOptionalAbilityCooldowns = doc.select(".cooldown_and_cost");
        Elements firstOptionalAbilityManacosts = doc.select(".cooldown_and_cost");
        Elements firstOptionalAbilityNotes = doc.select(".notes");
        Elements firstOptionalAbilityDescriptions = doc.select(".description");
        Elements firstOptionalAbilityLores = doc.select(".lore");

        for (Element big : doc.getElementsByTag("big")) {
            big.remove();
        }

        System.out.println(doc.getElementsByTag("header")
                .get(3)
                .text()
                .toUpperCase());

        Element firstOptionalAbilityEffect = firstOptionalAbilityEffects.get(3);
        Element firstOptionalAbilityStat = firstOptionalAbilityStats.get(3);
        Element firstOptionalCooldown = firstOptionalAbilityCooldowns.get(3);
        Element firstOptionalManacost = firstOptionalAbilityManacosts.get(3);
        Element firstOptionalNote = firstOptionalAbilityNotes.get(2);
        Element firstOptionalDescription = firstOptionalAbilityDescriptions.get(3);
        Element firstOptionalLore = firstOptionalAbilityLores.get(3);

        getAbility(firstOptionalAbilityEffect, firstOptionalNote, firstOptionalAbilityStat, firstOptionalCooldown, firstOptionalManacost, firstOptionalDescription, firstOptionalLore);
    }

    public static void getInfoAboutAntiMageOptionalSecondAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();

        Elements secondOptionalAbilityEffects = doc.select(".effects");
        Elements secondOptionalAbilityStats = doc.select(".stats");
        Elements secondOptionalAbilityCooldowns = doc.select(".cooldown_and_cost");
        Elements secondOptionalAbilityManacosts = doc.select(".cooldown_and_cost");
        Elements secondOptionalAbilityNotes = doc.select(".notes");
        Elements secondOptionalAbilityDescriptions = doc.select(".description");
        Elements secondOptionalAbilityLores = doc.select(".lore");

        for (Element big : doc.getElementsByTag("big")) {
            big.remove();
        }

        System.out.println(doc.getElementsByTag("header")
                .get(4)
                .text()
                .toUpperCase());

        Element secondOptionalAbilityEffect = secondOptionalAbilityEffects.get(4);
        Element secondOptionalStat = secondOptionalAbilityStats.get(4);
        Element secondOptionalCooldown = secondOptionalAbilityCooldowns.get(4);
        Element secondOptionalManacost = secondOptionalAbilityManacosts.get(4);
        Element secondOptionalNote = secondOptionalAbilityNotes.get(2);
        Element secondOptionalDescription = secondOptionalAbilityDescriptions.get(4);
        Element secondOptionalLore = secondOptionalAbilityLores.get(3);
        getAbility(secondOptionalAbilityEffect, secondOptionalNote, secondOptionalStat, secondOptionalCooldown, secondOptionalManacost, secondOptionalDescription, secondOptionalLore);
    }

    public static void getInfoAboutAntiMageUltimateAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();

        Elements ultimateAbilityEffects = doc.select(".effects");
        Elements ultimateAbilityStats = doc.select("div.stats");
        Elements ultimateAbilityCooldowns = doc.select(".cooldown_and_cost");
        Elements ultimateAbilityManacosts = doc.select(".cooldown_and_cost");
        Elements ultimateAbilityNotes = doc.select(".notes");
        Elements ultimateAbilityDescriptions = doc.select(".description");
        Elements ultimateAbilityLores = doc.select(".lore");

        for (Element big : doc.getElementsByTag("big")) {
            big.remove();
        }

        for (Element table : doc.select("div.col-8")) {
            System.out.println(table.getElementsByTag("header")
                    .last()
                    .text()
                    .toUpperCase());

            Element ultimateAbilityEffect = ultimateAbilityEffects.last();
            Element ultimateAbilityNote = ultimateAbilityNotes.last();
            Element ultimateAbilityStat = ultimateAbilityStats.last();
            Element ultimateAbilityCooldown = ultimateAbilityCooldowns.last();
            Element ultimateAbilityManacost = ultimateAbilityManacosts.last();
            Element ultimateAbilityDescription = ultimateAbilityDescriptions.last();
            Element ultimateAbilityLore = ultimateAbilityLores.last();

            assert ultimateAbilityEffect != null;
            assert ultimateAbilityNote != null;
            assert ultimateAbilityStat != null;
            assert ultimateAbilityCooldown != null;
            assert ultimateAbilityManacost != null;
            assert ultimateAbilityDescription != null;
            assert ultimateAbilityLore != null;

            getAbility(ultimateAbilityEffect, ultimateAbilityNote, ultimateAbilityStat, ultimateAbilityCooldown, ultimateAbilityManacost, ultimateAbilityDescription, ultimateAbilityLore);
        }
    }

    public static void getInfoAboutAntiMageChangelogs() throws IOException {

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

    public static void getInfoAboutAntiMageChangeUpdateLogs() throws IOException {
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
                System.out.println("Description: " + descriptionText);
            }
        }
    }

    public static void getInfoAboutAntiMageTalents() throws IOException {

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
