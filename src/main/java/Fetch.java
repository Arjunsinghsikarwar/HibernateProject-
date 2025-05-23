import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch
{
    public static void main(String[] args) {
        System.out.println("In this we fetch the data"); //By using hibernate.
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);  // here we put the class name in which entity class is.
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        // Here we don't need to use the transaction , since it only uses to make the changes and update in the table.

        // Remeber this , we have to method in session to fetch the data from the data base
        // 1. get() -->  in this case if we get() the the query got executed  even if we used or not.
        //2. load(). --> in this case if use the lod() the query only executed when only it got used.

       Side student =  session.get(Side.class,12);

        System.out.println(student);

        session.close();  // just for the good prartice.

        // Side student = session.load(Side,class,102);
        // this query will only exectue when it is used to get somethingh.

    }
}
