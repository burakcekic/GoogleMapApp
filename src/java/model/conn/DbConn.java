package model.conn;

import model.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DbConn implements IConn
{
    private HibernateUtil hibernateUtil = HibernateUtil.getINSTANCE();
    public Session initSession(SessionFactory sessionFactory)
    {
        return sessionFactory.openSession();
    }

    public SessionFactory initSessionFactory()
    {
        return hibernateUtil.getSessionFactory();
    }

}
