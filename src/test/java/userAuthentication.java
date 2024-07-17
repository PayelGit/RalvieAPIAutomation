import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;

public class userAuthentication {


    public static void main(String[] args) {
        RestAssured.baseURI = "http://10.10.10.142:9010";
        String responseFromUserAuth = given().log().all().header("content-Type", "application/json").body(payload.userAuth())
                .when().post("api/v1/users/authorize").then().log().all()
                .statusCode(200).extract().response().toString();

        System.out.println(responseFromUserAuth);

        JsonPath js = new JsonPath(responseFromUserAuth);
        String token = js.getString("data.access_token");
        System.out.println(token);

//        String jsonString = responseFromGenerateToken.getBody().asString();
//        System.out.println(jsonString);
//        String tokenGenerated = JsonPath.from(jsonString).get("data.access_token");
//        request.header("Authorization", "Bearer "+tokenGenerated)
//                .header("Content-Type","application/json");

//        System.out.println(tokenGenerated);
//        JsonPath js = res.jsonPath();
//        String val = js.get("data.id");
//        Response createTagResponse = request.body(payload.addTags())
//                .when().post("api/v1/tags")
    }
}
