package com.csvtojson.csvtojson.utils;

import com.csvtojson.csvtojson.entities.History;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CVSUtils {

    public CVSUtils() {

    }

    public static List<History> convertCVSToHistory(String filename, String coma) {
        List<History> l = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line = br.readLine();
            line = br.readLine();
            while(line != null){

                String[] vect   = line.split(coma);
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
                String comment  = vect[10];

                History h = new History(account, state, type, dateTime, symbol, magicNumber,
                        lots, open, close, profit, comment);
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
}
