package conexion;

import java.util.ArrayList;

public interface Operations {


    //analizar el codigo

        public  boolean insert(Object obj);

        public  boolean delete(Object obj);
        public  boolean upDate(Object obj);
        public abstract ArrayList<Object[]> consultar();


    }


