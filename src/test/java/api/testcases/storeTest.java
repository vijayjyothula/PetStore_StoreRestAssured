package api.testcases;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.storePayLoad.Store;
import api.userEndPoints.userEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class storeTest {


	Store store = new Store();
	Faker faker = new Faker();
	
	
	@BeforeClass
	public void preSetup()
	{
		store.setId(faker.idNumber().hashCode());
		store.setPetId(faker.business().hashCode());
		store.setQuantity(faker.food().hashCode());
//		store.setShipDate(faker.date().toString());
		store.setStatus(faker.hobbit().quote());
	}
	
	@Test(priority = 0) 
	
	public void post_Str()
	{
		Response response = userEndPoints.post_Store(store);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 1)
	
	public void get_Str()
	{
		Response response = userEndPoints.get_Store(store.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
/*	@Test(priority = 2)
	
	public void update_Str()
	{
		store.setPetId(faker.business().hashCode());
		store.setQuantity(faker.food().hashCode());
		store.setStatus(faker.hobbit().quote());
		
		Response response = userEndPoints.update_Store(store.getId(), store);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	//there is no update API for Store 
	*/
	
	@Test(priority = 2)
	
	public void delete_Str()
	{
		Response response = userEndPoints.delete_Store(store.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
