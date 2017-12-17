package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private IConnection connectionControl;

    private IMessage messageControl;

    private String diagnosticInfo = "";

    public void setConnectionControl(IConnection connectionControl)
    {
        this.connectionControl = connectionControl;
    }

    public IConnection getConnectionControl()
    {
        return this.connectionControl;
    }

    public void setMessageControl(IMessage messageControl)
    {
        this.messageControl = messageControl;
    }

    public IMessage getMessageControl()
    {
        return this.messageControl;
    }

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo){
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        connectionControl.disconnect();

        int retryLeft = 3;
        while (connectionControl.getOnlineStatus() == false && retryLeft > 0)
        {
            connectionControl.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(connectionControl.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        messageControl.send(messageControl.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = messageControl.receive();
    }
}
