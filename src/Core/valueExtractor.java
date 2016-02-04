/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author facu
 */
public class valueExtractor {
     
    public List<List<String>> getValues(List<List<String>> imf, List<List<String>> wefd,
           List<List<String>> wefe, List<List<String>> wefm, List<List<String>> wdd,
           List<List<String>>wdm) throws Exception { 
    
        List<List<String>> result = new ArrayList<List<String>>(); 
        
//        //IMF
        for(int i = 0; i < imf.size(); i++) {
            List<String> rowReaded= imf.get(i);
            List<String> rowResult= new ArrayList<String>();
            
            String fk_country =rowReaded.get(0);
            String fk_indicator =rowReaded.get(3);
            String year1980 = rowReaded.get(8);
            String year1981 = rowReaded.get(9);
            String year1982 = rowReaded.get(10);
            String year1983 = rowReaded.get(11);
            String year1984 = rowReaded.get(12);
            String year1985 = rowReaded.get(13);
            String year1986 = rowReaded.get(14);
            String year1987 = rowReaded.get(15);
            String year1988 = rowReaded.get(16);
            String year1989 = rowReaded.get(17);
            String year1990 = rowReaded.get(18);
            String year1991 = rowReaded.get(19);
            String year1992 = rowReaded.get(20);
            String year1993 = rowReaded.get(21);
            String year1994 = rowReaded.get(22);
            String year1995 = rowReaded.get(23);
            String year1996 = rowReaded.get(24);
            String year1997 = rowReaded.get(25);
            String year1998 = rowReaded.get(26);
            String year1999 = rowReaded.get(27);
            String year2000 = rowReaded.get(28);
            String year2001 = rowReaded.get(29);
            String year2002 = rowReaded.get(30);
            String year2003 = rowReaded.get(31);
            String year2004 = rowReaded.get(32);
            String year2005 = rowReaded.get(33);
            String year2006 = rowReaded.get(34);
            String year2007 = rowReaded.get(35);
            String year2008 = rowReaded.get(36);
            String year2009 = rowReaded.get(37);
            String year2010 = rowReaded.get(38);
            String year2011 = rowReaded.get(39);
            String year2012 = rowReaded.get(40);
            String year2013 = rowReaded.get(41);
            String year2014 = rowReaded.get(42);
            String year2015 = rowReaded.get(43);
            String year2016 = rowReaded.get(44);
            String year2017 = rowReaded.get(45);
            String year2018 = rowReaded.get(46);
            String year2019 = rowReaded.get(47);
            String year2020 = rowReaded.get(48);
            String estimates = rowReaded.get(49);
            
            rowResult.add( fk_country);
            rowResult.add( fk_indicator);
            rowResult.add( year1980);
            rowResult.add( year1981);
            rowResult.add( year1982);
            rowResult.add( year1983);
            rowResult.add( year1984);
            rowResult.add( year1985);
            rowResult.add( year1986);
            rowResult.add( year1987);
            rowResult.add( year1988);
            rowResult.add( year1989);
            rowResult.add( year1990);
            rowResult.add( year1991);
            rowResult.add( year1992);
            rowResult.add( year1993);
            rowResult.add( year1994);
            rowResult.add( year1995);
            rowResult.add( year1996);
            rowResult.add( year1997);
            rowResult.add( year1998);
            rowResult.add( year1999);
            rowResult.add( year2000);
            rowResult.add( year2001);
            rowResult.add( year2002);
            rowResult.add( year2003);
            rowResult.add( year2004);
            rowResult.add( year2005);
            rowResult.add( year2006);
            rowResult.add( year2007);
            rowResult.add( year2008);
            rowResult.add( year2009);
            rowResult.add( year2010);
            rowResult.add( year2011);
            rowResult.add( year2012);
            rowResult.add( year2013);
            rowResult.add( year2014);
            rowResult.add( year2015);
            rowResult.add( year2016);
            rowResult.add( year2017);
            rowResult.add( year2018);
            rowResult.add( year2019);
            rowResult.add( year2020);
            rowResult.add( estimates);

            
            result.add(rowResult);
            
        }
 
        
        //WD
        for(int i = 0; i < wdd.size(); i++) {
            List<String> rowReaded= wdd.get(i);
            List<String> rowResult= new ArrayList<String>();
            
            
            String fk_country =rowReaded.get(1);
            String fk_indicator =rowReaded.get(0);
            String year1980 = null;
            String year1981 = null;
            String year1982 = null;
            String year1983 = null;
            String year1984 = null;
            String year1985 = null;
            String year1986 = null;
            String year1987 = null;
            String year1988 = null;
            String year1989 = null;
            String year1990 = null;
            String year1991 = null;
            String year1992 = null;
            String year1993 = null;
            String year1994 = null;
            String year1995 = null;
            String year1996 = rowReaded.get(5);
            String year1997 = rowReaded.get(6);
            String year1998 = rowReaded.get(7);
            String year1999 = rowReaded.get(8);
            String year2000 = rowReaded.get(9);
            String year2001 = rowReaded.get(10);
            String year2002 = rowReaded.get(11);
            String year2003 = rowReaded.get(12);
            String year2004 = rowReaded.get(13);
            String year2005 = rowReaded.get(14);
            String year2006 = rowReaded.get(15);
            String year2007 = rowReaded.get(16);
            String year2008 = rowReaded.get(17);
            String year2009 = rowReaded.get(18);
            String year2010 = rowReaded.get(19);
            String year2011 = rowReaded.get(20);
            String year2012 = rowReaded.get(21);
            String year2013 = rowReaded.get(22);
            String year2014 = rowReaded.get(23);
            String year2015 = rowReaded.get(24);
            String year2016 = null;
            String year2017 = null;
            String year2018 = null;
            String year2019 = null;
            String year2020 = null;
            String estimates = null;
            
            rowResult.add( fk_country);
            rowResult.add( fk_indicator);
            rowResult.add( year1980);
            rowResult.add( year1981);
            rowResult.add( year1982);
            rowResult.add( year1983);
            rowResult.add( year1984);
            rowResult.add( year1985);
            rowResult.add( year1986);
            rowResult.add( year1987);
            rowResult.add( year1988);
            rowResult.add( year1989);
            rowResult.add( year1990);
            rowResult.add( year1991);
            rowResult.add( year1992);
            rowResult.add( year1993);
            rowResult.add( year1994);
            rowResult.add( year1995);
            rowResult.add( year1996);
            rowResult.add( year1997);
            rowResult.add( year1998);
            rowResult.add( year1999);
            rowResult.add( year2000);
            rowResult.add( year2001);
            rowResult.add( year2002);
            rowResult.add( year2003);
            rowResult.add( year2004);
            rowResult.add( year2005);
            rowResult.add( year2006);
            rowResult.add( year2007);
            rowResult.add( year2008);
            rowResult.add( year2009);
            rowResult.add( year2010);
            rowResult.add( year2011);
            rowResult.add( year2012);
            rowResult.add( year2013);
            rowResult.add( year2014);
            rowResult.add( year2015);
            rowResult.add( year2016);
            rowResult.add( year2017);
            rowResult.add( year2018);
            rowResult.add( year2019);
            rowResult.add( year2020);
            rowResult.add( estimates);

            
            result.add(rowResult);
            
        }        
        
     //Adding ID   
        
        for(int i = 0; i < result.size(); i++) {
            String id=Integer.toString(i+1);
            result.get(i).add(0, id);
        }
        
        
     return result;
    
    }
    
    
    
    public String getIndicatorFKWD( String code, List<List<String>> wdm){
        String result= "-2";//new String();
        
        for(int i = 0; i < wdm.size(); i++) {
            List<String> rowIndicator= wdm.get(i); 
            if(rowIndicator.get(1).equals(code)){
               result =rowIndicator.get(0); 
            }
        }
        
        return result;
        
    }
}
