/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MóduloVentaFacturación;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Main {
          
     public static String mUsuario;
    public static String mPass;

    public static boolean mEsVendedor;
    public static boolean mEsAdmin;

    public static ArrayList<Usuario> mListaDeUsuarios = new ArrayList();
    //public static ArrayList<Producto> mListaDeProductos = new ArrayList();
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ArrayList<String> mListaDeRoles = new ArrayList();

        mListaDeRoles.add("Administrador");
        mListaDeRoles.add("Vendedor");

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Rose");
        usuario1.setPass("Rose");
        usuario1.setCorreoElectronico("rmolinah@gmail.com");
        usuario1.setListaRoles(mListaDeRoles);
        usuario1.setHizoEncuestaExperiencia(false);
        usuario1.setHizoEncuestaPersonal(false);

        mListaDeRoles = new ArrayList();
        mListaDeRoles.add("Administrador");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Admin");
        usuario2.setPass("Admin");
        usuario2.setListaRoles(mListaDeRoles);
        usuario2.setHizoEncuestaExperiencia(false);
        usuario2.setHizoEncuestaPersonal(false);

        mListaDeRoles = new ArrayList();
        mListaDeRoles.add("Vendedor");

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Vendedor1");
        usuario3.setPass("Vendedor1");
        usuario3.setListaRoles(mListaDeRoles);
        usuario3.setHizoEncuestaExperiencia(false);
        usuario3.setHizoEncuestaPersonal(false);

        //Vamos a agregar el usuario por defecto a la lista de usuarios (este siempre va a existir que se ejecute el programa)
        mListaDeUsuarios.add(usuario1); //Tiene el rol de administrador y vendedor
        mListaDeUsuarios.add(usuario2); //Tiene el rol de administrador
        mListaDeUsuarios.add(usuario3); //Tiene el rol de vendedor
                
                
                
                
                Login login = new Login();
                login.setVisible(true);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                login.setLocationRelativeTo(null);
                // Establecer la operación de cierre por defecto
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                       
            }
        });
    }
}

