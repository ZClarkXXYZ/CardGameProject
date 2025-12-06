package com.example.cardgameproject.adapter;

/**
 * Filename:    CSVAdapter.java
 * Purpose:     Adapts CSV file format to Java data structures. Reads CSV files
 *              and returns data as List of String arrays. Skips header row.
 *
 * Design Pattern: Adapter pattern - Adapter for external file format
 *
 * Usage:
 *   CSVAdapter adapter = new CSVAdapter();
 *   List<String[]> rows = adapter.read("enemy.csv");
 *
 * Author:      ZC, jlg-repo (docs)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVAdapter {
    public List<String[]> read(String path) {
        List<String[]> rows = new ArrayList<>();
        String line;

        // reads the CSV file and returns each row as a String[] while skipping the header row
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String header = br.readLine();
            if (header == null) return rows;

            // reads each remaining line and splits them by commas. -1 keeps the empty fields
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                rows.add(values);
            }
        } catch (IOException e) { // error handling
            e.printStackTrace();
        }
        return rows; // returns all the rows read by the CSV Reader
    }
}
