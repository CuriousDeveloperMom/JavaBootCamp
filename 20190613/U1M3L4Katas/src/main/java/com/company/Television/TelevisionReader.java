package com.company.Television;
import com.company.JSONWriteAndRead;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;



import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TelevisionReader {
    public static void main(String[] args) {

        PrintWriter writer = null;
        List<Television> televisionList = new ArrayList<>();

        //JSON parser object to parse read file

        //Television t1 = new Television()


        try {
            ObjectMapper mapper = new ObjectMapper();
            //String jsonCarList = mapper.writeValueAsString(televisionList);

            televisionList = mapper.readValue(new File("televisions.json"),new TypeReference<List<Television>>(){});
            //String jsontelevisions = mapper.writeValueAsString(televisionList);

            //System.out.println(jteleList);


            for (Television tele : televisionList) {
                System.out.println("=================================");
                System.out.println(tele.getBrand());
                System.out.println(tele.getModel());
                System.out.println(tele.getPrice());
                System.out.println(tele.getScreenSize());
            }
        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {

        }
    }

    }

