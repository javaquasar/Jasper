package com.javaquasar.jasper.subreport_1.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ItemDataSource extends AdstractDataSource {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Object[][] data = {
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", null, "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-09-01"), "Przelew DiP", null, null, new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-10-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2019-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000217", "EUR", createDate("2017-08-25"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000217", "EUR", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000217", "EUR", createDate("2017-12-01"), "Przelew DiP", "Bla bla bla", "495561689", new BigDecimal("110772100"), new BigDecimal("0"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000216", "EUR", createDate("2017-08-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000216", "EUR", createDate("2017-01-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000216", "EUR", createDate("2017-03-01"), "Przelew DiP", "Name Name", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")}
    };

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
                case "ITEMDATE":
                    value = data[index][2];
                    break;
                case "TYPENAME":
                    value = data[index][3];
                    break;
                case "FULLNAME":
                    value = data[index][4];
                    break;
                case "DETAILS":
                    value = data[index][5];
                    break;
                case "OPENBALANCE":
                    value = data[index][6];
                    break;
                case "AMOUNT":
                    value = data[index][7];
                    break;
                case "BALANCE":
                    value = data[index][8];
                    break;
                case "CLOSEBALANCE":
                    value = data[index][9];
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

