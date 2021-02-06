package ru.stqa.pft.addressbook;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String nik;
    private final String title;
    private final String company;
    private final String mobile;
    private final String mail;
    private final String bday;
    private final String bmonth;
    private final String byear;

    public ContactData(String name, String lastname, String nik, String title, String company, String mobile, String mail, String bday, String bmonth, String byear) {
        this.name = name;
        this.lastname = lastname;
        this.nik = nik;
        this.title = title;
        this.company = company;
        this.mobile = mobile;
        this.mail = mail;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNik() {
        return nik;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMail() {
        return mail;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }
}
