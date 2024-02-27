package MóduloInventarioProducto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juand_jus2zd
 */
public class Producto {
    // Atributos
    private String codigo;
    private String nombre;
    private String descripcion;
    private double costo;
    private String categoria;
    private int stockActual;
    private String ubicacion;
    ConexionBD con = new ConexionBD();
    Connection cn = con.conectar();

    // Constructor
    public Producto(String codigo, String nombre, String descripcion, double costo, String categoria, int stockActual, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoria = categoria;
        this.stockActual = stockActual;
        this.ubicacion = ubicacion;
    }
    
    
    
public void registrarProducto(Connection cn, String codigoP, String nombreP, String descripcionP, String costoP, String categoriaP, String stockP, String ubicacionP) {
    try {
        // Preparar la consulta SQL con parámetros
        PreparedStatement pps = cn.prepareStatement("INSERT INTO inventario (id_producto, nombre_producto, descripcion_producto, costo_producto, categoria_producto, stock_producto, ubicacion_producto) VALUES (?, ?, ?, ?, ?, ?, ?)");

        // Establecer los valores de los parámetros
        pps.setInt(1, Integer.parseInt(codigoP));
        pps.setString(2, nombreP);
        pps.setString(3, descripcionP);
        // Convertir el costoP a BigDecimal y establecerlo en el PreparedStatement
        BigDecimal costo = new BigDecimal(costoP);
        pps.setBigDecimal(4, costo);
        pps.setString(5, categoriaP);
        pps.setInt(6, Integer.parseInt(stockP));
        pps.setString(7, ubicacionP);

        // Ejecutar la inserción
        pps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Producto registrado exitosamente.");
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Error al registrar el producto: " + ex.getMessage());
    }
}
   public static Producto buscarProductoPorId(Connection connection, int idProducto) throws SQLException {
        Producto productoEncontrado = null;
        String consulta = "SELECT * FROM inventario WHERE id_producto = ?";

        try (PreparedStatement statement = connection.prepareStatement(consulta)) {
            statement.setInt(1, idProducto);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Se encontró un producto con el ID especificado
                    int id = resultSet.getInt("id_producto");
                    String nombre = resultSet.getString("nombre_producto");
                    String descripcion = resultSet.getString("descripcion_producto");
                    double costo = resultSet.getDouble("costo_producto");
                    String categoria = resultSet.getString("categoria_producto");
                    int stockActual = resultSet.getInt("stock_producto");
                    String ubicacion = resultSet.getString("ubicacion_producto");

                    // Crear un objeto Producto con los datos obtenidos
                    productoEncontrado = new Producto(Integer.toString(id), nombre, descripcion, costo, categoria, stockActual, ubicacion);
                }
            }
        }

        return productoEncontrado;
    }
    

    // Métodos Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método toString para imprimir la información del producto
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Costo: " + costo + ", Categoría: " + categoria + ", Stock Actual: " + stockActual + ", Ubicación: " + ubicacion;
    }
}
