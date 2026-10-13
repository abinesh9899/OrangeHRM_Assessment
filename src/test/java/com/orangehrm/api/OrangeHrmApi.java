package com.orangehrm.api;

import com.orangehrm.config.Config;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrangeHrmApi {
    private final String baseUrl = Config.get("api.base.url").replaceAll("/+$", "");
    private final String token = Config.get("api.bearer.token");

    public boolean isConfigured() { return token != null && !token.isBlank(); }

    private io.restassured.specification.RequestSpecification request() {
        var req = given().baseUri(baseUrl).accept("application/json");
        if (isConfigured()) req.header("Authorization", "Bearer " + token);
        return req;
    }

    public Response findEmployeesById(String employeeId) {
        // OrangeHRM API v2 supports employee collection filters on many current deployments.
        return request().queryParam("employeeId", employeeId).get("/pim/employees");
    }

    public Response getEmployeeNumber(String empNumber) {
        return request().get("/pim/employees/" + empNumber);
    }

    public Response deleteByEmployeeNumber(String empNumber) {
        return request().contentType("application/json")
                .body("{\"ids\":[" + empNumber + "]}")
                .delete("/pim/employees");
    }
}
