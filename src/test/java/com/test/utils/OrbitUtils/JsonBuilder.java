package com.test.utils.OrbitUtils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonBuilder {
    public String getJsonStringFromFile(String jsonfile) throws Exception {
        String filePath = "/src/test/resources/TestDatafile/JsonMockDataFiles";
        JSONObject jsonObject = (JSONObject) readJsonFileFromFile(System.getProperty("user.dir") + filePath + "/" + jsonfile);
        return jsonObject.toJSONString();
    }

    public static Object readJsonFileFromFile(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    public String replaceValueInJson(String jsonResponse, String searchKey, String value) {

        String response = jsonResponse;
        switch (searchKey) {
            case "IMEI": {
                response.replace("${IMEI}", value);
                break;
            }
            case "MAKE": {
                response.replace("${MAKE}", value);
                break;
            }
            case "MODEL": {
                response.replace("${MODEL}", value);
                break;
            }
            case "FMIPSTATUS": {
                response.replace("${FMIPSTATUS}", value);
                break;
            }

        }
        return response;
    }
}
