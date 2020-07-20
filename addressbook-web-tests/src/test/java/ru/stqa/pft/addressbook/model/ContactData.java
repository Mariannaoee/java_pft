package ru.stqa.pft.addressbook.model;

import java.util.Objects;

// contact data  with all parameters
public class ContactData {

    private int id;
    private final String firstname;
    private final String surname;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public ContactData(int id, String firstname, String surname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    public ContactData(String firstname, String surname, String address, String mobile, String email, String group) {
        this.id = 0;
        this.firstname = firstname;
        this.surname = surname;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }





    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\''

                ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(surname, that.surname);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, surname);
    }

    public String getGroup() {
        return getGroup();
    }
}