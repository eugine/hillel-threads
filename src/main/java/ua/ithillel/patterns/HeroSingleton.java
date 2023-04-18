package ua.ithillel.patterns;

public class HeroSingleton {

    private static HeroSingleton instance;

    public static HeroSingleton getInstance() {
        if (instance == null) {
            instance = new HeroSingleton();
        }
        return instance;
    }


    private HeroSingleton() {

    }


}
