package com.javaquasar.jasper.subreport_1;

import com.javaquasar.jasper.subreport.AbstractSubreportPdfGenerator;
import com.javaquasar.jasper.subreport_1.ds.SummaryDataSource;
import com.javaquasar.jasper.subreport.SubreportJasperLocale;
import com.javaquasar.jasper.subreport_1.ds.ItemDataSource;
import com.javaquasar.jasper.util.JasperCompailer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Java Quasar
 */
public class SubreportPdfGenerator extends AbstractSubreportPdfGenerator {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static final String JDBC_URL = "";
    private static final String DRIVER_NAME = "";
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //String s = new SimpleDateFormat("MMMM, yyyy", new Locale("en")).format(new Date());
        //System.out.println(s);
        JasperCompailer.compaile("./resources/templates/portal/");
        //Class.forName(DRIVER_NAME);
        //conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
        try /*(Connection conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
                Statement stmt = conn.createStatement();
                Statement stmt2 = conn.createStatement()) */
        {

            /*Date parsed = format.parse("2017-08-01");
            java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
            java.sql.Timestamp time = new java.sql.Timestamp(sqlDate.getTime());

            CallableStatement stm = conn.prepareCall("{ call pkp_PortalStatement.PrepareMainAccStmtMonth(?, ?) }");
            stm.setString(1, "CORP@CORP");
            //stm.setDate(2, sqlDate);
            stm.setTimestamp(2, time);
            stm.execute();

            ResultSet rs = stmt.executeQuery("SELECT \n"
                    + "                CLIENTID,\n"
                    + "                CLIENTNAME,\n"
                    + "                FROMDATE,\n"
                    + "                TILLDATE,\n"
                    + "                IBAN, \n"
                    + "                ACCOUNTNAME, \n"
                    + "                CURRENCYCODE,\n"
                    + "                OPENBAL,\n"
                    + "                INMOVE,\n"
                    + "                OUTMOVE,\n"
                    + "                CLOSEBAL\n"
                    + "            FROM \n"
                    + "                VP_MAINACCSTMTSUM");
            convertResultSetToList(rs);

            ResultSet rs2 = stmt2.executeQuery("SELECT Iban,\n"
                    + "       CurrencyCode,\n"
                    + "       ItemDate,\n"
                    + "       TypeName,\n"
                    + "       FullName,\n"
                    + "       Details,\n"
                    + "       OpenBal,\n"
                    + "       Amount,\n"
                    + "       Bal,\n"
                    + "       CloseBal\n"
                    + "  FROM VP_MainAccStmtItem");
            convertResultSetToList(rs2);*/

            generateReport(null, "en", "./pdf/subreport/subreport_1.pdf");
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public static void generateReport(Connection connection, String locale, String pathForReport) throws FileNotFoundException, IOException, JRException, SQLException, ParseException {

        SubreportJasperLocale jl = SubreportJasperLocale.findByLocale(locale);

        HashMap<String, Object> map = new HashMap();
        map.put("locale", jl.getLocale());
        map.put("report_date", format.parse("2017-08-01"));
        map.put("client_name", "Corp Corp");
        map.put("summary_ds", new SummaryDataSource());
        map.put("item_ds", new ItemDataSource());
        
        map.put(JRParameter.REPORT_LOCALE, new Locale(jl.getLocale()));

        FileInputStream fis = new FileInputStream(jl.getPathToFile());
        PropertyResourceBundle prop = new PropertyResourceBundle(fis);

        map.put("REPORT_RESOURCE_BUNDLE", prop);
        map.put("SUBREPORT_DIR", "./resources/templates/portal/1_cards/pdf/");

        //JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/subreport/statements_final.jasper", map, connection/*new JREmptyDataSource()*/);
        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/portal/1_cards/pdf/statements_final.jasper", map, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, pathForReport);
        byte[] mass = JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
