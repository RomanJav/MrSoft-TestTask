package by.tomal.mrsoft.data.entity;

public class User {
    private String id;
    private String name;
    private String rate;
    private String level;
    private String userClass;

    public User(String id, String name, String rate, String level, String userClass) {
        setId(id);
        setName(name);
        setRate(rate);
        setLevel(level);
        setUserClass(userClass);
    }


    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    private void setRate(String rate) {
        this.rate = rate;
    }

    public String getLevel() {
        return level;
    }

    private void setLevel(String level) {
        this.level = level;
    }

    public String getUserClass() {
        return userClass;
    }

    private void setUserClass(String userClass) {
        this.userClass = userClass;
    }
}
