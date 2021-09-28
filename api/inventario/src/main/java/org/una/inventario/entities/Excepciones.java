package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "excepciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Excepciones  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    @Column(length = 250)
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

}
