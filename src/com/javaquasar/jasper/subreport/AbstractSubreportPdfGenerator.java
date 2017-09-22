package com.javaquasar.jasper.subreport;

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
public class AbstractSubreportPdfGenerator {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static final String JDBC_URL = "";
    private static final String DRIVER_NAME = "";
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

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
        map.put("SUBREPORT_DIR", "./resources/templates/subreport_1/");

        //JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/subreport/statements_final.jasper", map, connection/*new JREmptyDataSource()*/);
        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/subreport_2/statements_final.jasper", map, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, pathForReport);
        byte[] mass = JasperExportManager.exportReportToPdf(jasperPrint);
    }

    private static List<List<String>> convertResultSetToList(ResultSet rs) throws SQLException {
        List<List<String>> dataList = new ArrayList<>();
        dataList.add(new ArrayList<>());
        ResultSetMetaData metaData = rs.getMetaData();
        int countColumn = metaData.getColumnCount();
        for (int i = 1; i <= countColumn; i++) {
            dataList.get(0).add(metaData.getColumnName(i));
        }
        int row = 1;
        while (rs.next()) {
            dataList.add(new ArrayList<>());
            for (int i = 1; i <= countColumn; i++) {
                String result = rs.getString(i);
                System.out.print(result);
                System.out.print(" ");
                dataList.get(row).add(result);
            }
            row++;
            System.out.println("");
        }
        return dataList;
    }

}
