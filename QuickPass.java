/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author luisfallas006
 */
public class QuickPass {

    String Filial;
    private String Placa,Codigo;
    
    public QuickPass(String Filial, String Placa, String Codigo) {
        this.Filial = Filial;
        this.Codigo = Codigo;
        this.Placa = Placa;
    }
    
        public String getFilial() {
        return Filial;
    }

    public void setFilial(String Filial) {
        this.Filial = Filial;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    @Override
    public String toString() {
        return "QuickPass{" + "Filial=" + Filial + ", Placa=" + Placa + ",Codigo=" + Codigo + '}';
    }
}

