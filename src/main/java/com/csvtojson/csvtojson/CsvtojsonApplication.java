package com.csvtojson.csvtojson;

import com.csvtojson.csvtojson.entities.History;
import com.csvtojson.csvtojson.service.HistoryService;
import com.csvtojson.csvtojson.utils.CVSUtils;
import com.csvtojson.csvtojson.utils.JSONUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;


@SpringBootApplication
@EnableAutoConfiguration(exclude={
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})

public class CsvtojsonApplication implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(CsvtojsonApplication.class);
    @Value("${pathname}")
    private String pathname;
    @Value("${coma}")
    private String coma;
    @Value("${jsonresult}")
    private String jsonresult;

    @Autowired
    HistoryService historyService;

    public static void main(String[] args) {
        SpringApplication.run(CsvtojsonApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));

        for (String name : args.getOptionNames()) {
            logger.info("argument: " + name + "=" + args.getOptionValues(name));
        }

        List<History> histories = new ArrayList<>();
        JSONObject json = new JSONObject();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jsonresult))){
            Set<String> fileList = CVSUtils.listFilesUsingFileWalkAndVisitor(pathname);
            if(fileList == null || fileList.isEmpty()) {
                logger.error("Path empty");
                return;
            }

            for(String filename : fileList) {
                if(filename.endsWith(".csv")){
                    List<History> l = CVSUtils.convertCSVToHistories( pathname + "\\" + filename , coma );
                    if( l == null || l.isEmpty() )
                        logger.warn("File " + filename + " empty or not found!");
                    else{
                        histories.addAll(l);
                    }
                }
            }

            json.put("history", JSONUtils.convertHistoryToJson(histories) );

            logger.info("Total csv files read: " + histories.size());
            logger.info("file list: " + fileList);
            //logger. info(json.toString());

            bw.write(json.toString());
            logger.info("File " + jsonresult + " created!");

            historyService.save(histories);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
