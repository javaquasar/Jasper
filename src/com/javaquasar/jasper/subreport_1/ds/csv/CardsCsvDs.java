package com.javaquasar.jasper.subreport_1.ds.csv;

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
        keyMap.put("EVENTDATE", 1);
        keyMap.put("MASKEDPAN", 2);
        keyMap.put("CARDTOKEN", 3);
        keyMap.put("TYPENAME", 4);
        keyMap.put("FULLNAME", 5);
        keyMap.put("DETAILS", 6);
        keyMap.put("TRNCURRENCYCODE", 7);
        keyMap.put("TRNAMOUNT", 8);
        keyMap.put("RATE", 9);
        keyMap.put("ACCCURRENCYCODE", 10);
        keyMap.put("ACCAMOUNT", 11);
        keyMap.put("CONVFEEAMOUNT", 12);
        keyMap.put("TRNFEEAMOUNT", 13);
        keyMap.put("TOTALAMOUNT", 14);
    }
    
    static List<List<Object>> list = new ArrayList<>();
    
    static {
        List<Object> row1 = new ArrayList<>();
        row1.add(createDate("2017-08-5"));
        row1.add(createDate("2017-08-8"));
        row1.add("545598******1111");
        row1.add("1234token5678");
        row1.add("Transfer");
        row1.add("ROST");
        row1.add("sales box");
        row1.add("PLN");
        row1.add(new BigDecimal("100050"));
        row1.add(new BigDecimal(1.0));
        row1.add("PLN");
        row1.add(new BigDecimal("100050"));
        row1.add(new BigDecimal("50"));
        row1.add(new BigDecimal("50"));
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
