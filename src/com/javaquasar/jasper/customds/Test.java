package com.javaquasar.jasper.customds;

import com.javaquasar.jasper.customds.CustomDataSource;
import com.javaquasar.jasper.util.JasperCompailer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

/**
 *
 * @author Java Quasar
 */
public class Test {

    //https://www.sqliteconcepts.org/pl_proc.html
    public static void main(String[] args) throws JRException, IOException {
        JasperCompailer.compaile("./resources/templates/custom_ds/");
        //Preparing parameters
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", "Address Report");
        parameters.put("DataFile", "CustomDataSource.java");

        //JasperFillManager.fillReportToFile("./build/reports/DataSourceReport.jasper", parameters, new CustomDataSource());
        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/custom_ds/DataSourceReport.jasper", parameters, new CustomDataSource());
        //JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/ds_test/DataSourceReport.jasper", parameters, new JRBeanArrayDataSource(CustomBeanFactory.getBeanArray()));

        pdf(jasperPrint, "./pdf/custom_ds/custom_ds.pdf");
        csv(jasperPrint, "./pdf/custom_ds/custom_ds.csv");
    }
    
    public static void pdf(JasperPrint jasperPrint, String pathToDestFile) throws JRException {
        long start = System.currentTimeMillis();
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToDestFile);
        System.err.println("Pdf creation time : " + (System.currentTimeMillis() - start));
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
