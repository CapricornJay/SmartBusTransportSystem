package com.example.keerthidhar.getsetgo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AueryUtils {
    private static final String query="{\n" +
            "\t\"task\": [{\n" +
            "\t\t\t\"Capacity\": 100,\n" +
            "\t\t\t\"Location\": \"82 35\",\n" +
            "\t\t\t\"Available\": 10,\n" +
            "\t\t\t\"Entered\": 82,\n" +
            "\t\t\t\"Left\": 18\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"Capacity\": 120,\n" +
            "\t\t\t\"Location\": \"82 65\",\n" +
            "\t\t\t\"Available\": 12,\n" +
            "\t\t\t\"Entered\": 102,\n" +
            "\t\t\t\"Left\": 18\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
    public static ArrayList<Word> extract() {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Word> words = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            JSONObject jsonObject=new JSONObject(query);
            JSONArray jsonArray=jsonObject.optJSONArray("task");
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject j=jsonArray.getJSONObject(i);
                String s=j.optString("Location").toString();
                Log.i("Location",s);
                Integer capacity=Integer.parseInt(j.optString("Capacity").toString());
                Integer entered=Integer.parseInt(j.optString("Entered").toString());
                Integer left=Integer.parseInt(j.optString("Left").toString());
                Integer available=Integer.parseInt(j.optString("Available").toString());
                Integer percent=100*(capacity-available)/capacity;
                Log.i("Percent", percent.toString());
                Word word=new Word(s,capacity,entered,left,available,percent);
                words.add(word);
            }



        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return words;
    }
}
