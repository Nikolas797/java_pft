package ru.stqa.pft.addressbook.model;

public class NewContactData {
    private final String name;
    private final String lastname;
    private final String title;
    private final String company;

    public NewContactData(String name, String lastname, String title, String company) {
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }
}
