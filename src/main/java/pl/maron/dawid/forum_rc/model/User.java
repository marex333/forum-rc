package pl.maron.dawid.forum_rc.model;

public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private Role role;

    public User(int id, String login, String password, String firstName, String surname, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.role = role;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {
        ADMIN,
        MOD,
        USER
    }
}
