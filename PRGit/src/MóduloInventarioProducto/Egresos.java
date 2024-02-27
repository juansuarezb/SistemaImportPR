/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MóduloInventarioProducto;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author juand_jus2zd
 */
public class Egresos {
    private ArrayList<Producto> productosEgresados;
    private int id, cantidad;
    private String razon;
     ConexionBD con = new ConexionBD();
    Connection cn = con.conectar();
    
     // Constructor
    public Egresos(int id, int cant, String razon) {
        this.id = id;
        this.razon = razon;
        this.productosEgresados = new ArrayList<>();
        this.cantidad = cant;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public ArrayList<Producto> getProductosEgresados() {
        return productosEgresados;
    }

    public void setProductosEgresados(ArrayList<Producto> productosEgresados) {
        this.productosEgresados = productosEgresados;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    public int reducirStock(Producto producto, int cantidad) throws IllegalArgumentException {
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(null, "Error: La cantidad a reducir debe ser mayor que cero.");
        return -1; // Indicar un error
    }

    int stockActual = producto.getStockActual();
    if (cantidad > stockActual) {
        JOptionPane.showMessageDialog(null, "Error: La cantidad a reducir es mayor que el stock actual.");
        return -1; // Indicar un error
    }

    return stockActual - cantidad;
}
    
    public Date fechaActual() {
    return new java.sql.Date(System.currentTimeMillis());
}
    
      public void addProducto(Producto producto, int cantidadS, int idP, String razon ){
    String consulta = "UPDATE inventario SET stock_producto = ? WHERE id_producto = ?";
    String consulta2 = "INSERT INTO egresos (id_producto, cantidad_egresada, razon_egreso, fecha_egreso) VALUES (?,?,?,?)";
 
    try (
    PreparedStatement statement2 = cn.prepareStatement(consulta2);
    PreparedStatement statement = cn.prepareStatement(consulta)) {
    
        
    int nuevoStock = reducirStock(producto, cantidadS);

    if (nuevoStock >= 0) {
    statement.setInt(1, nuevoStock); // Establecer el nuevo stock si es mayor o igual a cero
     statement.setInt(1, reducirStock(producto, cantidadS)); // Establecer la nueva cantidad de stock
    statement.setInt(2, idP); // Establecer el ID del producto a actualizar
    statement.executeUpdate();
    
    statement2.setInt(1, idP);
    statement2.setInt(2, cantidadS);
    statement2.setString(3, razon);
    statement2.setDate(4, new java.sql.Date(fechaActual().getTime()));
    
    statement2.executeUpdate();
    productosEgresados.add(producto);

    } else {
        
        
        
        
    
    }
    }catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Error al registrar el producto: " + ex.getMessage());
    } 
       
    }
    
    
    
}