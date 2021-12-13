package com.example.application;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxBrackets {

    private static TaxBrackets taxBrackets = new TaxBrackets();

    private static List<TaxBracket> brackets = new ArrayList<>();

    private TaxBrackets() { }

    private void generateBrackets() {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/taxBrackets.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray bracketVals = (JSONArray) jsonObject.get("tax_brackets");

            for (Object bracketVal : bracketVals) {
                JSONObject curObj = (JSONObject) bracketVal;
                int minIncome = Math.toIntExact((Long) curObj.get("min_income"));
                int baseTax = Math.toIntExact((Long) curObj.get("base_tax"));
                double additionalTax = Double.parseDouble((String) curObj.get("additional_tax"));
                brackets.add(new TaxBracket(minIncome, baseTax, additionalTax));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static TaxBrackets getInstance() {
        return taxBrackets;
    }

    public List<TaxBracket> getBrackets() {
        if (brackets.size() == 0) {
            this.generateBrackets();
        }
        return brackets;
    }

}
