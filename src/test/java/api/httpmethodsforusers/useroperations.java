package api.httpmethodsforusers;

import static io.restassured.RestAssured.*;
import api.endpoints.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class useroperations {
			
	public static Response createuser_post(Object payload) {
				Response response=
				given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(payload).log().all().				
				when().
					post(endpoints.createuser_url);		
		return response;		
	}
	
	public static Response getuser_get(String UsrNm) {
		
		Response response=
		given().
		accept(ContentType.JSON).
		pathParam("username", UsrNm).
		log().all().
		when().			
			get(endpoints.getuser_url);		
		return response;			
	}
	public static Response updateuser_put(String UsrNm,Object payload) {
		
		Response response=
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		pathParam("username", UsrNm).
		body(payload).
		log().all().
		when().			
			put(endpoints.putuser_url);		
		return response;	
		
	}
	public static Response deleteuser_delete(String UsrNm) {
		
		Response response=
		given().
		accept(ContentType.JSON).
		pathParam("username", UsrNm).
		log().all().
		when().			
			delete(endpoints.deleteuser_url);		
		return response;			
	}

}
