package com.myproj.D2;



import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

/**
 * Hello world!
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileOutputStream;
import java.io.InputStream;

public class App {

    public static void main(String[] args) {
        int ar[]={8,2,1,9,7,6,9};
        int m=ar[0];
        int sm=ar[0];
        int i;
        for(i=1;i<ar.length;i++)
        {
            if(m<ar[i])
            {
                if(sm<m)
                  sm=m;
                m=ar[i];
            }
        }
        System.out.println(sm+" "+m);
    }}