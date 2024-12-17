/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author luisfallas006
 */
public class GestionAccesos {
    private Acceso[] listaAccesos;
    private int capacidad;
    private int cantidad;

    public GestionAccesos(int tamanno) {
        this.listaAccesos = new Acceso[tamanno];
        this.capacidad = tamanno;
        this.cantidad = 0;
    }

    // Registrar un nuevo acceso
    public void registrarAcceso(QuickPass qp) {
        if (cantidad < capacidad) {
            LocalDateTime fechaActual = LocalDateTime.now();
            Acceso nuevoAcceso = new Acceso(qp);
            nuevoAcceso.setFechaActual(fechaActual);

            listaAccesos[cantidad] = nuevoAcceso;
            cantidad++;

            JOptionPane.showMessageDialog(null, "Codigo: " + qp.getCodigo() + "; Placa: " + qp.getPlaca() + "; Filial: " + qp.getFilial() +
                     "; Fecha: " + fechaActual);
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para registrar más accesos");
        }
    }

    // Consultar histórico por filial
    public void consultarPorFilial(String filial) {
        boolean encontrado = false;
        StringBuilder resultados = new StringBuilder("Accesos para la filial: " + filial + "\n");

        for (int i = 0; i < cantidad; i++) {
            if (listaAccesos[i].getQp().getFilial().equalsIgnoreCase(filial)) {
                resultados.append(listaAccesos[i]).append("\n");
                encontrado = true;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, resultados.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron accesos para la filial: " + filial);
        }
    }

    // Consultar histórico por rango de fechas
    public void consultarPorRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        boolean encontrado = false;
        StringBuilder resultados = new StringBuilder("Accesos entre " + fechaInicio + " y " + fechaFin + "\n");

        for (int i = 0; i < cantidad; i++) {
            if (!listaAccesos[i].getFechaActual().isBefore(fechaInicio) && !listaAccesos[i].getFechaActual().isAfter(fechaFin)) {
                resultados.append(listaAccesos[i]).append("\n");
                encontrado = true;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, resultados.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron accesos en el rango especificado");
        }
    }

    // Consultar histórico por código o placa
    public void consultarPorCodigoOPlaca(String codigoOPlaca) {
        boolean encontrado = false;
        StringBuilder resultados = new StringBuilder("Accesos para el código o placa: " + codigoOPlaca + "\n");

        for (int i = 0; i < cantidad; i++) {
            if (listaAccesos[i].getQp().getCodigo().equalsIgnoreCase(codigoOPlaca) ||
                listaAccesos[i].getQp().getPlaca().equalsIgnoreCase(codigoOPlaca)) {
                resultados.append(listaAccesos[i]).append("\n");
                encontrado = true;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, resultados.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron accesos para el código o placa: " + codigoOPlaca);
        }
    }

    @Override
    public String toString() {
        StringBuilder resultados = new StringBuilder("Listado de todos los accesos:\n");

        for (int i = 0; i < cantidad; i++) {
            resultados.append(listaAccesos[i]).append("\n");
        }

        return resultados.toString();
    }
}


