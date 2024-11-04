package org.example.crud_hibernate_relaciones_1_n.domain;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Multas")
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_multa;

    @Column(name="matricula")
    private String matricula;

    @Column(name="precio")
    private double precio;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id")
    private Coche coche;



    public Multa(int id_multa, String matricula, double precio, LocalDate fecha, Coche coche) {
        this.id_multa = id_multa;
        this.matricula = matricula;
        this.precio = precio;
        this.fecha = fecha;
        this.coche = coche;
    }

    public Multa(LocalDate fecha, double precio, String matricula, int id_multa) {
        this.fecha = fecha;
        this.precio = precio;
        this.matricula = matricula;
        this.id_multa = id_multa;
    }

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Multa{" +
                "id_multa=" + id_multa +
                ", matricula='" + matricula + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                ", coche=" + coche +
                '}';
    }
}