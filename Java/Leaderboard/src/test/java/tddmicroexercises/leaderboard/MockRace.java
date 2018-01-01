package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockRace implements IRace{

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};

    private final String name;
    private final List<AbstractDriver> results;
    private final Map<AbstractDriver, String> driverNames;

    public MockRace(String name, AbstractDriver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = new HashMap<>();
        for (AbstractDriver driver : results) {
            String driverName = driver.getName();
            if (driver instanceof SelfDrivingCar) {
                driverName = "Self Driving Car - " + driver.getCountry() + " (" + ((SelfDrivingCar) driver).getAlgorithmVersion() + ")";
            }
            this.driverNames.put(driver, driverName);
        }
    }

    public int position(AbstractDriver driver) {
        return this.results.indexOf(driver);
    }

    public int getPoints(AbstractDriver driver) {
        return MockRace.POINTS[position(driver)];
    }

    public List<AbstractDriver> getResults() {
        return results;
    }

    public String getDriverName(AbstractDriver driver) {
        return this.driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }

}
