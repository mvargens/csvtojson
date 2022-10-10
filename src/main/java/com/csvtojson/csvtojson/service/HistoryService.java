package com.csvtojson.csvtojson.service;

import com.csvtojson.csvtojson.entities.History;
import com.csvtojson.csvtojson.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public void save(History history) {
        historyRepository.save(history);
    }

    public void save(List<History> histories) {
        for (History h : histories) {
            save(h);
        }
    }
}
