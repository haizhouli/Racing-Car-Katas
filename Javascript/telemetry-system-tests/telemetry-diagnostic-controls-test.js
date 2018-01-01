describe('Telemetry System', function () {

	describe('TelemetryDiagnosticControls', function () {

		it('CheckTransmission() should send a diagnostic message and receive a status message response', function () {

			var mockChannel = a.mock(TelemetryData);
            spyOn(mockChannel, 'send');
            spyOn(mockChannel, 'receive');
            var stubTelemetryConnection = a.stub(TelemetryClient);

            var target = new TelemetryDiagnosticControls(stubTelemetryConnection, mockChannel);
            target.checkTransmission();

            expect(mockChannel.send).toHaveBeenCalledWith(TelemetryData.diagnosticMessage());
            expect(mockChannel.receive).toHaveBeenCalled();

		});

	});

});
