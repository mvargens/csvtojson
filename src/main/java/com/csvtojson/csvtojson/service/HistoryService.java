package com.csvtojson.csvtojson.service;

import com.csvtojson.csvtojson.entities.History;
import com.csvtojson.csvtojson.utils.CVSUtils;

import java.util.List;

public class HistoryService {

    public HistoryService() {}

    public static void saveHistorys(String filename, String coma) {

        List<History> l = CVSUtils.convertCVSToHistory(filename, coma);

        for (History h : l) {
            System.out.println(h);
        }
    }
}
