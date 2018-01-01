
TelemetryDiagnosticControls = function (telemetryClient, telemetryData) {

	this._diagnosticChannelConnectionString = function () { return '*111#'; };
	this._diagnosticInfo = '';
	this._telemetryClient = telemetryClient;
	this._telemetryData = telemetryData;
};

TelemetryDiagnosticControls.Create = function () {
	return new TelemetryDiagnosticControls(new TelemetryClient(), new TelemetryData());
};

TelemetryDiagnosticControls.prototype = {

	readDiagnosticInfo: function() {
		return this._diagnosticInfo;
	},

	writeDiagnosticInfo: function(newValue) {
		this._diagnosticInfo = newValue;
	},

	checkTransmission: function() {

		this._diagnosticInfo = '';

		this._telemetryClient.disconnect();

		var retryLeft = 3;
		while (this._telemetryClient.onlineStatus() === false && retryLeft > 0) {
			this._telemetryClient.connect(this._diagnosticChannelConnectionString);
			retryLeft -= 1;
		}

		if (this._telemetryClient.onlineStatus() === false) {
			throw 'Unable to connect';
		}

		this._telemetryData.send(telemetryData.diagnosticMessage());
		this._diagnosticInfo = this._telemetryData.receive();
	}
};