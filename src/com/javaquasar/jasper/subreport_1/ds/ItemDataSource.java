package com.javaquasar.jasper.subreport_1.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSourceOld;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ItemDataSource extends AdstractDataSourceOld {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Object[][] data = {
        {
            createDate("2017-09-05"),
            createDate("2017-09-08"),
            "545598******1111",
            "111111",
            "CONTACTLESS PURCHASE",
            "Starbucks",
            "36 Golf Road,Mablethorpe, LN12, United Kingdom",
            826,
            "UAH",
            new BigDecimal(-91175),
            826,
            "PLN",
            new BigDecimal(-10025),
            new BigDecimal(0.1429),
            new BigDecimal(-100),
            985,
            "PLN",
            new BigDecimal(-100),
            985,
            "PLN",
            new BigDecimal("100050"),
            new BigDecimal("-10035"),
            new BigDecimal("84025"),
            new BigDecimal("157567"),
            null
        },
        {
            createDate("2017-09-06"),
            null,
            "545598******1111",
            "111111",
            "DIP TRANSFER",
            "TheCompany LTD",
            null,
            826,
            "PLN",
            new BigDecimal(70552),
            826,
            "PLN",
            new BigDecimal(70552),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            new BigDecimal("100050"),
            new BigDecimal("70552"),
            new BigDecimal("154567"),
            new BigDecimal("157567"),
            null
        },
        {
            createDate("2017-09-13"),
            null,
            "545598******1111",
            "111111",
            "DIP TRANSFER",
            "Matthew May",
            null,
            826,
            "PLN",
            new BigDecimal(-3000),
            826,
            "PLN",
            new BigDecimal(-3000),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            new BigDecimal("100050"),
            new BigDecimal("-3000"),
            new BigDecimal("154567"),
            new BigDecimal("157567"),
            "Jake Bailey"
        },
        {
            createDate("2017-08-01"),
            null,
            "545598******4813",
            "495148291",
            "Przelew DiP",
            "BFX Investements LLC",
            "DETAILS",
            826,
            "EUR",
            new BigDecimal(200),
            826,
            "EUR",
            new BigDecimal(100),
            new BigDecimal(0.5),
            new BigDecimal(60),
            985,
            "PLN",
            new BigDecimal(40),
            985,
            "PLN",
            new BigDecimal("7700"),
            new BigDecimal("1000"),
            new BigDecimal("7700"),
            new BigDecimal("7600"),
            null
        }
    };

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        String fieldName = field.getName();

        if (null != fieldName) {
            switch (fieldName) {
                case "ITEMDATE":
                    value = data[index][0];
                    break;
                case "EVENTDATE":
                    value = data[index][1];
                    break;
                case "MASKEDPAN":
                    value = data[index][2];
                    break;
                case "CARDTOKEN":
                    value = data[index][3];
                    break;
                case "TYPENAME":
                    value = data[index][4];
                    break;
                case "FULLNAME":
                    value = data[index][5];
                    break;
                case "DETAILS":
                    value = data[index][6];
                    break;
                case "TRNCURRENCYID":
                    value = data[index][7];
                    break;
                case "TRNCURRENCYCODE":
                    value = data[index][8];
                    break;
                case "TRNAMOUNT":
                    value = data[index][9];
                    break;
                case "ACCCURRENCYID":
                    value = data[index][10];
                    break;
                case "ACCCURRENCYCODE":
                    value = data[index][11];
                    break;
                case "ACCAMOUNT":
                    value = data[index][12];
                    break;
                case "RATE":
                    value = data[index][13];
                    break;
                case "TRNFEEAMOUNT":
                    value = data[index][14];
                    break;
                case "TRNFEECURRENCYID":
                    value = data[index][15];
                    break;
                case "TRNFEECURRENCYCODE":
                    value = data[index][16];
                    break;
                case "CONVFEEAMOUNT":
                    value = data[index][17];
                    break;
                case "CONVFEECURRENCYID":
                    value = data[index][18];
                    break;
                case "CONVFEECURRENCYCODE":
                    value = data[index][19];
                    break;
                case "OPENBALANCE":
                    value = data[index][20];
                    break;
                case "TOTALAMOUNT":
                    value = data[index][21];
                    break;
                case "BALANCE":
                    value = data[index][22];
                    break;
                case "CLOSEBALANCE":
                    value = data[index][23];
                    break;
                case "MADEBY":
                    value = data[index][24];
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
