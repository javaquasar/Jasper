package com.javaquasar.jasper.subreport_1.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSource;
import java.math.BigDecimal;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SummaryDataSource extends AdstractDataSource {

    private final Object[][] data = {
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "PLN",
             "4564********1234",
             "12345678",  
             "Name Name",
             "380505214545",
             
             new BigDecimal("1107720"), 
             new BigDecimal("6550"), 
             new BigDecimal("28800"), 
             new BigDecimal("1078920"),
             1
        },
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "PLN",
             "4564********1234",
             "12345678",  
             "Name Name",
             "380505214545",
             
             new BigDecimal("1107720"), 
             new BigDecimal("6550"), 
             new BigDecimal("28800"), 
             new BigDecimal("1078920"),
             1
        },
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "EUR",
             "4564********1234",
             "12345678",  
             "Name Name",
             "380505214545",
             
             new BigDecimal("1107720"), 
             new BigDecimal("6550"), 
             new BigDecimal("28800"), 
             new BigDecimal("1078920"),
             1
        }
    };

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        String fieldName = field.getName();

        if (null != fieldName) {
            switch (fieldName) {
                case "CORPCLIENTID":
                    value = data[index][0];
                    break;
                case "CORPCLIENTNAME":
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
                case "MASKEDPAN":
                    value = data[index][6];
                    break;
                case "CARDTOKEN":
                    value = data[index][7];
                    break;
                case "CLIENTNAME":
                    value = data[index][8];
                    break;
                 case "PHONENO":
                    value = data[index][9];
                    break;
                case "OPENBALANCE":
                    value = data[index][10];
                    break;
                case "INMOVE":
                    value = data[index][11];
                    break;
                case "OUTMOVE":
                    value = data[index][12];
                    break;
                case "CLOSEBALANCE":
                    value = data[index][13];
                    break;
                case "PRIORITY":
                    value = data[index][14];
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
