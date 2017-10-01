package com.javaquasar.jasper.subreport.ds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

public abstract class AdstractDataSourceNew implements JRDataSource {

    protected static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    protected int index = -1;

    public AdstractDataSourceNew() {
    }

    protected java.sql.Timestamp createDate(String date) {
        try {
            Date parsed = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            java.sql.Timestamp time = new java.sql.Timestamp(sqlDate.getTime());
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(AdstractDataSourceNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new java.sql.Timestamp((new Date()).getTime());
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < getData().size());
    }
    
    protected abstract List<List<Object>> getData();
 
}

