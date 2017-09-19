package com.javaquasar.jasper.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 *
 * @author Java Quasar
 */
public class JasperCompailer {

    public static void main(String[] args) {
        try {
            compaile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void compaile() throws IOException {
        compaile("./resources");
    }
    
    public static void compaile(String folder) throws IOException {
        Files.walk(Paths.get(folder)).forEach(filePath -> {
            if (filePath.toString().contains(".jrxml")) {
                try {
                    String pathToSource = filePath.toString();
                    String pathToCompileFile = pathToSource.replace(".jrxml", ".jasper");
                    System.out.println(pathToSource);
                    JasperCompileManager.compileReportToFile(pathToSource, pathToCompileFile);
                    System.out.println(pathToCompileFile);
                } catch (JRException ex) {
                    System.out.println(ex);
                }
            }
        });
    }
}
