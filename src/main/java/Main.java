import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class Main {
    public static void main(String[] args) {
        Side student = new Side();
        // After seeing the output of this, try to realize why we override the toString() method.

        student.setName("Munish");
        student.setEducation("B.tech");
        student.setRool_Number(69);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);
        // by 'new Configuration' we new Hibernate Configuration Object , configure() is used to read the hibernate.cfg.xml means know DB url , username,password.
        // Specify the entity class where we want to save the data.

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // sessionfactory ek heavy object , by creating it once we can create multiple sessions.
        Session session = sessionFactory.openSession();
        // session is light object , you create session object open once , do one DB operations or work ,  then close it .

        Transaction transaction = session.beginTransaction();  
        // To make permanent changes in the database, we need a transaction.
        // DB operation should be done in the transaction so if somethingh went wrong we can rollback.
        Side existing = session.get(Side.class,69);
            if(existing == null) session.save(student);
        else 
            System.out.println("Record with ID already exist");

         //session.save(student); if ww didnt used the if and else above then we used this 
        transaction.commit();  
        // Changes are successfully committed here.

        // It's good practice to use try-catch around session.save(student) 
        // because the transaction has a rollback() method to undo changes if an exception occurs.

        System.out.println(student);

        // <property name="hibernate.hbm2ddl.auto">update</property>
        // This property automatically creates or updates the table schema.
        // We use "update" so it updates the existing table or creates a new one if it doesn't exist.
    }
}
