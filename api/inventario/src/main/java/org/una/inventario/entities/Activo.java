package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "activos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Activo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "continente", length = 100)
    private Long continente;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<Activo> activos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<Alertas> alertas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<ContratosGarantias> contratosGarantias = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<ActivosAsignados> activosAsignados = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<Valuaciones> valuaciones = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categorias categorias;

    @ManyToOne
    @JoinColumn(name = "marcas_id")
    private Marcas marcas;

    @ManyToOne
    @JoinColumn(name = "proveedores_id")
    private Proveedores proveedores;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

}
