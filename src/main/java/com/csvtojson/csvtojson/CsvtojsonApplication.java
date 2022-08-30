package com.csvtojson.csvtojson;

import com.csvtojson.csvtojson.entities.History;
import com.csvtojson.csvtojson.utils.CVSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
/*
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableScheduling
*/

public class CsvtojsonApplication implements ApplicationRunner {

    //static final String filename = "D:\\Marcos\\Java\\workspace\\csvtojson\\src\\main\\resources\\66380479.csv";
    //static final String coma = ";";

    private static final Logger logger = LoggerFactory.getLogger(CsvtojsonApplication.class);

    @Value("${filename}")
    private String filename;
    @Value("${coma}")
    private String coma;


    public static void main(String[] args) {
        SpringApplication.run(CsvtojsonApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
        logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
        logger.info("OptionNames: {}", args.getOptionNames());

        for (String name : args.getOptionNames()) {
            logger.info("argument: " + name + "=" + args.getOptionValues(name));
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<History> l = CVSUtils.convertCVSToHistory(filename, coma);
                for (History h : l) {
                    System.out.println(h);
                }
            }
        });
        */
    }

}
