package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

    private static final double HIGH_PRESSURE = Alarm.HighPressureThreshold + 1;
    private static final double LOW_PRESSURE = Alarm.LowPressureThreshold - 1;
    private static final double NORMAL_PRESSURE = Alarm.LowPressureThreshold + ((Alarm.HighPressureThreshold - Alarm.LowPressureThreshold)/2);
    private MockSensor mockSensor;
    private Alarm alarm;

    @Before
    public void setUp(){
        mockSensor = new MockSensor();
        alarm  = new Alarm(mockSensor);
    }

    @Test
    public void checkAlarmAvailableWithLowPressure() {
        mockSensor.pushPsiValue(LOW_PRESSURE);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void checkAlarmAvailableWithHighPressure() {
        mockSensor.pushPsiValue(HIGH_PRESSURE);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void checkAlarmAvailableWithNormalPressure(){
        double pressureValue = NORMAL_PRESSURE;
        mockSensor.pushPsiValue(pressureValue);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
