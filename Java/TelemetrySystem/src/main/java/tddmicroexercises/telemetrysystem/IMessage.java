package tddmicroexercises.telemetrysystem;

/**
 * Created by Haizhou on 2017/12/17.
 */
public interface IMessage {

    String DIAGNOSTIC_MESSAGE = "AT#UD";

    void send(String diagnosticMessage);

    String receive();

}
