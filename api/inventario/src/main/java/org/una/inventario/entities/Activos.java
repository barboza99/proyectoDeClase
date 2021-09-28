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

public class Activos implements Serializable {
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
    private List<Activos> activos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<Alertas> alertas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<ContratoGarantia> contratosGarantias = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<ActivosAsignados> activosAsignados = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activos")
    private List<Valuacion> valuaciones = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marcas_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "proveedores_id")
    private Proveedor proveedor;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

}
