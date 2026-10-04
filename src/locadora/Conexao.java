/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Guilherme
 */
public class Conexao {
    
    private Connection conn;

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora1","root","Guig6200!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
    
    

