package com.csvtojson.csvtojson;

import com.csvtojson.csvtojson.entities.History;
import com.csvtojson.csvtojson.utils.CVSUtils;
import com.csvtojson.csvtojson.utils.JSONUtils;
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

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CsvtojsonApplication implements ApplicationRunner {
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
        logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
        logger.info("OptionNames: {}", args.getOptionNames());

        for (String name : args.getOptionNames()) {
            logger.info("argument: " + name + "=" + args.getOptionValues(name));
        }

        List<History> l = CVSUtils.convertCVSToHistory(filename, coma);
        System.out.println( JSONUtils.convertHistoryToJson(l) );

    }

}
