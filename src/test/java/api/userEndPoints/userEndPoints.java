package api.userEndPoints;
import static io.restassured.RestAssured.*;
import api.storePayLoad.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	public static Response post_Store(Store store)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(store)
		
		.when()
		.post(Routes.post_url);
		
		return response;	
	}
	
	public static Response get_Store(int id)
	{
		Response response = given()
				.pathParam("id", id)
				
				.when()
				.get(Routes.get_url);
		return response;
	}
	
	public static Response update_Store(int id, Store store)
	{
		Response resposne = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id", id)
				.body(store)
				
				.when()
				.put(Routes.update_url);
		return resposne;
	}
	
	public static Response delete_Store(int id)
	{
		Response response = given()
				.pathParam("id", id)
				
				.when()
				.delete(Routes.delete_url);
		return response;
	}
}
