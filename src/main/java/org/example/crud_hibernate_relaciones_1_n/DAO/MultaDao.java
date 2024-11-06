package org.example.crud_hibernate_relaciones_1_n.DAO;

import javafx.collections.ObservableList;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;
import org.example.crud_hibernate_relaciones_1_n.domain.Multa;
import org.hibernate.Session;

public interface MultaDao {

    void insertarMulta();

    void eliminarMulta();

    void modificarMulta();

    ObservableList<Multa> listarMultasCoche(Coche coche, Session session);

    boolean existe();
}
