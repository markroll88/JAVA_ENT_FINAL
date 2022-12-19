package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTabla {

        Connection conection;
        private String url;
        private String DB;
        private String user;
        private String pwd;




           public void establecerConexion()  {
//throws SQLException puede ser por errores de olvido de llaves, no es conveniente porque no soluciona nadathrows SQLException


               try {
                   Connection  connection = DriverManager.getConnection(url + DB, user, pwd);
                    System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
                    //CREANDO LA DECLARACION SQL PRA CREAR LA TABLA
                            String sql = "CREATE TABLE clientes ("
                                    + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                                    + "nombre VARCHAR(20),"
                                    + "apellido VARCHAR(20),"
                                    + "mascota VARCHAR(20),"
                                    + "edad INT(3),"
                                    + "alimento VARCHAR(30),"
                                    + "fecha_nacimiento DATE,"
                                    + "email VARCHAR(30),"
                                    + "telefono VARCHAR(10),"
                                    + "usuario VARCHAR(20),"
                                    + "clave VARCHAR(20)";

                    //CREAR UN OBJETO PreparedDStatement a partir de la declaracion SQL Siempre PreparedStatement porque disminuye inyecciones maliciosas sql
                      PreparedStatement stmt = connection.prepareStatement(sql);
                    //EJECUTAR LA DECLARACION SQL PARA CREAR LA TABLA

                             stmt.executeUpdate();

                    //CERRAR EL OBJETO PreparedStatement y la conexion con la DB

                             stmt.close();
                             connection.close();
                             System.out.println("CONEXION CERRADA");


                } catch (SQLException e) {
                    System.out.println("ERROR EN LA CONEXION");
            }
        }


    }


