package com.javaquasar.jasper.subreport_3;

import com.javaquasar.jasper.subreport.SubreportJasperLocale;
import com.javaquasar.jasper.subreport_3.ds.SummaryDataSource;
import com.javaquasar.jasper.util.JasperCompailer;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Java Quasar
 */
public class SubreportPdfGenerator {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BigDecimal b1 =  new BigDecimal("-28100");
        BigDecimal b2 =  new BigDecimal("0");
        System.out.println(b2.equals(new BigDecimal("0")));
        
        System.out.println(b2.add(b1).toString());
        b2.add(b1);
        JasperCompailer.compaile("./resources/templates/subreport_3/");
        try {
            generateReport(null, "en", "./pdf/subreport/subreport_3.pdf");
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public static void generateReport(Connection connection, String locale, String pathForReport) throws Exception {

        SubreportJasperLocale jl = SubreportJasperLocale.findByLocale(locale);

        HashMap<String, Object> map = new HashMap();
        map.put("locale", jl.getLocale());
        map.put("report_date", format.parse("2017-08-01"));
        map.put("client_name", "Corp Corp");
        map.put("summary_ds", new SummaryDataSource());

        map.put(JRParameter.REPORT_LOCALE, new Locale(jl.getLocale()));

        FileInputStream fis = new FileInputStream(jl.getPathToFile());
        PropertyResourceBundle prop = new PropertyResourceBundle(fis);

        map.put("REPORT_RESOURCE_BUNDLE", prop);
        map.put("SUBREPORT_DIR", "./resources/templates/subreport_3/");

        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/subreport_3/statements_final.jasper", map, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, pathForReport);
    }

}
