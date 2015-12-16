/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class FileHandler {

    public List<List<String>> loadStringToTable(String entry, String lineSeparator, String rowSeparator) throws Exception {
        List<List<String>> result;
        String[] splittedByRows;
        String[] splittedByColumns;
        int rows;
        int columns;
        splittedByRows = entry.split(lineSeparator);
        rows = splittedByRows.length;
        result = new ArrayList<List<String>>(rows);
        columns = splittedByRows[0].split(rowSeparator).length;
        for (int i = 0; i < splittedByRows.length; i++) {
            splittedByColumns = splittedByRows[i].split(rowSeparator);
            if (splittedByColumns.length != columns) {
                return result;
            }
            List<String> row = new ArrayList<>(columns);
            for (int j = 0; j < splittedByColumns.length; j++) {
                row.add(splittedByColumns[j]);
            }
            result.add(row);
        }
        System.out.println(result.size() + "\t" + result.get(0).size());
        if (!TableOperations.validateTable(result)) {
            throw new Exception("Incorrect table");
        }
        return result;
    }

    public void saveTableToDocument(List<List<String>> table, String lineSeparator, String columnSeparator, String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.size(); i++) {
            List<String> line = table.get(i);
            for (int j = 0; j < line.size(); j++) {
                sb.append(line.get(j));
                sb.append(columnSeparator);
            }
            sb.append(lineSeparator);
        }
        try {
            Files.write(Paths.get(path), sb.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE,
                    "Unable to write file " + path, ex);
        }
    }

    public String loadDocument(String dirPath) {
        String result = "";
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(dirPath));
            result = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName())
                    .log(Level.SEVERE,
                            "Unable to read file " + dirPath, ex);
        }
        return result;
    }
}
