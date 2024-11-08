package org.example.crud_hibernate_relaciones_1_n.DAO;

import javafx.collections.ObservableList;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;
import org.example.crud_hibernate_relaciones_1_n.domain.Multa;
import org.hibernate.Session;

public interface MultaDao {

    void insertarMulta(Multa multa, Session session);

    void eliminarMulta(Multa multa, Session session);

    void modificarMulta();

    ObservableList<Multa> listarMultasCoche(String matricula, Session session);

    boolean existe();
}
