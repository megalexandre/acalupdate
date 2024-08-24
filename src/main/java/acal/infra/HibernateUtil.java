package acal.infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Configuração do Hibernate
            Configuration configuration = new Configuration();
            configuration.configure(); // Carrega o arquivo hibernate.cfg.xml

            // Cria o ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // Cria o MetadataSources e Metadata
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            Metadata metadata = metadataSources.getMetadataBuilder().build();

            // Cria o SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            // Log e rethrow
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Connection getConnection() {
        Session session = null;
        Connection connection = null;

        try {
            session = sessionFactory.openSession();
            connection = ((SessionImplementor) session).getJdbcConnectionAccess().obtainConnection();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return connection;
    }
}
