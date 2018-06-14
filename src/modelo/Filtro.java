/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String codigo;
    private String marca;
    private int stock;
    private boolean existencia;
    
    public Filtro(){
        
    }
    public Filtro(int id, String codigo, String marca, int stock, boolean existencia){
        this.id = id;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }
    public Filtro(String codigo,String marca,int stock,boolean existencia){
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }
    public Filtro(String marca,int stock,boolean existencia){
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }
    public boolean getMarca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean getExistencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean getStock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
 
    public boolean getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
