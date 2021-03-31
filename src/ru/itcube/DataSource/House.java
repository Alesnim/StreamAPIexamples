package ru.itcube.DataSource;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int number;
    private String street;
    private String district;
    private String color;
    private final List<User> users = new ArrayList<>();
    private final List<Cats> cats = new ArrayList<>();


    public House(int number, String street, String district, String color) {
        this.number = number;
        this.street = street;
        this.district = district;
        this.color = color;

    }

    public List<User> getUsers() {
        return users;
    }

    public List<Cats> getCats() {
        return cats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void addUser(User user) {
        users.add(user);
    }

    public void addCat(Cats cat) {
        cats.add(cat);
    }

    @Override
    public String toString() {
        return "House{" +
                "number=" + number +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", color='" + color + '\'' +
                ", users=" + users +
                ", cats=" + cats +
                '}';
    }
}
