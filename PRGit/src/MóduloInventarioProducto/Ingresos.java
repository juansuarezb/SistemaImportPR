/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MóduloInventarioProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author juand_jus2zd
 */
public class Ingresos {
    private ArrayList<Producto> productosIngresados;
    private int id, cantidad;
    ConexionBD con = new ConexionBD();
    Connection cn = con.conectar();
    
     // Constructor
    public Ingresos(int id, int cant ) {
        this.id = id;
        
        this.productosIngresados = new ArrayList<>();
        this.cantidad = cant;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public ArrayList<Producto> getProductosIngresados() {
        return productosIngresados;
    }

    public void setProductosIngresados(ArrayList<Producto> productosIngresados) {
        this.productosIngresados = productosIngresados;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
      public int aumentarStock(Producto producto, int cantidad) {
        int nuevoStock = producto.getStockActual(); // Obtenemos el stock actual
        
        if (cantidad > 0) {
            nuevoStock += cantidad; // Aumentamos el stock actualizado
            producto.setStockActual(nuevoStock); // Actualizamos el stock en el producto
            
        } else {
            JOptionPane.showMessageDialog(null, "Error: La cantidad a aumentar debe ser mayor que cero.");
        }
        
        return nuevoStock; // Devolvemos el nuevo valor del stock
    }
      
      
    public Date fechaActual() {
    return new java.sql.Date(System.currentTimeMillis());
}
      
    public void addProducto(Producto producto, int cantidadS, int idP ){
    String consulta = "UPDATE inventario SET stock_producto = ? WHERE id_producto = ?";
    String consulta2 = "INSERT INTO ingresos (id_producto, cantidad_ingresada, fecha_ingreso) VALUES (?,?,?)";
 
    try (
    PreparedStatement statement = cn.prepareStatement(consulta); 
    PreparedStatement statement2 = cn.prepareStatement(consulta2)){
    statement.setInt(1, aumentarStock(producto, cantidadS)); // Establecer la nueva cantidad de stock
    statement.setInt(2, idP); // Establecer el ID del producto a actualizar
    statement.executeUpdate();
    statement2.setInt(1, idP);
    statement2.setInt(2, cantidadS);
    statement2.setDate(3, new java.sql.Date(fechaActual().getTime()));
    statement2.executeUpdate();

    JOptionPane.showMessageDialog(null, "Stock aumentado correctamente.");
    productosIngresados.add(producto);
    }catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Error al registrar el producto: " + ex.getMessage());
    } 
       
    }
      
}
