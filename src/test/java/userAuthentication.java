import files.payload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class userAuthentication {


    public static void main(String[] args) {
        RestAssured.baseURI = "http://10.10.10.142:9010";
        String responseFromUserAuth = given().log().all().header("content-Type", "application/json").body(payload.userAuth())
                .when().post("api/v1/users/authorize").then().log().all()
                .statusCode(200).extract().response().asString();

        System.out.println(responseFromUserAuth);

        JsonPath js = new JsonPath(responseFromUserAuth);
        String token = js.getString("data.access_token");
        System.out.println("Token : "+ token);



//        request.header("Authorization", token)
//                .header("Content-Type","application/json");

//        System.out.println(tokenGenerated);
//        JsonPath js = res.jsonPath();
//        String val = js.get("data.id");
        Response resp = given().header("Authorization", token).given().contentType(ContentType.JSON). with()
                .queryParam("pageNumber", 1).queryParam("pageSize",100)
                .when().get("api/v1/tags");

        Assert.assertEquals(resp.statusCode(), 200);
        resp.prettyPrint();


        JsonPath js2 = new JsonPath(resp.asString());
        int s = js2.getInt("tags.size()");
        for(int i=0; i<s; i++) {
            String tagId = js2.getString("tags[i].id");
            System.out.println("TagId : " + tagId);
        }
    }
}
