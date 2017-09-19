/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaquasar.jasper.customds;

import com.javaquasar.jasper.customds.CustomDataSource;
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
 * @author artur
 */
public class Test {
    
    //https://www.sqliteconcepts.org/pl_proc.html
    public static void main(String[] args) throws JRException {
        
        long start = System.currentTimeMillis();
        //Preparing parameters
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", "Address Report");
        parameters.put("DataFile", "CustomDataSource.java");

        //JasperFillManager.fillReportToFile("./build/reports/DataSourceReport.jasper", parameters, new CustomDataSource());
        
        JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/ds_test/DataSourceReport.jasper", parameters, new CustomDataSource());
        //JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/ds_test/DataSourceReport.jasper", parameters, new JRBeanArrayDataSource(CustomBeanFactory.getBeanArray()));

//JasperPrint jasperPrint = JasperFillManager.fillReport("./resources/templates/bank_transfer_confirmation.jasper", map, connection/*new JREmptyDataSource()*/);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "./pdf/test/test_2.pdf");
        System.err.println("Filling time : " + (System.currentTimeMillis() - start));
    }
}
