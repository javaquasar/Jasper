package com.javaquasar.jasper.subreport_3.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSourceOld;
import java.math.BigDecimal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SummaryDataSource extends AdstractDataSourceOld {

    private final Object[][] data = {
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", 985, "PLN", "PL10124069604100800000000215", "Main Account", null, new BigDecimal("-1000000"), new ItemDataSource1()},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", 985, "PLN", "PL10124069604100800000000216", "Main Account", null, new BigDecimal("-1000000"), new ItemDataSource1()},
        {new BigDecimal("2410"), "BFX Investements LLC", "08/01/17", "09/01/17", 826, "EUR", "PL10124069604100800000000217", "EUR Account", new BigDecimal("+10010"), null, new ItemDataSource2()}
    };

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
                case "CURRENCYID":
                    value = data[index][4];
                    break;
                case "CURRENCYCODE":
                    value = data[index][5];
                    break;
                case "IBAN":
                    value = data[index][6];
                    break;
                case "ACCOUNTNAME":
                    value = data[index][7];
                    break;
                case "OUTAMOUNT":
                    value = data[index][8];
                    break;
                case "INAMOUNT":
                    value = data[index][9];
                    break;
                case "ITEM_DS":
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
