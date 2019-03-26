package Entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USUARIO", schema = "ACOES", catalog = "")
public class UsuarioEntity {
    private long idUsuario;
    private String nombreUsuario;
    private String contrasena;

    @Id
    @Column(name = "ID_USUARIO")
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "NOMBRE_USUARIO")
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Basic
    @Column(name = "CONTRASENA")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario &&
                Objects.equals(nombreUsuario, that.nombreUsuario) &&
                Objects.equals(contrasena, that.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreUsuario, contrasena);
    }
}
