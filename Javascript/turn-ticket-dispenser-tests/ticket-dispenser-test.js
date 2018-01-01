describe('Turn Ticket Dispenser', function () {

	describe('TurnTicketDispenser', function () {

		it('After ticket 10 come ticket 11', function () {

			var stubTurnNumberSequence = a.stub(TurnNumberSequence);
			spyOn(stubTurnNumberSequence, 'getNextTurnNumber').andCallFake(function () { return 11; });
			var target = new TicketDispenser(stubTurnNumberSequence);

			var newTicket = target.getTurnTicket();

			expect(newTicket.turnNumber()).toEqual(11);

		});

		it('A new ticket has greater number than previous one', function () {

			var target = TicketDispenser.Create();

			var previousTicket = target.getTurnTicket();
			var newTicket = target.getTurnTicket();

			expect(newTicket.turnNumber()).toBeGreaterThan(previousTicket.turnNumber());

		});
	});

});
