package tddmicroexercises.leaderboard;

import java.util.List;

public interface IRace {

    int position(AbstractDriver driver);
    int getPoints(AbstractDriver driver);
    List<AbstractDriver> getResults();
    String getDriverName(AbstractDriver driver);

}
