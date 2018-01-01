package tddmicroexercises.leaderboard;

public abstract class AbstractDriver {

    String name = "";
    String country = "";

    public AbstractDriver()
    {

    }

    public AbstractDriver(String name, String country)
    {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
