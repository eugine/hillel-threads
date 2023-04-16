package ua.ithillel.patterns.creational.builder;

public record Car(
        String name,
        int seatsAmount,
        int doorsAmount,
        boolean hasGPS) {

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public static class CarBuilder {
        private String name;
        private int seats;
        private int doors;
        private boolean gps;

        public CarBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder seats(int amount) {
            this.seats = amount;
            return this;
        }

        public CarBuilder doors(int amount) {
            this.doors = amount;
            return this;
        }

        public CarBuilder gps(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Car build() {
            return new Car(name, seats, doors, gps);
        }
    }
}
