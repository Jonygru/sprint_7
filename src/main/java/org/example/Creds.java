package org.example;

public class Creds {
    private String login;
    private String password;

    public Creds() {
    }

    public  Creds(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public static Creds from(Courier courier) {
        Creds c = new Creds();
        c.setLogin(courier.getLogin());
        c.setPassword(courier.getPassword());
        return c;

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
}
