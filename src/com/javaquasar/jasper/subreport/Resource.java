package com.javaquasar.jasper.subreport;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import java.net.URLConnection;

import java.nio.charset.StandardCharsets;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author artur
 */
public class Resource {
   
    private static final ResourceBundle.Control control = new Utf8ResourceBundleControl();

    
    public static void main(String[] args) {
        System.out.println("Current Locale: " + Locale.getDefault());
        ResourceBundle messageBundle = ResourceBundle.getBundle("MyLabels", control);
        System.out.println(messageBundle.getString("header_name"));
    }
    
        private static class Utf8ResourceBundleControl extends ResourceBundle.Control {
        
        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws 
                                                                                                                            IllegalAccessException, 
                                                                                                                            InstantiationException, 
                                                                                                                            IOException {
            // The below is a copy of the default implementation.
            String bundleName = toBundleName(baseName, locale);
            ResourceBundle bundle = null;
            if (format.equals("java.class")) {
                try {
                    @SuppressWarnings("unchecked")
                    Class<? extends ResourceBundle> bundleClass = (Class<? extends ResourceBundle>)loader.loadClass(bundleName);

                    // If the class isn't a ResourceBundle subclass, throw a
                    // ClassCastException.
                    if (ResourceBundle.class.isAssignableFrom(bundleClass)) {
                        bundle = bundleClass.newInstance();
                    } else {
                        throw new ClassCastException(bundleClass.getName()
                                     + " cannot be cast to ResourceBundle");
                    }
                } catch (ClassNotFoundException e) {
                }
            } else if (format.equals("java.properties")) {
                final String resourceName = toResourceName0(bundleName, "properties");
                if (resourceName == null) {
                    return bundle;
                }
                final ClassLoader classLoader = loader;
                final boolean reloadFlag = reload;
                InputStream stream = null;
                try {
                    stream = AccessController.doPrivileged(
                        new PrivilegedExceptionAction<InputStream>() {
                            public InputStream run() throws IOException {
                                InputStream is = null;
                                if (reloadFlag) {
                                    URL url = classLoader.getResource(resourceName);
                                    if (url != null) {
                                        URLConnection connection = url.openConnection();
                                        if (connection != null) {
                                            // Disable caches to get fresh data for
                                            // reloading.
                                            connection.setUseCaches(false);
                                            is = connection.getInputStream();
                                        }
                                    }
                                } else {
                                    is = classLoader.getResourceAsStream(resourceName);
                                }
                                return is;
                            }
                        });
                } catch (PrivilegedActionException e) {
                    throw (IOException) e.getException();
                }
                if (stream != null) {
                    InputStreamReader inputStreamReader = null;
                    try {
                        // Only this line is changed to make it to read properties files as UTF-8.
                        inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8.name());
                        bundle = new PropertyResourceBundle(inputStreamReader);
                    } finally {
                        stream.close();
                        inputStreamReader.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("unknown format: " + format);
            }
            return bundle;
        }
        
        // The below is a copy of the default implementation.
        private String toResourceName0(String bundleName, String suffix) {
            // application protocol check
            if (bundleName.contains("://")) {
                return null;
            } else {
                return toResourceName(bundleName, suffix);
            }
        }


    }

}
