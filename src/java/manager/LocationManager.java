package manager;

import model.dal.IDal;
import model.entity.Location;

import java.util.List;

public class LocationManager extends AbstractDbManager
{
    private IDal iDal;

    public LocationManager(IDal iDal)
    {
        this.iDal = iDal;
    }

    @Override
    public List<Location> getAllResult()
    {
        return iDal.getAll();
    }

    @Override
    public List<Location> findByParams(double lng, double ltd)
    {
        Location location = new Location(lng,ltd);
        return iDal.findByParams(location);
    }

    @Override
    public boolean insert(Location location)
    {
        return iDal.insert(location);
    }
}
