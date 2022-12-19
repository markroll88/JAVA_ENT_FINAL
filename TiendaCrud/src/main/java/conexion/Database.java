package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//clase para efectuar la cponexion de la base de datos sql y este programa
public class Database {
    Connection conection;
   private final String url= "jdbc:mysql://localhost:3306/" ;
   private final String base= "tienda_crud";
   private final String user= "root";
   private final String pwd= "";
  // private final String driver ="";


   // public Database() {
    //   this.url = "jdbc:mysql://localhost:3306/";
    //    this.DB = "tienda_crud";
    //   this.user = "root";
   //     this.pwd = "";






// utilizo jdbc conectando a esta direccion xamp levantara  de este host ntra bd
// Por defecto es este host-puerto, hay q especificar, De haber otra configuracion para pwd y user, colocarla




            public void establecerConexion()  {
//throws SQLException puede permitir errores de olvido de llaves, no es conveniente porque no soluciona nadathrows SQLException


                try {
                    Connection  connection = DriverManager.getConnection(url+base+user+pwd) ;
                    System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");

                    connection.close();
                    System.out.println("CONEXION CERRADA");


                } catch (SQLException e) {
                    System.out.println("ERROR EN LA CONEXION");
                    // throw new RuntimeException(e);
                }



        }


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}

