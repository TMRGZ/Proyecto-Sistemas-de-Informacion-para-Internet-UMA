package Entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROYECTO_BENEFICIARIO", schema = "ACOES", catalog = "")
@IdClass(ProyectoBeneficiarioEntityPK.class)
public class ProyectoBeneficiarioEntity {
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
        ProyectoBeneficiarioEntity that = (ProyectoBeneficiarioEntity) o;
        return proyectoCodigo == that.proyectoCodigo &&
                Objects.equals(beneficiarioCodigo, that.beneficiarioCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyectoCodigo, beneficiarioCodigo);
    }
}
