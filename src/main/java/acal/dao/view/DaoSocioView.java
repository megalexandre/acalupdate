package acal.dao.view;

import acal.entidades.SociosView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DaoSocioView {

    private final SessionFactory sessionFactory;

    public DaoSocioView() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<SociosView> BuscarTodosSociosView() {
        List<SociosView> usuarios = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            String hql = "FROM SociosView";
            Query<SociosView> query = session.createQuery(hql, SociosView.class);
            usuarios = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return usuarios;
    }

}
