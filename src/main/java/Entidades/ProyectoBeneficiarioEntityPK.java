package Entidades;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProyectoBeneficiarioEntityPK implements Serializable {
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
        ProyectoBeneficiarioEntityPK that = (ProyectoBeneficiarioEntityPK) o;
        return proyectoCodigo == that.proyectoCodigo &&
                Objects.equals(beneficiarioCodigo, that.beneficiarioCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyectoCodigo, beneficiarioCodigo);
    }
}
