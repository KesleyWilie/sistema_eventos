package com.sistema.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sistema_eventos";
        String user = "root";
        String password = "Keslwywilie2004!";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
