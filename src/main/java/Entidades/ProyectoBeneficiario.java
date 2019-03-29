package Entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROYECTO_BENEFICIARIO", schema = "ACOES")
@IdClass(ProyectoBeneficiarioPK.class)
public class ProyectoBeneficiario {
    private long proyectoCodigo;
    private String beneficiarioCodigo;

    @Id
    @Column(name = "PROYECTO_CODIGO")
    public long getProyectoCodigo() {
        return proyectoCodigo;
    }

    public void setProyectoCodigo(long proyectoCodigo) {
        this.proyectoCodigo = proyectoCodigo;
    }

    @Id
    @Column(name = "BENEFICIARIO_CODIGO")
    public String getBeneficiarioCodigo() {
        return beneficiarioCodigo;
    }

    public void setBeneficiarioCodigo(String beneficiarioCodigo) {
        this.beneficiarioCodigo = beneficiarioCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProyectoBeneficiario that = (ProyectoBeneficiario) o;

        if (proyectoCodigo != that.proyectoCodigo) return false;
        return Objects.equals(beneficiarioCodigo, that.beneficiarioCodigo);

    }

    @Override
    public int hashCode() {
        int result = (int) (proyectoCodigo ^ (proyectoCodigo >>> 32));
        result = 31 * result + (beneficiarioCodigo != null ? beneficiarioCodigo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProyectoBeneficiario{" +
                "proyectoCodigo=" + proyectoCodigo +
                ", beneficiarioCodigo='" + beneficiarioCodigo + '\'' +
                '}';
    }
}
