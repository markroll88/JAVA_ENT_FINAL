package dao;

import conexion.Operations;

import java.sql.*;

import java.util.ArrayList;
import conexion.*;

import javax.swing.*;

public class DAOClientesImpl implements Operations {
    Database db = new Database();
    Clientes clie = new Clientes();
    CreateTabla table = new CreateTabla();

    @Override
    public boolean insert(Object obj) {
        //casting
        //return false;
        clie = (Clientes) obj;
        //  Connection connection;
        PreparedStatement pstmt;
        String sql = "insert into clientes values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {
            Connection connection;
            //Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getUrl(), db.getUser(), db.getPwd());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, clie.getId());
            pstmt.setString(2, clie.getNombre());
            pstmt.setString(3, clie.getApellido());
            pstmt.setString(4, clie.getMascota());
            pstmt.setInt(5, clie.getEdad());
            pstmt.setString(7, clie.getAlimento());
            pstmt.setDate(6, clie.getFecha_nacimiento());
            pstmt.setString(8, clie.getEmail());
            pstmt.setInt(9, clie.getTelefono());
            pstmt.setString(10, clie.getUsuario());
            pstmt.setString(11, clie.getClave());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

            //******** CREACION DE LA DECLARACION SQL PARA INSERTAR DATOS EN LA TABLA ******
            //  String sqlInsert = "INSERT INTO personas (id, nombre, apellido, mascota, email, clave, fecha_nacimiento)"
            //        + "VALUES (?,?,?,?,?,?,?)";

            //CREACION DE UN OBJETO PreparedStatement a partir de la declaracion SQl
            //  PreparedStatement stmtInsert = connection.prepareStatement(sqlInsert);

            //Establecer los valores de ñps árametros de la declaracion SQL

            // stmtInsert.setInt(1, 1);
            // stmtInsert.setString(2, "KUKI");
            // stmtInsert.setString(3, "Perez");
            // stmtInsert.setString(4, "Chichus");
            // stmtInsert.setString(5, "juaco234@hotmail.com");
            //  stmtInsert.setString(6, "cgijuaco483");
            // stmtInsert.setDate(7, Date.valueOf("1970-02-13"));
            // stmtInsert.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente" + e.getMessage());
            return false;
            //catch (SQLException / ClassssNotFoundException e)
        }

    }

    @Override
    public boolean delete(Object obj) {
        //casting
        //return false;
        clie = (Clientes) obj;
        //  Connection connection;
        PreparedStatement pstmt;
        String sql = "delete from clientes WHERE id = ?";

        try {
            Connection connection;
            //Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getUrl(), db.getUser(), db.getPwd());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, clie.getId());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente" + e.getMessage());
            return false;
            //catch (SQLException / ClassssNotFoundException e)
        }

    }


    @Override
    public boolean upDate(Object obj) {
        //casting
        //return false;
        clie = (Clientes) obj;
        //  Connection connection;
        PreparedStatement pstmt;
        String sql = "update clientes set nombre=?, apellido=?, mascota=?, edad=?,alimento=?, fecha_nacimiento=?, email=?,telefono= ?, usuario= ?, clave=? WHERE id= ?)";

        try {
            Connection connection;
            //Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getUrl(), db.getUser(), db.getPwd());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, clie.getNombre());
            pstmt.setString(2, clie.getApellido());
            pstmt.setString(3, clie.getMascota());
            pstmt.setInt(4, clie.getEdad());
            pstmt.setString(6, clie.getAlimento());
            pstmt.setDate(5, clie.getFecha_nacimiento());
            pstmt.setString(7, clie.getEmail());
            pstmt.setInt(8, clie.getTelefono());
            pstmt.setString(9, clie.getUsuario());
            pstmt.setString(10, clie.getClave());
            pstmt.setInt(11, clie.getId());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente" + e.getMessage());
            return false;
            //catch (SQLException / ClassssNotFoundException e)
        }

    }


    @Override
    public ArrayList<Object[]> consultar() {
        ArrayList<Object[]>data = new ArrayList<>();
        //Connection connection;
        PreparedStatement psmt;
        ResultSet rs;
        String sql ="select * from clientes";

        try {
            //conexion a la base de datos
            Connection connection;
            //Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getUrl(), db.getUser(), db.getPwd());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            //recprremos el ResultSet y se crea nvosregistros para la variable data q es un arraylist
            while(rs.next()){
                Object[] fila = new Object[10];
                        for (int i=0; i<=10; i ++){
                            fila[i]=rs.getObject(i+1);
                        }
                        data.add(fila);
            }
                connection.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente" + e.getMessage());

            //catch (SQLException / ClassssNotFoundException e)
        }finally {
            return data;
        }


    }
}