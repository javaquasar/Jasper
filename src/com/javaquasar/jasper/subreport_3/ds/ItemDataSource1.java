package com.javaquasar.jasper.subreport_3.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSourceOld;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ItemDataSource1 extends AdstractDataSourceOld {
    
    //isTitleNewPage="true"

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Object[][] data = {
        {826, "PLN", "PL10124069604100800000000215", new BigDecimal("5007"), "545598******8596", "789789797", "+380509872464", "Name 8596", createDate("2017-07-01"), "Przelew DiP", new BigDecimal("-10000"), new BigDecimal("-10000")},
        {826, "PLN", "PL10124069604100800000000215", new BigDecimal("5007"), "545598******8596", "789789797", "+380509872464", "Name 8596", createDate("2017-07-01"), "Przelew DiP", new BigDecimal("-10000"), new BigDecimal("-10000")},
        {826, "PLN", "PL10124069604100800000000215", new BigDecimal("5008"), "545598******7415", "495561689", "+380509872464", "Name 7415", createDate("2017-07-01"), "Przelew DiP", new BigDecimal("-10000"), new BigDecimal("-10000")},
        {826, "PLN", "PL10124069604100800000000215", new BigDecimal("5008"), "545598******7415", "495561689", "+380509872464", "Name 7415", createDate("2017-07-01"), "Przelew DiP", new BigDecimal("-10000"), new BigDecimal("-10000")},
        {826, "PLN", "PL10124069604100800000000215", new BigDecimal("5008"), "545598******7415", "495561689", "+380509872464", "Name 7415", createDate("2017-08-01"), "Przelew DiP", new BigDecimal("5464"), new BigDecimal("-5000")}
    };

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
    
    @Override
    protected Object[][] getData() {
        return data;
    }
    

}
