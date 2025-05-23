import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class Main
{
    public static void main(String[] args)
    {
        Side student = new Side();
      //  System.out.println(side);  after seeign the result of this , try to reliaze why we Overiide the toString() method.

        student.setName("Munish");
        student.setEducation("B.tech");
        student.setRool_Number(69);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class); // the class jiska humhe data save krna hain.
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();  // To make the permentat changes we need this .
        session.save(student);
        transaction.commit(); // here changes have succesfully

        // hum session.save(student); ko try and catch likhte hain , b/c transaction have the method rollback ke agr Exception aayge toh chize roolback ho jaaye.

        System.out.println(student);


//         <property name="hibernate.hbm2ddl.auto">update</property>
        // this proeprty is used to make a table by itself , name we make the updated because it will the update the and table , and if the tbale do not had created previously then it will make onece.

    }
}