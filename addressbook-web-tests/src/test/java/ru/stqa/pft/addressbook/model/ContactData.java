package ru.stqa.pft.addressbook.model;

import java.util.Objects;

// contact data  with all parameters
public class ContactData {

    private int id;
    private final String firstname;
    private final String surname;
    private final String address;
    private final String mobile;
    private final String email;
    private String group;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public ContactData(int id, String firstname, String surname, String address, String mobile, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public ContactData(String firstname, String surname, String address, String mobile, String email, String group) {
        this.id = 0;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }



    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                '}';
    }


@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
        Objects.equals(firstname, that.firstname) &&
        Objects.equals(surname, that.surname) &&
        Objects.equals(address, that.address) &&
        Objects.equals(mobile, that.mobile) &&
        Objects.equals(email, that.email) ;
        }

@Override
public int hashCode() {
        return Objects.hash(id, firstname, surname, address, mobile, email);
        }}