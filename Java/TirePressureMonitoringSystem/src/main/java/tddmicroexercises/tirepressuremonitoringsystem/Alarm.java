package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static final double LowPressureThreshold = 17;
    public static final double HighPressureThreshold = 21;

    ISensor sensor;

    boolean alarmOn = false;

    public Alarm(){
        this(new Sensor());
    }

    public Alarm(ISensor sensor) {
        this.sensor = sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
