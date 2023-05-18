package com.example.demo.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FormSubmissionToGeoJSON {
    public static void main(String[] args) throws JSONException {
        // Assuming you have form field values
        double latitude = 37.7749;
        double longitude = -122.4194;
        String name = "San Francisco";

        // Create GeoJSON object
        JSONObject geojson = new JSONObject();
        geojson.put("type", "FeatureCollection");

        JSONArray features = new JSONArray();

        JSONObject feature = new JSONObject();
        feature.put("type", "Feature");

        JSONObject geometry = new JSONObject();
        geometry.put("type", "Point");

        JSONArray coordinates = new JSONArray();
        coordinates.put(longitude);
        coordinates.put(latitude);

        geometry.put("coordinates", coordinates);
        feature.put("geometry", geometry);

        JSONObject properties = new JSONObject();
        properties.put("name", name);
        feature.put("properties", properties);

        features.put(feature);
        geojson.put("features", features);

        // Convert GeoJSON to string
        String jsonString = geojson.toString(2);

        // Save GeoJSON to file
        String filename = "submission.geojson";
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

