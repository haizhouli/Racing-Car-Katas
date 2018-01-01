describe('Unicode To Htm Converter', function () {

	describe('UnicodeFileToHtmTextConverter', function () {

		it('Punctuation changed for xml', function () {

			var stubTextStream = a.stub(TextStream);
			spyOn(stubTextStream, 'getText').andCallFake(function (callback) { return callback('Cut & Paste'); });
			var target = new UnicodeFileToHtmTextConverter(stubTextStream);

			target.convertToHtml(function(result) {
				expect(result).toEqual('Cut &amp; Paste');
			});

		});

		it('Add breakline', function () {

			var stubTextStream = a.stub(TextStream);
			spyOn(stubTextStream, 'getText').andCallFake(function (callback) { return callback('hello\nhow are you doing?\n'); });
			var target = new UnicodeFileToHtmTextConverter(stubTextStream);

			target.convertToHtml(function(result) {
				expect(result).toEqual('hello<br />how are you doing?<br />');
			});

		});
	});

});