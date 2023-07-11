package org.example;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Type down a continent:");
        String continent = getString();
        if (continent.isEmpty()) {
            throw new IllegalArgumentException("You did not type down a continent!");
        }

        System.out.println("Type down a city:");
        String city = getString();
        if (city.isEmpty()) {
            throw new IllegalArgumentException("You did not type down a city!");
        }

        StringBuilder newWordCity = new StringBuilder();
        if (city.contains(" ")) {
            char[] word = city.toCharArray();
            for (int i = 0; i < word.length; i++) {
                if (word[i] == ' ') {
                    word[i] = '_';
                }
                newWordCity.append(word[i]);
            }
        } else {
            newWordCity.append(city);
        }

        ZoneId zone = ZoneId.of(continent + "/" + newWordCity);
        LocalTime now = LocalTime.now(zone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Time in " + city + " in " + continent + ": " + now.format(dtf));
    }

    public static String getString(){
        return new Scanner(System.in).nextLine();
    }
}