package demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BugTest {

    public static void main(String[] args) {

         RestAssured.baseURI = "https://emilianor2000risso.atlassian.net";

        String createIssueResponse = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic ZW1pbGlhbm9yMjAwMEBnbWFpbC5jb206QVRBVFQzeEZmR0YwdXc5cDU1dFJQNEdTTlM1dlpUcTRQSFM4NDVoOXZ6amlZaE9IakJKcnRfZjBKZmI2c0tzU2VvVy12dGVlV0ZCY1RaMExsbU9kTTd0emVoN2xITnpJNXF2X19EcHc5OXZ2bmxKOFpvQzJmWDFpZ181SU5DdWpDOE5Xbl8ydjBHN1NMckpHN1pMSWROanQ1aWxEWExRaDdGaXJ2QWhualhVMWhfNHFsNXRVWGRnPUNGMjIwQjI1")
                .body("{\n" +
                        "  \"fields\": {\n" +
                        "    \"project\": {\n" +
                        "      \"key\": \"SCRUM\"\n" +
                        "    },\n" +
                        "    \"summary\": \"Links are not working 2 - automation Rest Assured\",\n" +
                        "    \"description\": {\n" +
                        "      \"type\": \"doc\",\n" +
                        "      \"version\": 1,\n" +
                        "      \"content\": [\n" +
                        "        {\n" +
                        "          \"type\": \"paragraph\",\n" +
                        "          \"content\": [\n" +
                        "            {\n" +
                        "              \"type\": \"text\",\n" +
                        "              \"text\": \"This is a description using Atlassian Document Format.\"\n" +
                        "            }\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    \"issuetype\": {\n" +
                        "      \"name\": \"Bug\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n")
                .log().all()
                .post("rest/api/3/issue").then().log().all().assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(createIssueResponse);
        String issueId = jsonPath.getString("id");
        System.out.println(issueId);



        // Add Attachement
        given()
                .pathParam("key", issueId)
                .header("X-Atlassian-Token", "no-check")
                .header("Authorization", "Basic ZW1pbGlhbm9yMjAwMEBnbWFpbC5jb206QVRBVFQzeEZmR0YwdXc5cDU1dFJQNEdTTlM1dlpUcTRQSFM4NDVoOXZ6amlZaE9IakJKcnRfZjBKZmI2c0tzU2VvVy12dGVlV0ZCY1RaMExsbU9kTTd0emVoN2xITnpJNXF2X19EcHc5OXZ2bmxKOFpvQzJmWDFpZ181SU5DdWpDOE5Xbl8ydjBHN1NMckpHN1pMSWROanQ1aWxEWExRaDdGaXJ2QWhualhVMWhfNHFsNXRVWGRnPUNGMjIwQjI1")
                .multiPart("file", new File("/Users/test/Desktop/Screen Shot 2025-05-16 at 11.29.19.png")).log().all()
                .post("rest/api/3/issue/{key}/attachments")
                .then().log().all().assertThat().statusCode(200);

















    }
}
