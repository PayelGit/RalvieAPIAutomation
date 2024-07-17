import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class CreateAccount {


   public static void main(String[] args)
   {
//       RestAssured.baseURI = "http://10.10.10.142:9010";
//       String response = given().log().all().header("content-Type", "application/json").body(payload.createAccount())
//               .when().post("/api/v1/user")
//               .then().log().all().assertThat().statusCode(200)
//               .extract().response().toString();
//       System.out.println(response);
//       JsonPath js = new JsonPath(response);
//       js.getString();
   }

}
