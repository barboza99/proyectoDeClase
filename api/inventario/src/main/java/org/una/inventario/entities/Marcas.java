package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "marcas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Marcas  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_marca", length = 100)
    private String nombre;

    @Column
    private boolean estado;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcas")
    private List<Activo> activos = new ArrayList<>();
}
