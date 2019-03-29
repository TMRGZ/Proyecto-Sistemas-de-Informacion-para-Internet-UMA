package Entidades;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProyectoBeneficiarioPK implements Serializable {
    private long proyectoCodigo;
    private String beneficiarioCodigo;

    @Column(name = "PROYECTO_CODIGO")
    @Id
    public long getProyectoCodigo() {
        return proyectoCodigo;
    }

    public void setProyectoCodigo(long proyectoCodigo) {
        this.proyectoCodigo = proyectoCodigo;
    }

    @Column(name = "BENEFICIARIO_CODIGO")
    @Id
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

        ProyectoBeneficiarioPK that = (ProyectoBeneficiarioPK) o;

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
        return "ProyectoBeneficiarioPK{" +
                "proyectoCodigo=" + proyectoCodigo +
                ", beneficiarioCodigo='" + beneficiarioCodigo + '\'' +
                '}';
    }
}
