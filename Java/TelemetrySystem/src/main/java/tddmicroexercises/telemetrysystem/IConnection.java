package tddmicroexercises.telemetrysystem;

/**
 * Created by Haizhou on 2017/12/17.
 */
public interface IConnection {

    void disconnect();

    boolean getOnlineStatus();

    void connect(String diagnosticChannelConnectionString);

}
