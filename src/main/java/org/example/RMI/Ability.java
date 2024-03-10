package org.example.RMI;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ability {

    public static void getAbility(Element effects, Element notes, Element ability, Element cooldownAbility, Element manacostAbility, Element descriptionAbility, Element lore) {

        Elements entriesEffects = effects.select(".effects");
        Elements entriesAbility = ability.select("div.stat.effect");
        Elements entriesCooldown = cooldownAbility.select("div.cooldown.align-icon");
        Elements entriesManacost = manacostAbility.select("div.manacost.align-icon");
        Elements entriesNote = manacostAbility.select(".notes");
        Elements entriesDescription = descriptionAbility.select("div.description");
        Elements entriesLore = lore.select("div.lore");

        for (Element entry : entriesEffects) {

            for (Element table : entry.select("p")) {
                Elements effect = table.select("p");

                String effectText = effect
                        .text()
                        .replaceAll("\\:" , ": ")
                        .toUpperCase();

                System.out.println(effectText);
            }
        }

        for (Element entry : entriesAbility) {

            Element label = entry.selectFirst("span.label");
            assert label != null;
            String labelText = label.text();

            Element values = entry.selectFirst("span.values");
            assert values != null;
            String valueText = values.text();

            System.out.println(labelText + " " + valueText);
        }

        for (Element entry : entriesCooldown) {

            for (Element test : entry.select("span.value")) {
                Elements cooldown = test.select("span.number");
                String cooldownText = cooldown.text().replaceAll(" ", " \\/ ");

                System.out.println("COOLDOWN: " + cooldownText);

            }
        }

        for (Element entry : entriesManacost) {

            for (Element test : entry.select("span.value")) {
                Elements manacost = test.select("span.number");
                String manacostText = manacost.text().replaceAll(" ", " \\/ ");

                System.out.println("MANACOST: " + manacostText);

                if (manacost.isEmpty()) {
                    System.out.println("MANACOST: 0");
                }
            }
        }

        for (Element entry : entriesNote) {
            for (Element test : entry.getElementsByTag("p")) {
                Elements note = test.select("p");

                String abilityNotes = note
                        .text()
                        .toUpperCase();

                System.out.println("ABILITY NOTES: " + abilityNotes);
            }
        }

        for (Element entry : entriesDescription) {
                Elements description = entry.select("p");
                String descriptionText = description
                        .text()
                        .toUpperCase();

                System.out.println("ABILITY DESCRIPTION: " + descriptionText);
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
