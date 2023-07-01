package guru.qa.homework.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static Faker faker = new Faker();

    public static int getRandomInt(int min, long max) {
        return ThreadLocalRandom.current().nextInt(min, (int) (max + 1));
    }

    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return faker.options().option(gender);
    }

    public static String getRandomMonth() {
        String[] months = {
                "December", "January", "February",
                "March", "April", "May",
                "June", "July", "August",
                "June", "July", "August",
                "September", "October", "November",

        };
        return faker.options().option(months);
    }

    public static String getRandomSubject() {
        String[] subjects = {
                "Math", "English", "Biology",
                "Computer Science", "Arts", "Social Studies",
                "History", "Hindi", "Commerce"
        };
        return faker.options().option(subjects);
    }

    private static Map<String, String[]> stateAndCities() {
        Map<String, String[]> cityAndStates = new HashMap<>();
        cityAndStates.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        cityAndStates.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        cityAndStates.put("Haryana", new String[]{"Karnal", "Panipat"});
        cityAndStates.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
        return cityAndStates;
    }

    private static String randomState = "";
    public static String getRandomState() {
        randomState =  (String) faker.options().option(stateAndCities().keySet()
                .toArray()[faker.random().nextInt(0, 3)]);
        return randomState;
    }

    public static String getRandomCity() {
        String[] cities = stateAndCities().get(randomState);
        return faker.options().option(cities);
    }

    public static String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return faker.options().option(hobby);
    }
}
