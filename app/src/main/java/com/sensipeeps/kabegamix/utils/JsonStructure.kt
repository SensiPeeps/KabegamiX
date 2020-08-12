package com.sensipeeps.kabegamix.utils

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class JsonStructure(private var context: Context?) {
    private lateinit var jsonObj: JSONObject
    fun retrieve(indexToRead: Int, jsonToRead: String?): Array<String>? {
        try {
            val jsonObjMain = JSONObject(readJSONFromAsset(jsonToRead))
            val jsonArray = jsonObjMain.getJSONArray("wallpapers")
            jsonObj = jsonArray.getJSONObject(indexToRead)
            val author = jsonObj.getString("author")
            val url = jsonObj.getString("url")
            val name = jsonObj.getString("name")
            return arrayOf(author, url, name)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }

    private fun readJSONFromAsset(document: String?): String? {
        var json: String? = null
        json = try {
            val `is` = context?.assets?.open(document!!)
            val size = `is`?.available()
            val buffer = size?.let { ByteArray(it) }
            `is`?.read(buffer)
            `is`?.close()
            buffer?.let { String(it, StandardCharsets.UTF_8) }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}