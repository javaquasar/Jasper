package com.javaquasar.jasper.subreport_1.ds;

import com.javaquasar.jasper.subreport.ds.AdstractDataSourceOld;
import java.math.BigDecimal;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SummaryDataSource extends AdstractDataSourceOld {

    private final Object[][] data = {
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "PLN",
             "545598******1111",
             "111111",  
             "Konstantin Konstantinov",
             "+48123456789",
             
             new BigDecimal("100050"), 
             new BigDecimal("70552"), 
             new BigDecimal("13035"), 
             new BigDecimal("157567"),
             1
        },
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "PLN",
             "545598******2222",
             "222222",  
             "Tomasz Czernik",
             "+48888333252",
             
             new BigDecimal("53444"), 
             new BigDecimal("7200"), 
             new BigDecimal("45286"), 
             new BigDecimal("13558"),
             1
        },
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "PLN",
             "545598******5555",
             "555555",  
             "Domasz Dzernik",
             "+48888333253",
             
             new BigDecimal("53444"), 
             new BigDecimal("0"), 
             new BigDecimal("0"), 
             new BigDecimal("53444"),
             1
        },
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "EUR",
             "545598******3333",
             "333333",  
             "Łukasz Krysiak",
             "+48882509944",
             
             new BigDecimal("100050"), 
             new BigDecimal("70552"), 
             new BigDecimal("13035"), 
             new BigDecimal("157567"),
             1
        },
        {
             2410L, 
             "BFX Investements LLC", 
             createDate("2017-08-5"), 
             createDate("2017-08-20"),             
             826,
             
             "EUR",
             "545598******4444",
             "444444",  
             "Bohdan Potocki-Bielecki",
             "+48888333252",
             
             new BigDecimal("53444"), 
             new BigDecimal("7200"), 
             new BigDecimal("45286"), 
             new BigDecimal("13558"),
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
