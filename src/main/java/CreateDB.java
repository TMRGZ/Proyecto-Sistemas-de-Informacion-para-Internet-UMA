import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateDB {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOES");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        //entityTransaction.begin();


        /*try {
            Socio socio = new Socio();
            socio.setNumero(2);
            socio.setNombre("Pepa");
            socio.setNif("44444444X");
            socio.setDireccion("Casa");
            socio.setPoblacion("Casa");
            socio.setProvincia("Casa");
            socio.setCodigoPostal(222222);
            socio.setTelefono(666666666);
            socio.setCorreoElectronico("Pepa@jaja.es");

            em.persist(socio);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            System.out.println("Fila ya existe");
        }*/


        /*List<Socio> list = em.createQuery("select a from Socio a", Socio.class).getResultList();

        for (Socio socio : list) {
            System.out.println(socio);
        }*/


        em.close();
        emf.close();
    }
}
