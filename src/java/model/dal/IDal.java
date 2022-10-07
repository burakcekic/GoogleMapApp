package model.dal;

import model.conn.IConn;
import model.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface IDal
{
    Session generateSession(IConn conn);
    SessionFactory generateSessionFactory(IConn conn);
    Location findByParams(double lng, double ltd);
    List<Location> getAll();
    boolean del(Location location);
    boolean update(Location set, Location condition);
    boolean insert(Location location);
}
