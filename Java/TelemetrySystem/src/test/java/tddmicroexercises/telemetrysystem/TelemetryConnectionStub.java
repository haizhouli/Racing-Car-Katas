package tddmicroexercises.telemetrysystem;

/**
 * Created by Haizhou on 2017/12/17.
 */
public class TelemetryConnectionStub implements IConnection{

    private boolean onlineStatus;
    private String connectString;
    private int connectCount = 0;

    public void disconnect() {
        if(connectCount > 0)
            connectCount--;
    }

    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void connect(String string) {
        connectString = string;
        connectCount++;
    }

    public void setOnlineStatus(boolean status) {
        this.onlineStatus = status;
    }

    public String getConnectString() {
        return connectString;
    }

    public int getConnectCount(){return this.connectCount;}

    public void setConnectCount(int connectCount){this.connectCount = connectCount;}

}
