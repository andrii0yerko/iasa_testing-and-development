import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class ApiTests {

//    Cover the next endpoints with tests and include into in CI pipeline:
//    - Upload
//    - GetFileMetadata
//    - Delete file

    @Test
    public void uploadFileTest() {
        // rest assured adds charset specification by default which is not expected by dropbox and results in an error
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

        File file = new File("src/test/resources/sample.jpg");
        String apiArgs = "{\"mode\":\"add\",\"autorename\":true,\"mute\":false,\"path\":\"/sample.jpg\"}";

        given()
          .headers("Authorization","Bearer " + Config.bearerToken,
                  "Content-Type", "application/octet-stream",
                  "Dropbox-API-Arg", apiArgs)
          .body(file)
        .when()
          .post("https://content.dropboxapi.com/2/files/upload")
        .then()
          .statusCode(200);
    }

    @Test
    public void getFileMetadataTest() {
        Map<String,String> path = new HashMap<>();
        path.put("path", "/sample.jpg");

        given()
          .headers("Authorization","Bearer " + Config.bearerToken,
                  "Content-Type", "application/json")
          .body(path)
        .when()
          .post("https://api.dropboxapi.com/2/files/get_metadata")
        .then()
          .statusCode(200);
    }

    @Test
    public void deleteFileTest() {
        Map<String,String> path = new HashMap<>();
        path.put("path", "/sample.jpg");

        given()
          .headers("Authorization","Bearer " + Config.bearerToken,
                  "Content-Type", "application/json")
          .body(path)
        .when()
          .post("https://api.dropboxapi.com/2/files/delete_v2")
        .then()
          .statusCode(200);
    }

    public static void main() {

    }
}
