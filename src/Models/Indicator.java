/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adrian
 */
public class Indicator {

    public String id;
    public String code;
    public String notes;
    public String description;
    public String units;
    public String scale;
    public String source;
    public String countryNotes;
    public static String idHeader = "id";
    public static String codeHeader = "code";
    public static String notesHeader = "notes";
    public static String descriptionHeader = "description";
    public static String unitsHeader = "units";
    public static String scaleHeader = "scale";
    public static String sourceHeader = "source";
    public static String countryNotesHeader = "countryNotes";
    public static Map<String, Indicator> indicatorsMap = new HashMap< String, Indicator>();
    public static List<String> header = new ArrayList<String>();

    public List<String> toList() {
        List<String> res = new ArrayList<String>();
        res.add(this.id);
        res.add(this.code);
        res.add(this.notes);
        res.add(this.description);
        res.add(this.units);
        res.add(this.scale);
        res.add(this.source);
        res.add(this.countryNotes);
        return res;
    }

    public Indicator addIndicator(String id, String code, String notes, String description, String units, String scale, String source, String countryNotes) {
        Indicator i = new Indicator(id, code, notes, description, units, scale, source, countryNotes);
        indicatorsMap.put(id, i);
        return i;
    }

    private Indicator(String id, String code, String notes, String description, String units, String scale, String source, String countryNotes) {
        this.id = id;
        this.code = code;
        this.notes = notes;
        this.description = description;
        this.units = units;
        this.scale = scale;
        this.source = source;
        this.countryNotes = countryNotes;
    }

    static {
        header.add(idHeader);
        header.add(codeHeader);
        header.add(notesHeader);
        header.add(descriptionHeader);
        header.add(unitsHeader);
        header.add(scaleHeader);
        header.add(sourceHeader);
        header.add(countryNotesHeader);
    }
}
