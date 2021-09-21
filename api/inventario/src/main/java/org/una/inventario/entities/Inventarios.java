package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Inventarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long responsable;

    @Column(length = 100)
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarios")
    private List<Valuaciones> valuaciones = new ArrayList<>();

}
