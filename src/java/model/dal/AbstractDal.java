package model.dal;

import model.conn.IConn;
import model.entity.Location;
import org.hibernate.Session;

import java.util.List;

public abstract class AbstractDal implements IDal
{
    public List<Location> getAll() {
        return null;
    }

    public Location findByParams(double lng, double ltd) {
        return null;
    }

    public boolean del(Location location) {
        return false;
    }

    public boolean update(Location set, Location condition) {
        return false;
    }

    public boolean insert(Location location) {
        return false;
    }
}
