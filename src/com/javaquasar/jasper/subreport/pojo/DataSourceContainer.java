package com.javaquasar.jasper.subreport.pojo;

import java.util.List;
import java.util.Map;

public class DataSourceContainer {
    List<List<Object>> data;
    Map<String, Integer> key;

    public DataSourceContainer() {
    }

    public DataSourceContainer(Map<String, Integer> key, List<List<Object>> dataList) {
        this.data = data;
        this.key = key;    
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }

    public Map<String, Integer> getKey() {
        return key;
    }

    public void setKey(Map<String, Integer> key) {
        this.key = key;
    }
    
}
