/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    
    public JLabel lblCodigo, lblMarca, lblStock,lblExistencia;
    
    public JTextField codigo,descripcion,stock;
    public JComboBox marca;
    
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    
    private static final int ANCHOC = 130,ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta()
    {
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblCodigo); 
        container.add(lblMarca);
        container.add(lblStock);
        container.add(lblExistencia);
        container.add(codigo);
        container.add(marca);
        container.add(stock);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600, 600);
        eventos();
    }
    public final void formulario()
    {
        //elementos
        codigo = new JTextField();
        marca = new JComboBox();
        stock = new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        
        table = new JPanel();
        //agregar elementos al combobox marca
        marca.addItem("FRAM");
        marca.addItem("WIX");
        marca.addItem("Luber Finer");
        marca.addItem("OSK");
        //Agregando los radios a un grupo
        existencia = new ButtonGroup();
        existencia.add(si);
        existencia.add(no);
        //////////////////////////////////////////////
        codigo.setBounds(140, 10,ANCHOC,ALTOC);
        marca.setBounds(140,60,ANCHOC,ALTOC);
        stock.setBounds(140,100,ANCHOC,ALTOC);
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        
        buscar.setBounds(300,10,ANCHOC,ALTOC);
        insertar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        eliminar.setBounds(300,210,ANCHOC,ALTOC);
        limpiar.setBounds(450,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,500,200);
        table.add(new JScrollPane(resultados));
        
    }
    public void llenarTabla()
    {
        //Aca le colocamos el tipo de dato que tendra nuestras columnas
        //si es un dato booleano aparecera un checkbox en el JTABLE
        tm = new DefaultTableModel(){
          public Class<?> getColumnClass(int column){
              switch(column)
              {
                  case 0:
                      return String.class;
                  case 1:
                      return String.class;
                  case 2:
                      return String.class;
                  default:
                      return Boolean.class;
              }
          }  
        };
        //Agregamos las columnas que se mostraran con su respectivo nombre
        tm.addColumn("Codigo");
        tm.addColumn("Marca");
        tm.addColumn("Stock");
        tm.addColumn("Stock en Sucursal");
        ///Realizaremos la consulta a nuestra base de datos por medio del metodo
        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readAll();
        
        //Agregamos el resultado a nuestro JTable
        //Se agregan de tipo Object
        for(Filtro fi: filtros)
        {
            tm.addRow(new Object[]{fi.getCodigo(),fi.getMarca(),fi.getStock(),fi.getExistencia()});
            
        }
        //le agregamos el modelo a nuestra tabla
        resultados.setModel(tm);
    }
    public void eventos()
    {
        //insertar
        insertar.addActionListener(new ActionListener(){
            
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
