package co.edu.uco.aurora.data.dao;

import java.util.List;

public interface RetrieveDAO <E, ID> {

    List <E> findALL ();

    List <E> findByFilter (E filterEntity);

    E findById (ID id);
}
