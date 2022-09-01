package com.csvtojson.csvtojson.utils;

import com.csvtojson.csvtojson.CsvtojsonApplication;
import com.csvtojson.csvtojson.entities.History;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CVSUtils {
    private static final Logger logger = LoggerFactory.getLogger(CVSUtils.class);
    public CVSUtils() {}

    public static List<History> convertCSVToHistories(String filename, String coma) {

        List<History> l = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            logger.info("Process filename: " + filename);
            String line = br.readLine();
            line = br.readLine();
            while(line != null){

                String[] vect   = line.split(coma);
                if(vect.length < 10) {
                    logger.error("File Error: " + vect[3]);
                }
                Long account  = Long.parseLong(vect[0]);
                String state    = vect[1];
                String type     = vect[2];
                LocalDateTime dateTime = LocalDateTime.parse(vect[3], DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
                String symbol   = vect[4];
                Double magicNumber = Double.parseDouble (vect[5]. replace(".","").replace(",","."));
                Double lots     = Double.parseDouble (vect[6].replace(".","").replace(",","."));
                Double open     = Double.parseDouble (vect[7].replace(".","").replace(",","."));
                Double close    = Double.parseDouble (vect[8].replace(".","").replace(",","."));
                Double profit   = Double.parseDouble (vect[9].replace(".","").replace(",","."));

                History h = new History(account, state, type, dateTime, symbol, magicNumber,
                        lots, open, close, profit);
                l.add(h);
                line =  br.readLine();
            }

            return l;

        } catch ( IOException e) {
            if(e instanceof FileNotFoundException)
                new FileNotFoundException("Error: Sorry! File " + filename + " Not Found!");
            else
                e.printStackTrace();
        }
        return null;
    }

    public static Set<String> listFilesUsingFileWalkAndVisitor(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                if (!Files.isDirectory(file)) {
                    fileList.add(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return fileList;
    }
}
