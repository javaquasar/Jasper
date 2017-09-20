package com.javaquasar.jasper.subreport.ds;

import java.math.BigDecimal;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SummaryDataSource implements JRDataSource {

    private final Object[][] data = {
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "Main Account", "PLN", new BigDecimal("1107720"), new BigDecimal("0"), new BigDecimal("28800"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "EUR Account", "EURN", new BigDecimal("1107720"), new BigDecimal("10"), new BigDecimal("28800"), new BigDecimal("1078920")}
    };

    private int index = -1;

    public SummaryDataSource() {
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
                case "OPENBAL":
                    value = data[index][7];
                    break;
                case "INMOVE":
                    value = data[index][8];
                    break;
                case "OUTMOVE":
                    value = data[index][9];
                    break;
                case "CLOSEBAL":
                    value = data[index][10];
                    break;
                default:
                    break;
            }
        }

        return value;
    }

}
