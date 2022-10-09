package manager;

import model.entity.Location;

import java.util.List;

public abstract class AbstractDbManager implements IDbService
{
    @Override
    public List<Location> getAllResult()
    {
        return null;
    }

    @Override
    public List<Location> findByParams(double lng, double ltd)
    {
        return null;
    }

    @Override
    public boolean insert(Location location) {
        return false;
    }
}
