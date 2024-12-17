/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.time.LocalDateTime;

/**
 *
 * @author luisfallas006
 */
public class Acceso {
    private QuickPass qp;
    private LocalDateTime fechaActual;

    public Acceso(QuickPass qp) {
        this.qp = qp;
        fechaActual = LocalDateTime.now();
    }

    public QuickPass getQp() {
        return qp;
    }

    public void setQp(QuickPass qp) {
        this.qp = qp;
    }

    public LocalDateTime getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDateTime fechaActual) {
        this.fechaActual = fechaActual;
    }

    @Override
    public String toString() {
        return "Acceso{" + "qp=" + qp + ", fechaActual=" + fechaActual + '}';
    }
}
