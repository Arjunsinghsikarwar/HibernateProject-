import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Cache {
    public static void main(String[] args) {
        System.out.println("In this class see about caching Hibernate");
        // We use cache taki jo query execute wo agr ek baar ho rhe hain toh wo cache jo ke memory store hain , uss me usska result save ho jaaye and jiske databse pr query ke jaada laod na ho.
        // With help of the cache reponse time kaam hoota hain and load database pr kaam ho jaata hain.

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);  // here we put the class name in which entity class is.
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Level1 cache by default hoota hain.
        Side student = session.get(Side.class,12);
        Side student1 = session.get(Side.class,12);  // By making the 2 object , the query would execute only for 1 time pnly even i we get two result print .

        System.out.println(student1);
        System.out.println(student);    // cache seesion specific hoota  hain.

        session.close();

        //But if change the Session the query would execute 2 times then.
        Session session1 = sessionFactory.openSession();

        // Remeber that , if even i after ehcache dependecies in pom.xml we have add some properties to make that work in the hibernate.cfg.xml file .
        // Even after setup of the ehcaceh file , it will not work , to mae that we have the final step which add the @Cacheable notation on the class jishe humhe cache krna hain ke nahi.



        Side student2 = session1.get(Side.class,12);
        System.out.println(student2);  // Since we have alreay that this in cache , but due change in session we the query will get execute and then we will gwt result.
        session1.close();              // to resolve this use , we the Level2 cache by using the ehcache . (Remeber that we have use the same version of ehcache as hibernate).


    }
} // After this even after session getting changed the query only get executed by only once.

