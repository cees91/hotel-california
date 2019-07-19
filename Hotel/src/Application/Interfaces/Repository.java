package Application.Interfaces;

import java.util.List;

public interface Repository <T>  {

    void create(T item);

    void update(int item) throws Exception;

    void remove(int item) throws Exception;

    //List<T> query(T specification);

}



