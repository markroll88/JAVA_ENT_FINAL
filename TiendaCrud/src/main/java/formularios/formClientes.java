package formularios;

import conexion.Clientes;
import dao.DAOClientesImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class formClientes extends javax.swing.JFrame{
    private JPanel panel1;
    private JPasswordField clave;
    private JTextField textUsuario;
    private JTextField textFecha_nacimiento;
    private JTextField textEmail;
    private JTextField textTelefono;
    private JTextField textEdad;
    private JTextField textMascota;
    private JTextField textId;
    private JTextField textApellido;
    private JTextField textAlimento;
    private JTextField textNombre;
    private JRadioButton btnInsert;
    private JTable tblData;
    private JRadioButton btnUpdate;
    private JRadioButton btnDelete;

    String columns[] = {"Id","Nombre","Apellido","Mascota","Edad","Alimento","Fecha Nac","Email","Telefono", "Usuario", "Clave"};
    DefaultTableModel modelo = new DefaultTableModel(columns, 0);
    // DAOClientes dao = new DAOClientes() {
    DAOClientesImpl dao = new DAOClientesImpl() ;
    //  @Override
    //  public boolean insert(Object obj) {
    //      return false;
    //  }

    //   @Override
    //  public boolean delete(Object obj) {
    //      return false;
    //  }

    //   @Override
    //  public boolean upDate(Object obj) {
    //      return false;
    //  }

    //    @Override
    //    public ArrayList<Object[]> consultar() {
    //       return null;
    //     }
    // };
    //lo de ocverride no va segun este modelo de yv
    ArrayList<Object[]>data = new ArrayList<>();
   // public formClientes() {
     //   btnInsert.addMouseListener(new MouseAdapter() {
       //     @Override









    private void createUIComponents() {
        /* TODO: place custom component creation code here */

//public DefaultTableModel(  Object[] columnNames,
 //      int rowCount ){

//       }
 //       Constructs a DefaultTableModel with as many columns as there are elements in columnNames and rowCount of null object values. Each column's name will be taken from the columnNames array.
  ////      Params:
   //     columnNames – array containing the names of the new columns; if this is null then the model has no columns rowCount – the number of rows the table holds

   // public formClientes(){
  //  initComponents();
    cargar();


    }

    private void cargar(){
    this.data = dao.consultar();
    modelo.setNumRows(0);
    for (Object[]dato:this.data) {
        this.modelo.addRow(dato);
    }
        tblData.setModel(modelo);

        }
    private void setBtnInsertMouseClicked(java.awt.event.MouseEvent e) {

        Clientes clie = new Clientes(Integer.parseInt(textId.getText()), textNombre.getText(), textApellido.getText(), textMascota.getText(),
                (Integer.parseInt(textEdad.getText())),textAlimento.getText(),textFecha_nacimiento.getText(), textEmail.getText(),(Integer.parseInt(textTelefono.getText())),
                textUsuario.getText(), clave.getText());

        if (dao.insert(clie)) {
            JOptionPane.showMessageDialog(this, "Se ha insertado con Exito");
        }else {
            JOptionPane.showMessageDialog(this, "Error al Insertar");
        }
        cargar();

    }
    private void tblDataMouseClicked(java.awt.event.MouseEvent event){
        this.textId.setText(tblData.getValueAt(tblData.getSelectedRow(),0).toString());
        this.textNombre.setText(tblData.getValueAt(tblData.getSelectedRow(),1).toString());
        this.textApellido.setText(tblData.getValueAt(tblData.getSelectedRow(),2).toString());
        this.textMascota.setText(tblData.getValueAt(tblData.getSelectedRow(),3).toString());
        this.textEdad.setText(tblData.getValueAt(tblData.getSelectedRow(),4).toString());
        this.textAlimento.setText(tblData.getValueAt(tblData.getSelectedRow(),5).toString());
        this.textFecha_nacimiento.setText(tblData.getValueAt(tblData.getSelectedRow(),6).toString());
        this.textEmail.setText(tblData.getValueAt(tblData.getSelectedRow(),8).toString());
        this.textTelefono.setText(tblData.getValueAt(tblData.getSelectedRow(),7).toString());
        this.textUsuario.setText(tblData.getValueAt(tblData.getSelectedRow(),9).toString());
        this.clave.setText(tblData.getValueAt(tblData.getSelectedRow(),10).toString());
    }

    private void setBtnUpdateMouseClicked(java.awt.event.MouseEvent e) {

        Clientes clie = new Clientes(Integer.parseInt(textId.getText()), textNombre.getText(), textApellido.getText(), textMascota.getText(),
                (Integer.parseInt(textEdad.getText())),textAlimento.getText(),textFecha_nacimiento.getText(), textEmail.getText(),(Integer.parseInt(textTelefono.getText())),
                textUsuario.getText(), clave.getText());

        if (dao.upDate(clie)) {
            JOptionPane.showMessageDialog(this, "Se ha modificado con Exitoso");
        }else {
            JOptionPane.showMessageDialog(this, "Error al Modificar");
        }
        cargar();

    }
    private void setBtnDeleteMouseClicked(java.awt.event.MouseEvent e) {

        Clientes clie = new Clientes(Integer.parseInt(textId.getText()), textNombre.getText(), textApellido.getText(), textMascota.getText(),
                (Integer.parseInt(textEdad.getText())),textAlimento.getText(),textFecha_nacimiento.getText(), textEmail.getText(),(Integer.parseInt(textTelefono.getText())),
                textUsuario.getText(), clave.getText());


        if (dao.delete(clie)) {
            JOptionPane.showMessageDialog(this, "Se ha borrado con Exito");
        }else {
            JOptionPane.showMessageDialog(this, "Error al Borrar");
        }
        cargar();

    }

}

