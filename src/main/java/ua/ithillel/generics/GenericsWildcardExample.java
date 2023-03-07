package ua.ithillel.generics;

import java.util.List;

public class GenericsWildcardExample {

    public static void main(String[] args) {
        List<Object> listOfBuildings = List.of(new House());
        List<Skyscraper> listOfBuildings2 = List.of(new Skyscraper());


        doJob(listOfBuildings);
        doJob(listOfBuildings2);
    }

    public static void doJob(List<? super Skyscraper> buildings) {
//        buildings.forEach(Job);
    }

    public static class Building {
        public void doJob() {
            System.out.println("Building job");
        }
    }

    public static class Skyscraper extends Building {

        @Override
        public void doJob() {
            System.out.println("Skyscraper job");
        }
    }

    public static class House extends Building {
        @Override
        public void doJob() {
            System.out.println("House job");
        }

    }
}
