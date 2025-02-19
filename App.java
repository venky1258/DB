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
        String url = "jdbc:mysql://localhost:3306/bdb?useSSL=false";
        String user = "root";
        String password = "root";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);

            // SQL query to retrieve image
            String sql = "SELECT pimage FROM pr1 WHERE pid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1); // Assuming you want to retrieve the image with id = 1
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // Retrieve the image as a binary stream
                InputStream inputStream = rs.getBinaryStream("pimage");

                // Output the image to a file
                FileOutputStream outputStream = new FileOutputStream("retrieved_image.jpg");

                byte[] buffer = new byte[1024];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();

                System.out.println("Image retrieved successfully.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}