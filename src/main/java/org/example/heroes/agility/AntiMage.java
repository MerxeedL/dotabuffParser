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
        Element firstAbility = doc.selectFirst(".stats");
        Element firstAbilityCooldown = doc.selectFirst(".cooldown_and_cost");
        Element firstAbilityManacost = doc.selectFirst(".cooldown_and_cost");
        Element firstAbilityNotes = doc.selectFirst(".notes");
        Element firstAbilityDescription = doc.selectFirst(".description");
        Element firstAbilityLore = doc.selectFirst(".lore");

        if (firstAbility != null) {

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

            getAbility(firstAbilityEffects, firstAbility, firstAbilityCooldown, firstAbilityManacost, firstAbilityNotes, firstAbilityDescription, firstAbilityLore);
        }
    }

    public static void getInfoAboutAntiMageSecondAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements effects = doc.select(".effects");
        Elements stats = doc.select(".stats");
        Elements cooldown = doc.select(".cooldown_and_cost");
        Elements manacost = doc.select(".cooldown_and_cost");
        Elements notes = doc.select(".notes");
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

            Element secondAbilityEffects = effects.get(1);
            Element secondAbility = stats.get(1);
            Element secondAbilityCooldown = cooldown.get(1);
            Element secondAbilityManacost = manacost.get(1);
            Element secondAbilityNotes = notes.get(1);
            Element secondAbilityDescription = description.get(1);
            Element secondAbilityLore = lore.get(1);
            getAbility(secondAbilityEffects, secondAbility, secondAbilityCooldown, secondAbilityManacost, secondAbilityNotes, secondAbilityDescription, secondAbilityLore);
        }
    }

    public static void getInfoAboutAntiMageThirdAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements effects = doc.select(".effects");
        Elements stats = doc.select(".stats");
        Elements cooldown = doc.select(".cooldown_and_cost");
        Elements manacost = doc.select(".cooldown_and_cost");
        Elements notes = doc.select(".notes");
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

            Element thirdAbilityEffects = effects.get(2);
            Element thirdAbility = stats.get(2);
            Element thirdAbilityCooldown = cooldown.get(2);
            Element thirdAbilityManacost = manacost.get(2);
            Element thirdAbilityNotes = notes.get(2);
            Element thirdAbilityDescription = description.get(2);
            Element thirdAbilityLore = lore.get(2);
            getAbility(thirdAbilityEffects, thirdAbility, thirdAbilityCooldown, thirdAbilityManacost, thirdAbilityNotes, thirdAbilityDescription, thirdAbilityLore);
        }
    }

    public static void getInfoAboutAntiMageUltimateAbility() throws IOException {

        Document doc = Jsoup.connect(URLAbilities).get();
        Elements effects = doc.select(".effects");
        Elements stats = doc.select(".stats");
        Elements cooldown = doc.select(".cooldown_and_cost");
        Elements manacost = doc.select(".cooldown_and_cost");
        Elements notes = doc.select(".notes");
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
            Element ultimateAbilityNotes = notes.get(3);
            Element ultimateAbilityDescription = description.get(3);
            Element ultimateAbilityLore = lore.get(3);
            getAbility(ultimateAbilityEffects, ultimateAbility, ultimateAbilityCooldown, ultimateAbilityManacost, ultimateAbilityNotes, ultimateAbilityDescription, ultimateAbilityLore);
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
