package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import builder.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetSteps {
	// move these to env variables
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static final String USERNAME = "TOOLSQA-Test";
	private static final String PASSWORD = "Test@@123";
	private static final String BASE_URL = "https://petstore.swagger.io/v2/";

	private static String token;
	private static Response response;
	private static String jsonString;
	private static String petId;

	@Given("A list of pets are available")
	public void listOfPetsAvailable() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("pet/findByStatus?status=available");

		jsonString = response.asString();
		List<Map<String, String>> pets = JsonPath.from(jsonString).get();
		Assert.assertTrue(pets.size() > 0);
		petId = "15";
	}

	@When("I add a pet to my list")
	public void addPetInList() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");
		Pet pet = new Pet();
		response = request.body(pet.ConstructBody(562, "p-d7A21vWRLOAC6q", "doggiekal2")).post("pet");
	}

	@Then("The pet is added")
	public void bookIsAdded() {
		Assert.assertEquals(200, response.getStatusCode());
	}

// @When("I remove a pet from the list")
// public void removeBookFromList() {
// RestAssured.baseURI = BASE_URL;
// RequestSpecification request = RestAssured.given();
// 
// request.header("Content-Type", "application/json");
// 
// response = request.delete("/pet/"+petId);
// 
// 
// }
// 
// @Then("The pet is removed")
// public void petIsRemoved() {
// Assert.assertEquals(200, response.getStatusCode());
// }
}
