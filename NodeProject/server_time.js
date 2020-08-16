
require("http").createServer((inputRequest, inputResponse) => {
	const requestModule = require("request");
	requestModule("http://worldtimeapi.org/api/timezone/America/New_York",
		function(inErr, inResp, inBody) {
			inputResponse.end("Hello From First Node Web Server : " + inBody)
		});
}

).listen(9094);