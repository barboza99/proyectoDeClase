package org.una.inventario.entities;

import lombok.*;
import org.hibernate.criterion.NotNullExpression;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "parametros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Parametros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String valor;

    @Column(length = 100)
    private String nombre;

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

}
