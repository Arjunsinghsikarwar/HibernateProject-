public class Cache {
    public static void main(String[] args) {
        System.out.println("This class demonstrates caching in Hibernate.");

        // We use caching so that if a query is executed once, its result is stored in memory.
        // This reduces the load on the database by retrieving the result from the cache instead of executing the query again.
        // With the help of caching, response time is reduced and the database experiences less load.

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Side.class);  // Specify the entity class here.
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Level 1 cache is enabled by default.
        Side student = session.get(Side.class, 12);
        Side student1 = session.get(Side.class, 12);  // Even though we fetch the object twice, the query will execute only once due to caching.

        System.out.println(student1);
        System.out.println(student);  // Level 1 cache is session-specific.

        session.close();

        // If we change the session, the query will execute again.
        Session session1 = sessionFactory.openSession();

        // Remember: Even after adding Ehcache dependencies in pom.xml,
        // we must also configure caching properties in the hibernate.cfg.xml file.
        // Ehcache won't work just by adding the dependency. As a final step,
        // we need to add the @Cacheable annotation to the entity class that we want to cache.

        Side student2 = session1.get(Side.class, 12);
        System.out.println(student2);  // Although the data was cached, the query is executed again because we used a new session.
        session1.close();              // To fix this, we use Level 2 caching with Ehcache.
                                       // (Make sure to use a compatible version of Ehcache with Hibernate.)

    }
} // After enabling Level 2 cache, the query will only execute once even if the session changes.

