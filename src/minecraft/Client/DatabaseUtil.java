package Client;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DatabaseUtil {
    private static String stringurl = "https://raw.githubusercontent.com/cornly/coscoremod/main/cos.json";



    private static JsonArray data;



    public static void parseData() {
        URL url = null;
        try {
            url = new URL(stringurl);

            Scanner scanner = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A");

            String result = scanner.next();

            JsonParser parser = new JsonParser();
            data = parser.parse(result).getAsJsonArray();

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static boolean getBoolean(String playerUUID, String key) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            JsonObject jsonObject = data.get(i).getAsJsonObject();
            
            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                if (jsonObject.get(key).getAsBoolean()) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public static double getDouble(String playerUUID, String key) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            JsonObject jsonObject = data.get(i).getAsJsonObject();

            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                return jsonObject.get(key).getAsDouble();
            }
        }

        return  (Double) null;
    }

 
    
    public static String getString(String playerUUID, String key) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            JsonObject jsonObject = data.get(i).getAsJsonObject();

            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                return jsonObject.get(key).getAsString();
            }
        }

        return null;
    }
    
    


    
    public static Integer getInt(String playerUUID, String key) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            JsonObject jsonObject = data.get(i).getAsJsonObject();

            if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
                return jsonObject.get(key).getAsInt();
            }
        }

        return null;
    }
}