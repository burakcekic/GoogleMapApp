package model.dal;

import model.conn.IConn;
import model.entity.Location;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LocationDal extends AbstractDal
{
    private IConn conn = null;
    private Session session = null;
    private SessionFactory sessionFactory = null;


    private static final String findStrQuery = "FROM model.entity.Location WHERE lng= :lng and ltd = :ltd";

    public LocationDal(IConn conn)
    {
        this.conn = conn;
        session = generateSession(conn);
        sessionFactory = generateSessionFactory(conn);
    }

    public Session generateSession(IConn conn)
    {
        return conn.initSession(conn.initSessionFactory());
    }

    public SessionFactory generateSessionFactory(IConn conn)
    {
        return conn.initSessionFactory();
    }


    @Override
    public List<Location> getAll()
    {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Location.class);
        List<Location> locationList = criteria.list();
        transaction.commit();

        //CriteriaBuilder builder = session.getCriteriaBuilder();
        //CriteriaQuery<Location> cq = builder.createQuery(Location.class);
        //Root<Location> rootEntry = cq.from(Location.class);
        //CriteriaQuery<Location> all = cq.select(rootEntry);
        //TypedQuery<Location> allQuery = session.createQuery(all);
        //List<Location> locationList = allQuery.getResultList();
        return locationList;
    }

    @Override
    public List<Location> findByParams(Location location)
    {

        double lng = location.getLng();
        double ltd = location.getLtd();
        Query query = session.createQuery(findStrQuery);
        query.setParameter("lng",lng);
        query.setParameter("ltd",ltd);
        List<Location> locations =  query.list();
       return locations;
    }


    @Override
    public boolean insert(Location location)
    {

        boolean flag = false;
        try {
            Transaction transaction = session.beginTransaction();
            session.save(location);
            transaction.commit();
            flag = true;
        }
        catch (Exception e) { e.printStackTrace();}

        return flag;
    }

    public IConn getConn() {
        return conn;
    }

    public Session getSession() {
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
