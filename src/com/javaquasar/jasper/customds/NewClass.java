/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaquasar.jasper.customds;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author artur
 */
public class NewClass {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
    }
}
