package tddmicroexercises.leaderboard;

public class MockDriver extends AbstractDriver{

    public MockDriver(String name, String country) {
        super(name,country);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MockDriver)) {
            return false;
        }
        MockDriver other = (MockDriver) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }

}
