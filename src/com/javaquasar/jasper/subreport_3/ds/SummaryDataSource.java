package com.javaquasar.jasper.subreport_3.ds;

import com.javaquasar.jasper.subreport_2.ds.*;
import java.math.BigDecimal;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SummaryDataSource implements JRDataSource {

    private final Object[][] data = {
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "Main Account", "PLN", new BigDecimal("28800"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "Main Account", "PLN", new BigDecimal("28800"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "EUR Account", "EUR", new BigDecimal("28800"), new BigDecimal("1078920")},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", "PL10124069604100800000000215", "EUR Account", "EUR", new BigDecimal("28800"), new BigDecimal("1078920")}
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
                case "OUTAMOUNT":
                    value = data[index][7];
                    break;
                case "INAMOUNT":
                    value = data[index][8];
                    break;
                default:
                    break;
            }
        }

        return value;
    }

}
