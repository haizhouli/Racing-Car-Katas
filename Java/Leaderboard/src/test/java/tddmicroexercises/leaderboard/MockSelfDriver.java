package tddmicroexercises.leaderboard;

public class MockSelfDriver extends AbstractDriver{

    private String algorithmVersion;

    public MockSelfDriver(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

}
