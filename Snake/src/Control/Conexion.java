/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String drive="com.mysql.jdbc.Driver";
    private static final String user="root";//ESTE ES USUARIO DE LA BASE DE DATOS
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/estudiantes";//URL PARA LA CONEXION CON LA BASE DE DATOS
    Connection conectar = null;
    
    public Connection conexion(){//METODO PARA LOGRAR ESTABLECER LA CONEXION
        
        try{
            Class.forName(drive);
            conectar=(Connection) DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error de conexion "+e.getMessage());//MENSAJE EN CASO DE ERROR POR EXCEPCION
        }
        return conectar;
    }
}
