package com.javaquasar.jasper.subreport_2.ds.csv;

import com.javaquasar.jasper.subreport_1.ds.csv.*;
import com.javaquasar.jasper.subreport.ds.AdstractDataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardsCsvDs extends AdstractDataSource {

    static Map<String, Integer> keyMap = new TreeMap<>();

    static {
        keyMap.put("ITEMDATE", 0);
        keyMap.put("IBAN", 1);
        keyMap.put("ACCOUNTNAME", 2);
        keyMap.put("TYPENAME", 3);
        keyMap.put("FULLNAME", 4);
        keyMap.put("DETAILS", 5);
        keyMap.put("CURRENCYCODE", 6);
        keyMap.put("AMOUNT", 7);
    }
    
    static List<List<Object>> list = new ArrayList<>();
    
    static {
        List<Object> row1 = new ArrayList<>();
        row1.add(createDate("2017-08-9"));
        row1.add("545598123434221111");
        row1.add("Corp card");
        row1.add("Transfer");
        row1.add("ROST");
        row1.add("sales box");
        row1.add("PLN");
        row1.add(new BigDecimal("100050"));
        list.add(row1);        
    }

    @Override
    public List<List<Object>> getData() {
        return list;
    }

    @Override
    public Map<String, Integer> getKeyMap() {
        return keyMap;
    }


}
