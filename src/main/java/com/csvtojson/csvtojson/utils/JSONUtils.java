package com.csvtojson.csvtojson.utils;

import com.csvtojson.csvtojson.entities.History;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JSONUtils {

    public JSONUtils() {
    }

    public static String convertHistoryToJson(List<History> histories){
        JSONObject o = new JSONObject();
        JSONArray a = new JSONArray();
        for (History h : histories) {
            JSONObject json = new JSONObject();
            json.put("account",h.getAccount());
            json.put("state",h.getState());
            json.put("type",h.getType());
            json.put("dateTime",h.getDateTime());
            json.put("symbol",h.getSymbol());
            json.put("magicNumber",h.getMagicNumber());
            json.put("lots",h.getLots());
            json.put("open",h.getOpen());
            json.put("close",h.getClose());
            json.put("profit",h.getProfit());
            json.put("comment",h.getComment());

            a.put(json);
        }
        o.put("histories",a);

        return o.toString();
    }
}
