/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class InfoIntegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        FileHandler fl = new FileHandler();

        List<List<String>> imf = fl.loadStringToTable(fl.loadDocument("C:\\Users\\Adrian\\Desktop\\info-integration\\IMF-data.tsv"), "\n", "\t");
        List<List<String>> wefd = fl.loadStringToTable(fl.loadDocument("C:\\Users\\Adrian\\Desktop\\info-integration\\WEF-data.tsv"), "\n", "\t");
        List<List<String>> wefe = fl.loadStringToTable(fl.loadDocument("C:\\Users\\Adrian\\Desktop\\info-integration\\WEF-entities.tsv"), "\n", "\t");
        List<List<String>> wefm = fl.loadStringToTable(fl.loadDocument("C:\\Users\\Adrian\\Desktop\\info-integration\\WEF-metadata.tsv"), "\n", "\t");
        List<List<String>> wdm = fl.loadStringToTable(fl.loadDocument("C:\\Users\\Adrian\\Desktop\\info-integration\\WD-metadata.tsv"), "\n", "\t");
        List<List<String>> wdd = fl.loadStringToTable(fl.loadDocument("C:\\Users\\Adrian\\Desktop\\info-integration\\WD-data.csv"), "\n", ";");

        fl.saveTableToDocument(imf, "\n\r", "\t", "C:\\Users\\Adrian\\Desktop\\info-integration\\new\\imf.tsv");
        fl.saveTableToDocument(wefd, "\n\r", "\t", "C:\\Users\\Adrian\\Desktop\\info-integration\\new\\wefd.tsv");
        fl.saveTableToDocument(wefe, "\n\r", "\t", "C:\\Users\\Adrian\\Desktop\\info-integration\\new\\wefe.tsv");
        fl.saveTableToDocument(wefm, "\n\r", "\t", "C:\\Users\\Adrian\\Desktop\\info-integration\\new\\wefm.tsv");
        fl.saveTableToDocument(wdm, "\n\r", "\t", "C:\\Users\\Adrian\\Desktop\\info-integration\\new\\wdm.tsv");
        fl.saveTableToDocument(wdd, "\n\r", "\t", "C:\\Users\\Adrian\\Desktop\\info-integration\\new\\wdd.tsv");
    }
}
