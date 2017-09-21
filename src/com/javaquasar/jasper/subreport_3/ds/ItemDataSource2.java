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

public class ItemDataSource2 implements JRDataSource {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Object[][] data = {
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5009"), "545598******5678", "125671983", "+380501111111", "Name 11", createDate("2017-08-01"), "Przelew ZiP", new BigDecimal("70000"), new BigDecimal("-20000")},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5009"), "545598******5678", "125671983", "+380501111111", "Name 11", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5009"), "545598******5678", "125671983", "+380501111111", "Name 11", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5008"), "545598******7897", "797989797", "+380502222222", "Name 20", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5008"), "545598******7897", "797989797", "+380502222222", "Name 20", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5020"), "545598******8936", "768243675", "+380503333333", "Name 30", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5020"), "545598******8936", "768243675", "+380503333333", "Name 30", createDate("2017-06-01"), "Przelew FiP", new BigDecimal("20000"), null},
        {826, "PLN", "PL10124069604100800000000216", new BigDecimal("5020"), "545598******8936", "768243675", "+380503333333", "Name 30", createDate("2017-08-01"), "Przelew ZiP", new BigDecimal("10050"), new BigDecimal("-10000")}
    };

    private int index = -1;

    public ItemDataSource2() {
    }

    private java.sql.Timestamp createDate(String date) {
        try {
            Date parsed = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            java.sql.Timestamp time = new java.sql.Timestamp(sqlDate.getTime());
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(ItemDataSource2.class.getName()).log(Level.SEVERE, null, ex);
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
                case "CURRENCYID":
                    value = data[index][0];
                    break;
                case "CURRENCYCODE":
                    value = data[index][1];
                    break;
                case "IBAN":
                    value = data[index][2];
                    break;
                case "CARDID":
                    value = data[index][3];
                    break;
                case "MASKEDPAN":
                    value = data[index][4];
                    break;
                case "DETAILS":
                    value = data[index][5];
                    break;
                case "PHONE":
                    value = data[index][6];
                    break;
                case "FULLNAME":
                    value = data[index][7];
                    break;
                case "ITEMDATE":
                    value = data[index][8];
                    break;
                case "TYPENAME":
                    value = data[index][9];
                    break;
                case "OUTAMOUNT":
                    value = data[index][10];
                    break;
                case "INAMOUNT":
                    value = data[index][11];
                    break;
                default:
                    break;
            }
        }

        return value;
    }

}
