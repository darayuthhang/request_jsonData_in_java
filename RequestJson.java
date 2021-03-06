package quickSort;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestJson {
    public static void main(String[] args) {
      
        try{
            URL url = new URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //get reponse code whether you can connect or not
            //if you cannot connect the response code will
            //catch IOException
            int reponse = connection.getResponseCode();
            //consume less memory and very fast when cocat the string.
            StringBuilder responContext = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responContext.append(inputLine);
            }
            readJson(responContext.toString());
            //catch invalid protocol or http
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (SecurityException e){
            System.out.println(e.getMessage());
        }
    }
    public static void readJson(String response){
        JSONObject jsonObject = new JSONObject(response);

        JSONArray weatherObject = jsonObject.getJSONArray("weather");
        JSONObject weather = weatherObject.getJSONObject(0);
        String main = weather.getString("main");


    }
}

