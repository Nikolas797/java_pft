package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private final String name;
    private final String lastname;
    private final String title;
    private final String company;

    public ContactData( String name, String lastname, String title, String company) {
        this.id = 0;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
    }

    public ContactData(int id, String name, String lastname, String title, String company) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

}
