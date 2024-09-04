package br.org.acal.infra;

import br.org.acal.resouces.entidades.CaixaView;
import br.org.acal.resouces.entidades.Categoriasocio;
import br.org.acal.resouces.entidades.Cheque;
import br.org.acal.resouces.entidades.Chequeslog;
import br.org.acal.resouces.entidades.Conta;
import br.org.acal.resouces.entidades.ContasView;
import br.org.acal.resouces.entidades.Contaslog;
import br.org.acal.resouces.entidades.Contrato;
import br.org.acal.resouces.entidades.Endereco;
import br.org.acal.resouces.entidades.EnderecoView;
import br.org.acal.resouces.entidades.Enderecopessoa;
import br.org.acal.resouces.entidades.Entrada;
import br.org.acal.resouces.entidades.Entradaslog;
import br.org.acal.resouces.entidades.Funcionario;
import br.org.acal.resouces.entidades.Geracaocontas;
import br.org.acal.resouces.entidades.Hidrometro;
import br.org.acal.resouces.entidades.Messagem;
import br.org.acal.resouces.entidades.Motivodespesa;
import br.org.acal.resouces.entidades.Motivoentrada;
import br.org.acal.resouces.entidades.Pessoa;
import br.org.acal.resouces.entidades.RcCaixaCompleto;
import br.org.acal.resouces.entidades.Saida;
import br.org.acal.resouces.entidades.Saidaslog;
import br.org.acal.resouces.entidades.Socio;
import br.org.acal.resouces.entidades.SociosView;
import br.org.acal.resouces.entidades.Sociotabela;
import br.org.acal.resouces.entidades.TablesPriv;
import br.org.acal.resouces.entidades.TablesPrivPK;
import br.org.acal.resouces.entidades.Taxa;
import br.org.acal.resouces.entidades.Taxasconta;
import br.org.acal.resouces.entidades.User;
import br.org.acal.resouces.entidades.UserPK;
import br.org.acal.resources.model.AddressModel;
import br.org.acal.resources.model.CategoryModel;
import br.org.acal.resources.model.InvoiceModel;
import br.org.acal.resources.model.LinkModel;
import br.org.acal.resources.model.PartnerModel;
import br.org.acal.resources.model.PriceModel;
import br.org.acal.resources.model.WaterMeterModel;
import br.org.acal.resources.model.WaterParamModel;
import br.org.acal.resources.model.WaterQualityModel;
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
            metadataSources.addAnnotatedClass(CaixaView.class);
            metadataSources.addAnnotatedClass(Categoriasocio.class);
            metadataSources.addAnnotatedClass(Cheque.class);
            metadataSources.addAnnotatedClass(Chequeslog.class);
            metadataSources.addAnnotatedClass(Conta.class);
            metadataSources.addAnnotatedClass(Contaslog.class);
            metadataSources.addAnnotatedClass(ContasView.class);
            metadataSources.addAnnotatedClass(Contrato.class);
            metadataSources.addAnnotatedClass(Endereco.class);
            metadataSources.addAnnotatedClass(Enderecopessoa.class);
            metadataSources.addAnnotatedClass(EnderecoView.class);
            metadataSources.addAnnotatedClass(Entrada.class);
            metadataSources.addAnnotatedClass(Entradaslog.class);
            metadataSources.addAnnotatedClass(Funcionario.class);
            metadataSources.addAnnotatedClass(Geracaocontas.class);
            metadataSources.addAnnotatedClass(Hidrometro.class);
            metadataSources.addAnnotatedClass(Messagem.class);
            metadataSources.addAnnotatedClass(Motivodespesa.class);
            metadataSources.addAnnotatedClass(Motivoentrada.class);
            metadataSources.addAnnotatedClass(Pessoa.class);
            metadataSources.addAnnotatedClass(RcCaixaCompleto.class);

            metadataSources.addAnnotatedClass(Saida.class);
            metadataSources.addAnnotatedClass(Saidaslog.class);
            metadataSources.addAnnotatedClass(Socio.class);
            metadataSources.addAnnotatedClass(SociosView.class);
            metadataSources.addAnnotatedClass(Sociotabela.class);
            metadataSources.addAnnotatedClass(TablesPriv.class);
            metadataSources.addAnnotatedClass(TablesPrivPK.class);
            metadataSources.addAnnotatedClass(Taxa.class);
            metadataSources.addAnnotatedClass(Taxasconta.class);
            metadataSources.addAnnotatedClass(User.class);
            metadataSources.addAnnotatedClass(UserPK.class);
            metadataSources.addAnnotatedClass(InvoiceModel.class);
            metadataSources.addAnnotatedClass(LinkModel.class);
            metadataSources.addAnnotatedClass(CustomerModel.class);
            metadataSources.addAnnotatedClass(PartnerModel.class);
            metadataSources.addAnnotatedClass(AddressModel.class);
            metadataSources.addAnnotatedClass(PriceModel.class);
            metadataSources.addAnnotatedClass(CategoryModel.class);

            metadataSources.addAnnotatedClass(WaterMeterModel.class);
            metadataSources.addAnnotatedClass(WaterParamModel.class);
            metadataSources.addAnnotatedClass(WaterQualityModel.class);

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
