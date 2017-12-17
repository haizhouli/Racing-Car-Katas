package tddmicroexercises.telemetrysystem;

/**
 * Created by Haizhou on 2017/12/17.
 */
public class TelemetryMessageStub implements IMessage {

    private String diagnosticMessage;
    private String sentMessage = "";

    public void send(String diagnosticMessage) {
        sentMessage  = diagnosticMessage;
    }

    public String receive() {
        return diagnosticMessage;
    }

    public void setDiagnosticMessage(String diagnosticMessage) {
        this.diagnosticMessage = diagnosticMessage;
    }

    public boolean hasSentMessage(String message) {
        return  sentMessage.equals(message);
    }
}
