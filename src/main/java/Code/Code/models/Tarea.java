package Code.Code.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(name = "fecha_incio")
    private Date fechainicio;

    @Column(name = "fecha_fin")
    private Date fechafin;

    private String notas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "colaborador_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prioridad_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Prioridad prioridad;


    public Tarea() {
    }

    public Tarea(Long id, String descripcion, Date fechainicio, Date fechafin, String notas, Colaborador colaborador, Estado estado, Prioridad prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.notas = notas;
        this.colaborador = colaborador;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean hasData(){
        if( !this.descripcion.equalsIgnoreCase("")
                && this.fechainicio != null && this.fechafin != null
                && !this.notas.equalsIgnoreCase("")
                && this.estado != null
                && this.estado.getId() != null
                && this.estado.getNombre() != null
                && !this.estado.getId().equals(0)
                && this.prioridad != null
                && this.prioridad.getId() != null
                && this.prioridad.getNombre() != null
                && !this.getPrioridad().getId().equals(0)){
            return true;
        }
        return false;
    }

}
