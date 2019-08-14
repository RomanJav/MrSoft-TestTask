package by.tomal.mrsoft.testtask.presenter.entity;

public class User {
    private int id;
    private String name;
    private int rate;
    private int level;
    private String userClass;

    public User(int id, String name, int rate, int level, String userClass) {
        setId(id);
        setName(name);
        setRate(rate);
        setLevel(level);
        setUserClass(userClass);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    private void setRate(int rate) {
        this.rate = rate;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public String getUserClass() {
        return userClass;
    }

    private void setUserClass(String userClass) {
        this.userClass = userClass;
    }
}
