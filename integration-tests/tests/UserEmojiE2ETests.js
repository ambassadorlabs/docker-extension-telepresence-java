var expect  = require("chai").expect;
var request = require("request");

const options = {
  url : "https://<ADD APPLICATION INGRESS URL HERE>/api",
  headers : {'x-telepresence-intercept-id': '<ADD TELEPRESENCE HEADER HERE>'}
}

describe("UserEmoji API", function() {

  describe("Can list all emojis", function() {

    it("returns status 200", function(done) {
      request(options, function(error, response, body) {
        expect(response.statusCode).to.equal(200);
        done();
      });
    });
  });

  describe("All emojis are whales", function() {

    it("First user emoji is a whales", function(done) {
      request(options, function(error, response, body) {
        bodyObj = JSON.parse(body);
        expect(bodyObj[0].emojiChars).to.equal("&#128011;");
        done();
      });
    });
  });
});