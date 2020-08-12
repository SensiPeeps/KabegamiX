package com.sensipeeps.kabegamix.utils;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class jsonStructure {

    private JSONObject jsonObj;
    Context context;

    public jsonStructure(Context context) {
        this.context = context;
    }

    public String[] retrieve(int indexToRead, String jsonToRead){
        try {
            JSONObject jsonObjMain = new JSONObject(readJSONFromAsset(jsonToRead));
            JSONArray jsonArray = jsonObjMain.getJSONArray("wallpapers");

            jsonObj = jsonArray.getJSONObject(indexToRead);

            String author = jsonObj.getString("author");
            String url = jsonObj.getString("url");
            String name = jsonObj.getString("name");
            return new String[]{author, url, name};

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readJSONFromAsset(String document) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(document);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}