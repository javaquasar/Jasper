package com.javaquasar.jasper.subreport_3.ds;

import com.javaquasar.jasper.subreport_2.ds.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ItemDataSource implements JRDataSource {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Object[][] data = {
        {"PL10124069604100800000000215", "PLN", "545598******1802", "495561689", "+380509872464", "Name", createDate("2017-07-01"), "Przelew DiP", null, new BigDecimal("-10000")},
        {"PL10124069604100800000000215", "PLN", "545598******1802", "495561689", "+380509872464", "Name", createDate("2017-08-01"), "Przelew DiP", new BigDecimal("0"), new BigDecimal("-5000")},
        {"PL10124069604100800000000216", "PLN", "545598******5678", "125671983", "+380505217131", "Name 3", createDate("2017-08-01"), "Przelew ZiP", new BigDecimal("70000"), new BigDecimal("-20000")},
        {"PL10124069604100800000000216", "PLN", "545598******5678", "125671983", "+380505217131", "Name 3", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {"PL10124069604100800000000216", "EUR", "545598******5678", "125671983", "+380505217131", "Name 3", createDate("2017-08-01"), "Przelew ZiP", new BigDecimal("10050"), new BigDecimal("-10000")},
        {"PL10124069604100800000000217", "PLN", "545598******1234", "980937469", "+380504447131", "Name New", createDate("2017-05-01"), "Przelew XXXiP", new BigDecimal("10050"), null},
        {"PL10124069604100800000000217", "PLN", "545598******1234", "980937469", "+380504447131", "Name New", createDate("2017-06-01"), "Przelew XXXiP", new BigDecimal("20030"), null},
        {"PL10124069604100800000000217", "EUR", "545598******1234", "980937469", "+380504447131", "Name New", createDate("2017-07-01"), "Przelew XXXiP", new BigDecimal("20020"), null}    
    };

    private int index = -1;

    public ItemDataSource() {
    }

    private java.sql.Timestamp createDate(String date) {
        try {
            Date parsed = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            java.sql.Timestamp time = new java.sql.Timestamp(sqlDate.getTime());
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(ItemDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new java.sql.Timestamp((new Date()).getTime());
    }

    @Override
    public boolean next() throws JRException {
        index++;

        return (index < data.length);
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        String fieldName = field.getName();

        if (null != fieldName) {
            switch (fieldName) {
                case "IBAN":
                    value = data[index][0];
                    break;
                case "CURRENCYCODE":
                    value = data[index][1];
                    break;
                case "MASKEDPAN":
                    value = data[index][2];
                    break;
                case "DETAILS":
                    value = data[index][3];
                    break;
                case "PHONE":
                    value = data[index][4];
                    break;
                case "FULLNAME":
                    value = data[index][5];
                    break;
                case "ITEMDATE":
                    value = data[index][6];
                    break;
                case "TYPENAME":
                    value = data[index][7];
                    break;
                case "OUTAMOUNT":
                    value = data[index][8];
                    break;
                case "INAMOUNT":
                    value = data[index][9];
                    break;
                default:
                    break;
            }
        }

        return value;
    }

}
