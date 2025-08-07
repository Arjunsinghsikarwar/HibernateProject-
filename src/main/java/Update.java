import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Update {
    public static void main(String[]args){
        System.out.println("This class is for the updation");
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Side side = session.get(Side.class,69);

        if(side!=null){
            side.setEducation("M.tech");
            side.setName("Arjun Singh SIkarwar");
            side.setRool_Number(2345332);
        }
        else System.out.println("Student is not Found");

        Transaction transaction = session.beginTransaction();
        transaction.commit();;
        session.close();
    }
}
