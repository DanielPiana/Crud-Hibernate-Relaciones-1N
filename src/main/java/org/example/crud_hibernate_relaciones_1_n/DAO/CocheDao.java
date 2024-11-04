package org.example.crud_hibernate_relaciones_1_n.DAO;

import javafx.collections.ObservableList;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;
import org.hibernate.Session;

public interface CocheDao {
    void insertarCoche(Coche coche, Session session);

    void eliminarCoche(int id, Session session);

    void modificarCoche(int id,Coche coche, Session session);

    ObservableList<Coche> listar(Session session);

    boolean existe(String matricula,Session session);
}
