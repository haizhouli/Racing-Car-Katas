package tddmicroexercises.telemetrysystem;

import java.util.Random;

/**
 * Created by Haizhou on 2017/12/17.
 */
public class TelemetryUtils {

    private final static Random connectionEventsSimulator = new Random(42);

    public static Random getConnectionEvents()
    {
        return connectionEventsSimulator;
    }
}
