/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MóduloInventarioProducto;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class HistorialCambios {
    private ArrayList<String[]> cambios;
    private Date fecha;

    public HistorialCambios() {
        this.cambios = new ArrayList<>();
        this.fecha = new Date();
    }

     public void agregarCambio(String[] cambio) {
        // Crear una nueva instancia de Date para capturar la hora actual
        Date fecha = new Date();
        // Convertir la fecha a un formato legible
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Obtener la fecha formateada como un String
        String fechaFormateada = formato.format(fecha);
        
        // Agregar la fecha al cambio
        String[] cambioConFecha = new String[cambio.length + 1];
        System.arraycopy(cambio, 0, cambioConFecha, 0, cambio.length);
        cambioConFecha[cambio.length] = fechaFormateada;

        cambios.add(cambioConFecha);
    }

    public ArrayList<String[]> getCambios() {
        return cambios;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String[] cambio : cambios) {
            builder.append("Fecha: ").append(cambio[cambio.length - 1]).append(", Producto: ");
            for (int i = 0; i < cambio.length - 1; i++) {
                builder.append(cambio[i]);
                if (i < cambio.length - 2) {
                    builder.append(", ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
