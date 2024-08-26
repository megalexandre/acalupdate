package acal.infra;

import acal.resource.model.AddressModel;
import acal.resource.model.CustomerModel;
import acal.resource.model.InvoiceModel;
import acal.resource.model.LinkModel;
import acal.resource.model.PartnerModel;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.internal.SessionImpl;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private HibernateUtil(){}
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = getConfiguration();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(acal.entidades.CaixaView.class);
            metadataSources.addAnnotatedClass(acal.entidades.Categoriasocio.class);
            metadataSources.addAnnotatedClass(acal.entidades.Cheque.class);
            metadataSources.addAnnotatedClass(acal.entidades.Chequeslog.class);
            metadataSources.addAnnotatedClass(acal.entidades.Conta.class);
            metadataSources.addAnnotatedClass(acal.entidades.Contaslog.class);
            metadataSources.addAnnotatedClass(acal.entidades.ContasView.class);
            metadataSources.addAnnotatedClass(acal.entidades.Contrato.class);
            metadataSources.addAnnotatedClass(acal.entidades.Endereco.class);
            metadataSources.addAnnotatedClass(acal.entidades.Enderecopessoa.class);
            metadataSources.addAnnotatedClass(acal.entidades.EnderecoView.class);
            metadataSources.addAnnotatedClass(acal.entidades.Entrada.class);
            metadataSources.addAnnotatedClass(acal.entidades.Entradaslog.class);
            metadataSources.addAnnotatedClass(acal.entidades.Fucionarionomeview.class);
            metadataSources.addAnnotatedClass(acal.entidades.Funcionario.class);
            metadataSources.addAnnotatedClass(acal.entidades.Geracaocontas.class);
            metadataSources.addAnnotatedClass(acal.entidades.Hidrometro.class);
            metadataSources.addAnnotatedClass(acal.entidades.Messagem.class);
            metadataSources.addAnnotatedClass(acal.entidades.Motivodespesa.class);
            metadataSources.addAnnotatedClass(acal.entidades.Motivoentrada.class);
            metadataSources.addAnnotatedClass(acal.entidades.Pessoa.class);
            metadataSources.addAnnotatedClass(acal.entidades.RcCaixaCompleto.class);
            //metadataSources.addAnnotatedClass(acal.entidades.RcConta.class);
            metadataSources.addAnnotatedClass(acal.entidades.Saida.class);
            metadataSources.addAnnotatedClass(acal.entidades.Saidaslog.class);
            metadataSources.addAnnotatedClass(acal.entidades.Socio.class);
            metadataSources.addAnnotatedClass(acal.entidades.SociosView.class);
            metadataSources.addAnnotatedClass(acal.entidades.Sociotabela.class);
            metadataSources.addAnnotatedClass(acal.entidades.TablesPriv.class);
            metadataSources.addAnnotatedClass(acal.entidades.TablesPrivPK.class);
            metadataSources.addAnnotatedClass(acal.entidades.Taxa.class);
            metadataSources.addAnnotatedClass(acal.entidades.Taxasconta.class);
            metadataSources.addAnnotatedClass(acal.entidades.User.class);
            metadataSources.addAnnotatedClass(acal.entidades.UserPK.class);

            metadataSources.addAnnotatedClass(InvoiceModel.class);

            metadataSources.addAnnotatedClass(LinkModel.class);
            metadataSources.addAnnotatedClass(CustomerModel.class);
            metadataSources.addAnnotatedClass(PartnerModel.class);
            metadataSources.addAnnotatedClass(AddressModel.class);

            Metadata metadata = metadataSources.getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/acal");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "123");

        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");

        return configuration;
    }

    public static Connection getConnection() {
        Session session = null;
        Connection connection = null;

        try {
            session = sessionFactory.openSession();
            JdbcConnectionAccess connectionAccess = ((SessionImpl) session).getJdbcConnectionAccess();
            connection = connectionAccess.obtainConnection();
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
