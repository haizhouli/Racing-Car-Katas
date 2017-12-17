package tddmicroexercises.telemetrysystem;

import java.util.Random;

/**
 * Created by Haizhou on 2017/12/17.
 */
public class TelemetryConnection implements IConnection {

    private boolean onlineStatus;

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus){this.onlineStatus = onlineStatus;}

    public void connect(String telemetryServerConnectionString)
    {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = TelemetryUtils.getConnectionEvents().nextInt(10) <= 8;

        onlineStatus = success;
    }

    public void disconnect()
    {
        onlineStatus = false;
    }
}
