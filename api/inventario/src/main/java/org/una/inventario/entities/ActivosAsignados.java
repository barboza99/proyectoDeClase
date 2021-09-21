package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activosAsignados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ActivosAsignados implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "justificacion", length = 150)
   private String justificacion;

    @Column
   private boolean estado;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
   private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activo activos;

}
