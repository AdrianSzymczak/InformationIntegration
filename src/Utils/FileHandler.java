/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Utils.TableOperations;
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

    public List<List<String>> loadStringToTable(String entry, String lineSeparator, String rowSeparator) {
        String[] splittedByColumns;
        String[] splittedByRows = entry.split(lineSeparator);
        int rows = splittedByRows.length;
        List<List<String>> result = new ArrayList<List<String>>(rows);
        List<List<String>> emptyResult = new ArrayList<List<String>>(rows);
        int columns = splittedByRows[0].split(rowSeparator).length;
        for (int i = 0; i < splittedByRows.length; i++) {
            splittedByColumns = splittedByRows[i].split(rowSeparator);
            if (splittedByColumns.length != columns) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE,
                        "Loading string to table shows it is not rectangular");
                return emptyResult;
            }
            List<String> row = new ArrayList<>(columns);
            for (int j = 0; j < splittedByColumns.length; j++) {
                row.add(splittedByColumns[j]);
            }
            result.add(row);
        }
        return result;
    }

    public void saveTableToDocument(List<List<String>> table, String lineSeparator, String columnSeparator, String path) throws Exception {
        if (!TableOperations.validateTable(table)) {
            throw new Exception("Incorrect table to be saved under path: " + path);
        }
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
                    "Unable to write file to: " + path, ex);
        }
    }

    public List<List<String>> saveDocumentToTable(String path, String lineSeparator, String rowSeparator) {
        return loadStringToTable(loadDocument(path), lineSeparator, rowSeparator);
    }

    public String loadDocument(String dirPath) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(dirPath));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName())
                    .log(Level.SEVERE,
                            "Unable to read file from path: " + dirPath, ex);
        }
        return "";
    }
}
