describe('Tyre Pressure Monitoring System', function () {

	describe('Alarm', function () {

		var stubSensor;
		var target;

		beforeEach(function () {
			stubSensor = a.stub(Sensor);
			target = new Alarm(stubSensor);
		});

		it('normal pressure does not raise the alarm', function () {
			spyOn(stubSensor, 'popNextPressurePsiValue').andCallFake(function () { return Alarm.LowPressureThreshold() +2; });

			target.check();

			expect(target.alarmOn()).toBeFalsy();
		});

		it('a pressure out of range raise the alarm', function () {
			spyOn(stubSensor, 'popNextPressurePsiValue').andCallFake(function () { return Alarm.HighPressureThreshold() +1; });

			target.check();

			expect(target.alarmOn()).toBeTruthy();
		});

	});

});