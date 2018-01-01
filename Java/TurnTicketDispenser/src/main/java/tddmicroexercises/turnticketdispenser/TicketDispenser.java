package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    private TurnTicket newTurnTicket;
    private ITurnNumberSequence sequence;

    public TicketDispenser()
    {
        sequence = new TurnNumberSequence();
    }

    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = sequence.getNextTurnNumber();
        newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
