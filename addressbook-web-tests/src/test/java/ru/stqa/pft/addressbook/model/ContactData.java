package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String id;
    private final String name;
    private final String lastname;
    private final String title;
    private final String company;

    public ContactData( String name, String lastname, String title, String company) {
        this.id = null;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
    }

    public ContactData(String id, String name, String lastname, String title, String company) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
    }


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }


}
