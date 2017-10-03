package com.javaquasar.jasper.subreport.ds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public abstract class AdstractDataSource implements JRDataSource {

    protected static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    protected int index = -1;

    public AdstractDataSource() {
    }

    static protected java.sql.Timestamp createDate(String date) {
        try {
            Date parsed = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            java.sql.Timestamp time = new java.sql.Timestamp(sqlDate.getTime());
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(AdstractDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new java.sql.Timestamp((new Date()).getTime());
    }

    @Override
    public boolean next() throws JRException {
        System.out.println("size : " + getData().size());
        index++;
        return (index < getData().size());
    }
    
    @Override
    public Object getFieldValue(JRField field) throws JRException {
        String fieldName = field.getName();
        System.out.print(fieldName);
        Object o = null;
        if(getKeyMap() != null && getData() != null) {
            List<Object> row = getData().get(index);
            if(row != null) {
                o = row.get(getKeyMap().get(fieldName));
            }
        }
        System.out.print(" ");
        System.out.println(o);
        return o;
    }
    
    protected abstract List<List<Object>> getData();
    
    protected abstract Map<String, Integer> getKeyMap();
 
}

