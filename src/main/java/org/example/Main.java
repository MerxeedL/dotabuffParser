package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.dotabuff.com/heroes/anti-mage/counters/").get();

        for (Element table : doc.select("table.sortable")) {
            for (Element row : table.select("td.cell-xlarge")) {
                System.out.println(row);

            }
        }

        for (Element teblee: doc.select("table.sortable")) {
            for (Element test: teblee.getElementsByTag("td")) {
                System.out.println(test.select("td.data-value"));
            }
        }
    }
}