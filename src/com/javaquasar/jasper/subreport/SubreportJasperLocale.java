package com.javaquasar.jasper.subreport;
/**
 *
 * @author Java Quasar
 */
public enum SubreportJasperLocale {

    EN("en", "./resources/localization/localization_en.properties"),
    PL("pl", "./resources/localization/localization_pl.properties"),
    UK("uk", "./resources/localization/localization_uk.properties"),
    RU("ru", "./resources/localization/localization_ru.properties");

    private final String locale;
    private final String pathToFile;

    private SubreportJasperLocale(String locale, String pathToFile) {
        this.locale = locale;
        this.pathToFile = pathToFile;
    }

    public String getLocale() {
        return locale;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public static SubreportJasperLocale findByLocale(String locale) {
        if (locale != null) {
            for (SubreportJasperLocale jl : values()) {
                if (locale.toLowerCase().equals(jl.getLocale())) {
                    return jl;
                }
            }
        } 
        return EN;
    }

}
