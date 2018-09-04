package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

public class JsonHelper {

    public static JsonObject getJsonObjectFromResponse(Response response) {
        String jsonString = response.then().extract().response().body().print();
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static JsonArray getJsonObjectListFromResponse(Response response) {
        String jsonString = response.then().extract().response().body().print();
        return new JsonParser().parse(jsonString).getAsJsonArray();
    }

}
