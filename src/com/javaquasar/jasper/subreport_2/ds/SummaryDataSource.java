package com.javaquasar.jasper.subreport_2.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSource;
import java.math.BigDecimal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SummaryDataSource extends AdstractDataSource {

    private final Object[][] data = {
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "Main Account", "PLN", new BigDecimal("1107720"), new BigDecimal("550"), new BigDecimal("28800"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000216", "Main Account", "PLN", new BigDecimal("1107720"), new BigDecimal("450"), new BigDecimal("28800"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000217", "EUR Account", "EUR", new BigDecimal("1107720"), new BigDecimal("10"), new BigDecimal("25000"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000218", "EUR Account", "EUR", new BigDecimal("1107720"), new BigDecimal("10"), new BigDecimal("20000"), new BigDecimal("1078920")}
    };

    public SummaryDataSource() {
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        String fieldName = field.getName();

        if (null != fieldName) {
            switch (fieldName) {
                case "CLIENTID":
                    value = data[index][0];
                    break;
                case "CLIENTNAME":
                    value = data[index][1];
                    break;
                case "FROMDATE":
                    value = data[index][2];
                    break;
                case "TILLDATE":
                    value = data[index][3];
                    break;
                case "IBAN":
                    value = data[index][4];
                    break;
                case "ACCOUNTNAME":
                    value = data[index][5];
                    break;
                case "CURRENCYCODE":
                    value = data[index][6];
                    break;
                case "OPENBALANCE":
                    value = data[index][7];
                    break;
                case "INMOVE":
                    value = data[index][8];
                    break;
                case "OUTMOVE":
                    value = data[index][9];
                    break;
                case "CLOSEBALANCE":
                    value = data[index][10];
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
