package conexion;

import java.util.ArrayList;

//analizar el codigo
public abstract class Operaciones {

    public abstract boolean insert(Object obj);

    public abstract boolean delete(Object obj);
    public abstract boolean upDate(Object obj);
    public abstract boolean create(Object obj);
    public abstract ArrayList<Object[]> select();


}
