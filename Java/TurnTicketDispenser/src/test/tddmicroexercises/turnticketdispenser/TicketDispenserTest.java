package tddmicroexercises.turnticketdispenser;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lenovo on 2018/1/1.
 */
public class TicketDispenserTest {

    @Test
    public void checkSequenceNumber() {
        TicketDispenser td = new TicketDispenser();

        Assert.assertEquals(0, td.getTurnTicket().getTurnNumber());
        Assert.assertEquals(1, td.getTurnTicket().getTurnNumber());
    }

    @Test
    public void checkSequenceToBeShared() {
        TicketDispenser td1 = new TicketDispenser();
        TicketDispenser td2 = new TicketDispenser();

        Assert.assertEquals(0, td1.getTurnTicket().getTurnNumber());
        Assert.assertEquals(1, td2.getTurnTicket().getTurnNumber());
    }

}
