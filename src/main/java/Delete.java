import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        System.out.println("This for the Deletion");
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Side side = session.get(Side.class,69);
        if(side!=null){
            session.remove(side);
            System.out.println("The student remove succesfully");
        }
        else System.out.println("This student is not found");

        transaction.commit();
        session.close();
    }
}
