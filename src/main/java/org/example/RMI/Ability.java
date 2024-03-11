package org.example.RMI;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ability {

    public static void getAbility(Element effects, Element notes, Element ability, Element cooldownAbility, Element manacostAbility, Element descriptionAbility, Element lore) {

        Elements entriesEffects = effects.select(".effects");
        Elements entriesNote = notes.select(".notes");
        Elements entriesAbility = ability.select("div.stat.effect");
        Elements entriesCooldown = cooldownAbility.select("div.cooldown.align-icon");
        Elements entriesManacost = manacostAbility.select("div.manacost.align-icon");
        Elements entriesDescription = descriptionAbility.select("div.description");
        Elements entriesLore = lore.select("div.lore");

        for (Element entry : entriesEffects) {

            for (Element table : entry.select("p")) {
                Elements effect = table.select("p");

                String effectText = effect
                        .text()
                        .replaceAll("\\:", ": ")
                        .toUpperCase();

                System.out.println(effectText);
            }
        }

        for (Element entry : entriesNote) {
            for (Element tableNotes : entry.getElementsByTag("p")) {
                Elements note = tableNotes.select("p");

                String abilityNotes = note
                        .text()
                        .toUpperCase();

                System.out.println("ABILITY NOTES: " + abilityNotes);
            }
        }

        for (Element entry : entriesAbility) {

            Elements label = entry.select("span.label");
            String labelText = label.text();

            Elements values = entry.select("span.values");
            String valueText = values.text();

            System.out.println(labelText.replaceAll("CAST POINT", "CAST POINT: ") + valueText.replaceAll("(\\d+(?:\\.\\d+)?)s", "$1 S"));
        }

        for (Element entry : entriesCooldown) {

            for (Element tableCooldown : entry.select("span.value")) {
                Elements cooldown = tableCooldown.select("span.number");
                String cooldownText = cooldown.text().replaceAll(" ", " \\/ ");

                System.out.println("COOLDOWN: " + cooldownText);

            }
        }

        for (Element entry : entriesManacost) {

            for (Element tableManacost : entry.select("span.value")) {
                Elements manacost = tableManacost.select("span.number");
                String manacostText = manacost.text().replaceAll(" ", " \\/ ");

                System.out.println("MANACOST: " + manacostText);

                if (manacost.isEmpty()) {
                    System.out.println("MANACOST: 0");
                }
            }
        }


        for (Element entry : entriesDescription) {
            Elements description = entry.select("p");
            String descriptionText = description
                    .text()
                    .toUpperCase();

            System.out.println("ABILITY DESCRIPTION: " + descriptionText
                    .replaceAll("\\\\N", " ")
                    .replaceAll("\\s\\s", " "));
        }

        for (Element entry : entriesLore) {
            Element loreInfo = entry.selectFirst("div.lore");
            String loreInfoText = loreInfo
                    .text()
                    .toUpperCase();

            System.out.println("ABILITY LORE: " + loreInfoText);
        }
    }
}
