package APITest.step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class pokesearchapi_stepdef {

    private static final String BASE_URL = "https://pokesearch-server.herokuapp.com/api";
        private static Response response;

    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {

    }

    @Then("^I should get (\\d+) response code$")
    public void iShouldGetResponseCode(int responseCode) {
        Assert.assertEquals(responseCode, response.getStatusCode());
    }

    @And("^I should get empty response array$")
    public void iShouldGetEmptyResponseArray() {
        Assert.assertTrue(JsonPath.from(response.getBody().asString()).getList("findAll { it.name == 'id' }").size() > 0);
    }

    @And("^I should get the list of related suggestions$")
    public void iShouldGetTheListOfRelatedSuggestions() {
        Assert.assertTrue(JsonPath.from(response.getBody().asString()).getList("findAll { it.name == 'id' }").size() == 0);
    }

    @When("^I search with \"([^\"]*)\"$")
    public void iSearchWith(String searchText){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.get("/search?query="+ searchText);
    }

    @When("^I request for \"([^\"]*)\"$")
    public void iRequestFor(String itemName){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.get("/lookup/" + itemName);
    }

    @And("^I should see the requested \"([^\"]*)\" is returned$")
    public void iShouldSeeTheRequestedIsReturned(String itemName){

    }
}
