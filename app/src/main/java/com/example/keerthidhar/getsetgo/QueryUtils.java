package com.example.keerthidhar.getsetgo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class QueryUtils {
    private static String query="{\n" +
            "  \\\"tasks\\\": [\n" +
            "    {\n" +
            "      \\\"Capacity\\\": 100, \n" +
            "      \\\"Location\\\": \\\"82 35\\\", \n" +
            "      \\\"Available\\\": 12\n" +
            "\t\\\"Entered\\\":82\n" +
            "\t\\\"Left\\\":18\n" +
            "    }\n" +
            " {\n" +
            "      \\\"Capacity\\\": 120, \n" +
            "      \\\"Location\\\": \\\"82 65\\\", \n" +
            "      \\\"Available\\\": 12\n" +
            "\t\\\"Entered\\\":102\n" +
            "\t\\\"Left\\\":18\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static ArrayList<Word> extract() {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Word> words = new ArrayList<>();
        int i;
        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            JSONObject jsonObject=new JSONObject(query);
            JSONArray jsonArray=jsonObject.optJSONArray("tasks");
            for(i=0;i<jsonArray.length();i++)
            {
                JSONObject j=jsonArray.getJSONObject(i);
                String s=j.optString("Location").toString();
                Integer capacity=Integer.parseInt(j.optString("Capacity").toString());
                Integer entered=Integer.parseInt(j.optString("Entered").toString());
                Integer left=Integer.parseInt(j.optString("Left").toString());
                Integer available=Integer.parseInt(j.optString("Available").toString());
                Integer percent=(available/capacity)*100;
                Word word=new Word(s,capacity,entered,left,available,percent);
                words.add(word);
            }



        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return words;
    }
}
