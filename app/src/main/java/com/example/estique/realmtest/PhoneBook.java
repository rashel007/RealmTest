package com.example.estique.realmtest;

import io.realm.RealmObject;

/**
 * Created by estique on 12/16/17.
 */

public class PhoneBook extends RealmObject {

    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Number = " + number;
    }
}
