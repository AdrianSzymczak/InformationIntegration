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
public class Country {

    public String id;
    public String iso;
    public String name;
    public String incomegroup;
    public String region;
    public static String idHeader = "id";
    public static String isoHeader = "iso";
    public static String nameHeader = "name";
    public static String incomegroupHeader = "incomeGroup";
    public static String regionHeader = "region";
    public static Map<String, Country> countriesMap = new HashMap< String, Country>();
    public static List<String> header = new ArrayList<String>();
    public static List<String> headerFull = new ArrayList<String>();

    public List<String> toList() {
        List<String> res = new ArrayList<String>();
        res.add(this.name);
        res.add(this.incomegroup);
        res.add(this.region);
        return res;
    }

    public Country(List<String> l) {
        this.id = l.get(0);
        this.iso = l.get(1);
        this.name = l.get(2);
        this.incomegroup = l.get(3);
        this.region = l.get(4);
        countriesMap.put(id, this);
    }

    public Country(String id, String iso, String name, String incomegroup, String region) {
        this.id = id;
        this.iso = iso;
        this.name = name;
        this.incomegroup = incomegroup;
        this.region = region;
        countriesMap.put(id, this);
    }

    static {
        header.add(nameHeader);
        header.add(incomegroupHeader);
        header.add(regionHeader);
    }

    static {
        headerFull.add(idHeader);
        headerFull.add(isoHeader);
        headerFull.add(nameHeader);
        headerFull.add(incomegroupHeader);
        headerFull.add(regionHeader);
    }
}
