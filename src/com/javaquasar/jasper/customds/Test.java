/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaquasar.jasper.customds;

import com.javaquasar.jasper.customds.CustomDataSource;
import com.javaquasar.jasper.util.JasperCompailer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

/**
 *
 * @author Java Quasar
 */
public class Test {
    
    //https://www.sqliteconcepts.org/pl_proc.html
    public static void main(String[] args) throws JRException, IOException {
        JasperCompailer.compaile("./resources/templates/custom_ds/");
        long start = System.currentTimeMillis();
        //Preparing parameters
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", "Address Report");
        parameters.put("DataFile", "CustomDataSource.java");

        //JasperFillManager.fillReportToFile("./build/reports/DataSourceReport.jasper", parameters, new CustomDataSource());
        
        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/custom_ds/DataSourceReport.jasper", parameters, new CustomDataSource());
        //JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/ds_test/DataSourceReport.jasper", parameters, new JRBeanArrayDataSource(CustomBeanFactory.getBeanArray()));

        JasperExportManager.exportReportToPdfFile(jasperPrint, "./pdf/custom_ds/custom_ds.pdf");
        System.err.println("Filling time : " + (System.currentTimeMillis() - start));
    }
}
