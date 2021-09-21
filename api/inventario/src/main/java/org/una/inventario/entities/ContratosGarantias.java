package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contratosGarantias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContratosGarantias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activo activos;

    @Column(name = "monto_asegurado")
    private double montoAsegurado;

    @Column(name = "costo")
    private double costo;

    @Column
    private boolean estado;

    @Column(name = "fecha_vencimiento", length = 50)
    private String fechaVencimiento;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaModificacion;


}
