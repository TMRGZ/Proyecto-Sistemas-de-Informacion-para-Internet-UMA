import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {
    public static void test(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOES");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
