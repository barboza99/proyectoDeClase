package org.una.inventario.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "valuaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Valuaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activo activos;

    @ManyToOne
    @JoinColumn(name = "inventarios_id")
    private Inventarios inventarios;

    @Column(name = "precio_valuacion")
    private double precioValuacion;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

}
