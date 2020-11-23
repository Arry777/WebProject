package by.itClass.model.beans;


import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;

    public User() {
        super();
    }

    public User(String login) {
        super();
        this.login = login;
    }

    public User(String login, String name, String surname, String age, String email, String phone) {
        super();
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        setAge(age);
    }

    public User(int id, String login, String name, String surname, int age, String email, String phone) {
        super();
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(String age) {
        if(Objects.isNull(age) || age.equals("") || age.length() > 3) {
            this.age = 0;
        } else {
            this.age = Integer.parseInt(age);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
