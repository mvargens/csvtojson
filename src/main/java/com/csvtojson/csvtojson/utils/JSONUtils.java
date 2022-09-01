package com.csvtojson.csvtojson.utils;

import com.csvtojson.csvtojson.entities.History;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JSONUtils {

    public JSONUtils() {
    }

    public static JSONArray convertHistoryToJson(List<History> histories){
        JSONArray jHistories = new JSONArray();
        for (History history : histories) {
            JSONObject jHistory = new JSONObject();
            jHistory.put("account",history.getAccount());
            jHistory.put("state",history.getState());
            jHistory.put("type",history.getType());
            jHistory.put("dateTime",history.getDateTime());
            jHistory.put("symbol",history.getSymbol());
            jHistory.put("magicNumber",history.getMagicNumber());
            jHistory.put("lots",history.getLots());
            jHistory.put("open",history.getOpen());
            jHistory.put("close",history.getClose());
            jHistory.put("profit",history.getProfit());
            jHistory.put("comment",history.getComment());

            jHistories.put(jHistory);
        }

        return jHistories;
    }
}
