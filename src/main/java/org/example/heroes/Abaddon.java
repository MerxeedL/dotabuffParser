package org.example.heroes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Abaddon {

    private static final String URLHeroDB = "https://www.dotabuff.com/heroes/abaddon";
    private static final String URLHeroDBCounters = "https://www.dotabuff.com/heroes/abaddon/counters/";
    private static final String URLHeroStratz = "https://stratz.com/heroes/102-abaddon";

    public static void getInfoAboutAbaddon() throws IOException {
        Document doc = Jsoup.connect(URLHeroDB).get();

        for (Element table : doc.select("table.other")) {
            for (Element row : table.select("td")) {
                System.out.println(row.select("td").text());
            }
        }
    }

    public static void getInfoAboutAbaddonLanes() throws IOException {
        Document doc = Jsoup.connect(URLHeroStratz).get();

        for (Element table : doc.select("div.hitagi__sc-1ah81hi-0.hitagi__sc-ucbcwr-0.ibjsOm.hitagi__sc-ymfzjp-0.hitagi__sc-ymfzjp-1.cNgA-Dx")) {
            for (Element row : table.select("span.hitagi__sc-6oal1n-0.jRxcof")) {
                System.out.println(row.select("span").text());
            }
            for (Element row : table.select("div.hitagi__sc-1ah81hi-0.hUBfhn")) {
                for (Element value : row.select("div.hitagi__sc-1ah81hi-0.dWldeB")) {
                    System.out.println("Win Rate: " + (value.select("div").text()));
                }
            }
            for (Element row : table.select("div.hitagi__sc-1ah81hi-0.gkLxSF")) {
                for (Element value : row.select("div.hitagi__sc-ymfzjp-0.hitagi__sc-ymfzjp-1.iElLgn")) {
                    System.out.println("Laning: " + (value.select("div").text()));
                }
            }
//            for (Element row : table.select("div.hitagi__sc-1ah81hi-0.gkLxSF")) {
//                for (Element test : row.select("div.hitagi__sc-ymfzjp-0.hitagi__sc-ymfzjp-1.kDpEVc")) {
//                    if (test.className().equals("hitagi__sc-1apuy4g-0.ketdco")) {
//                        System.out.println(test.select("div").text());
//                    }
//                }
//            }
        }
    }

    public static void getInfoAboutAbaddonIsCounteredBy() throws IOException {
        Document doc = Jsoup.connect(URLHeroDBCounters).get();

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

    public static void getInfoAboutAbaddonCounters() throws IOException {
        Document doc = Jsoup.connect(URLHeroDBCounters).get();

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