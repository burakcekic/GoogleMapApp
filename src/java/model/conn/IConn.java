package model.conn;

import model.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface IConn
{
    Session initSession(SessionFactory sessionFactory);
    SessionFactory initSessionFactory();
}
