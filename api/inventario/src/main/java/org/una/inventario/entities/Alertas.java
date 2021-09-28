package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "alertas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Alertas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activos activos;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column
    private Long responsable;
}
