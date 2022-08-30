package com.csvtojson.csvtojson.respository;

import com.csvtojson.csvtojson.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
