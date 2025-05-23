import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {
        System.out.println("In this example, we fetch data using Hibernate.");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);  
        // Here we specify the entity class.

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // We don't need to use a transaction here since we're only fetching data, not making any changes or updates to the table.

        // Remember this: there are two methods in the Session interface to fetch data from the database:
        // 1. get()  --> This method immediately executes the query, even if the retrieved object is not used.
        // 2. load() --> This method executes the query only when the object is accessed (lazy loading).

        Side student = session.get(Side.class, 12); // The query executes immediately.

        System.out.println(student);

        session.close();  // Closing the session is good practice.

        // Side student = session.load(Side.class, 102);
        // This query will only execute when the object is accessed (e.g., via a getter).
    }
}
