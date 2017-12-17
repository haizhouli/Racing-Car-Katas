package tddmicroexercises.telemetrysystem;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TelemetryDiagnosticControlsTest
{
    private TelemetryDiagnosticControls telemetryDiagnosticControls;
    private TelemetryConnectionStub connectionStub;
    private TelemetryMessageStub messageStub;
    @Before
    public void setup()
    {
        this.connectionStub = new TelemetryConnectionStub();
        this.messageStub = new TelemetryMessageStub();
        this.telemetryDiagnosticControls = new TelemetryDiagnosticControls();
        telemetryDiagnosticControls.setConnectionControl(connectionStub);
        telemetryDiagnosticControls.setMessageControl(messageStub);
    }

	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {
        connectionStub.setOnlineStatus(true);
        String diagnosticInfo = "Diagnostic Message";
        messageStub.setDiagnosticMessage(diagnosticInfo);

        try {
            telemetryDiagnosticControls.checkTransmission();
        }
        catch (Exception e)
        {

        }
        assertTrue(messageStub.hasSentMessage(IMessage.DIAGNOSTIC_MESSAGE));
        assertEquals(connectionStub.getConnectCount(),0);
        assertEquals(diagnosticInfo,telemetryDiagnosticControls.getDiagnosticInfo());

    }

}
