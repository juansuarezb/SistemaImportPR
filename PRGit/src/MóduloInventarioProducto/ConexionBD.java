
package MóduloInventarioProducto;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author juand_jus2zd
 */
public class ConexionBD {
    Connection con = null;
    String url = "jdbc:postgresql://26.77.174.124/productos";
    String user = "Diego";
    String passw = "1234";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, passw);
            
        }catch(Exception e){
            e.printStackTrace(); // Imprime el rastro completo de la excepción
            JOptionPane.showMessageDialog(null, "Fallo al conectar" + e);
            con = null;
        }
        return con;
    }
}
