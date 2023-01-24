package ua.ithillel.dto;

public class Person {
    private final int id;
    private final String name;
    private final String year;
    private final String address;

    public Person(int id, String name, String year, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "PersonClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
