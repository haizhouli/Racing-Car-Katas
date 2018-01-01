package tddmicroexercises.leaderboard;

public class TestData {

    public static MockDriver driver1;
    public static MockDriver driver2;
    public static MockDriver driver3;
    public static MockSelfDriver driver4;

    public static MockRace race1;
    public static MockRace race2;
    public static MockRace race3;
    public static MockRace race4;
    public static MockRace race5;
    public static MockRace race6;

    public static Leaderboard sampleLeaderboard1;
    public static Leaderboard sampleLeaderboard2;

    static {
        driver1 = new MockDriver("Nico Rosberg", "DE");
        driver2 = new MockDriver("Lewis Hamilton", "UK");
        driver3 = new MockDriver("Sebastian Vettel", "DE");
        driver4 = new MockSelfDriver("1.2", "Acme");

        race1 = new MockRace("Australian Grand Prix", driver1, driver2, driver3);
        race2 = new MockRace("Malaysian Grand Prix", driver3, driver2, driver1);
        race3 = new MockRace("Chinese Grand Prix", driver2, driver1, driver3);
        race4 = new MockRace("Fictional Grand Prix 1", driver1, driver2, driver4);
        race5 = new MockRace("Fictional Grand Prix 2", driver4, driver2, driver1);
        driver4.setAlgorithmVersion("1.3");
        race6 = new MockRace("Fictional Grand Prix 3", driver2, driver1, driver4);

        sampleLeaderboard1 = new Leaderboard(race1, race2, race3);
        sampleLeaderboard2 = new Leaderboard(race4, race5, race6);
    }
}
