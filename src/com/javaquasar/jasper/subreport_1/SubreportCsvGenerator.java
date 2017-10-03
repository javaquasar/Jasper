package com.javaquasar.jasper.subreport_1;

import com.javaquasar.jasper.subreport.AbstractSubreportPdfGenerator;
import com.javaquasar.jasper.subreport.SubreportJasperLocale;
import com.javaquasar.jasper.subreport_1.ds.csv.CardsCsvDs;
import com.javaquasar.jasper.util.JasperCompailer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

/**
 *
 * @author Java Quasar
 */
public class SubreportCsvGenerator extends AbstractSubreportPdfGenerator {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JasperCompailer.compaile("./resources/templates/portal/");
        try {
            generateReport(null, "en", "./pdf/subreport/subreport_1.csv");
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public static void generateReport(Connection connection, String locale, String pathForReport) throws FileNotFoundException, IOException, JRException, SQLException, ParseException {

        SubreportJasperLocale jl = SubreportJasperLocale.findByLocale(locale);

        HashMap<String, Object> map = new HashMap();
        map.put("locale", jl.getLocale());

        map.put(JRParameter.REPORT_LOCALE, new Locale(jl.getLocale()));

        FileInputStream fis = new FileInputStream(jl.getPathToFile());
        PropertyResourceBundle prop = new PropertyResourceBundle(fis);

        map.put("REPORT_RESOURCE_BUNDLE", prop);
        map.put("SUBREPORT_DIR", "./resources/templates/portal/1_cards/csv/");

        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/portal/1_cards/csv/csv_final.jasper", map, new CardsCsvDs());
        csv(jasperPrint, pathForReport);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "./pdf/subreport/subreport_0.pdf");

        //byte[] mass = JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public static void csv(JasperPrint jasperPrint, String pathToDestFile) throws JRException {
        long start = System.currentTimeMillis();
        File destFile = new File(pathToDestFile);
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));
        exporter.exportReport();
        System.err.println("CSV creation time : " + (System.currentTimeMillis() - start));
    }

}
