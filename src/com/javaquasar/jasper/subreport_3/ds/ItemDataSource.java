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

public class ItemDataSource implements JRDataSource {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Object[][] data = {
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-09-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-10-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2019-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"PL10124069604100800000000215", "PLN", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000217", "EUR", createDate("2017-08-25"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000217", "EUR", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000217", "EUR", createDate("2017-12-01"), "Przelew DiP", "Bla bla bla", "495561689", new BigDecimal("110772100"), new BigDecimal("0"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000216", "EUR", createDate("2017-08-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000216", "EUR", createDate("2017-01-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")},
        {"ER10124069604100800000000216", "EUR", createDate("2017-03-01"), "Przelew DiP", ". .", "495561689", new BigDecimal("110772100"), new BigDecimal("-28800"), new BigDecimal("28800"), new BigDecimal("107892100")}
    };

    private int index = -1;

    public ItemDataSource() {
    }

    private java.sql.Timestamp createDate(String date) {
        try {
            Date parsed = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            java.sql.Timestamp time = new java.sql.Timestamp(sqlDate.getTime());
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(ItemDataSource.class.getName()).log(Level.SEVERE, null, ex);
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
                case "OPENBAL":
                    value = data[index][6];
                    break;
                case "AMOUNT":
                    value = data[index][7];
                    break;
                case "BAL":
                    value = data[index][8];
                    break;
                case "CLOSEBAL":
                    value = data[index][9];
                    break;
                default:
                    break;
            }
        }

        return value;
    }

}


/*
<!--    <queryString>
	<![CDATA[
            SELECT 
                IBAN,
                CURRENCYCODE,
                ITEMDATE,
                TYPENAME,
                FULLNAME,
                DETAILS,
                OPENBAL,
                AMOUNT,
                BAL,
                CLOSEBAL
            FROM 
                VP_MAINACCSTMTITEM;
        ]]>
    </queryString>-->
    <field name="IBAN" class="java.lang.String"/>
    <field name="CURRENCYCODE" class="java.lang.String"/>
    <field name="ACCOUNTNAME" class="java.lang.String"/>
    <field name="ITEMDATE" class="java.sql.Timestamp"/>
    <field name="TYPENAME" class="java.lang.String"/>
    <field name="FULLNAME" class="java.lang.String"/>
    <field name="DETAILS" class="java.lang.String"/>
    <field name="OPENBAL" class="java.math.BigDecimal"/>
    <field name="AMOUNT" class="java.math.BigDecimal"/>
    <field name="BAL" class="java.math.BigDecimal"/>
    <field name="CLOSEBAL" class="java.math.BigDecimal"/>

 */
