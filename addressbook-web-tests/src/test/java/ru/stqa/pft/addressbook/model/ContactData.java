package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String title;
    private final String company;

    public ContactData(String name, String lastname, String title, String company) {
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

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return company != null ? company.equals(that.company) : that.company == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
