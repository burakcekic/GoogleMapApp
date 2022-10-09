package manager;

import model.entity.Location;

import java.util.List;

public interface IDbService
{
    List<Location> getAllResult();
    List<Location> findByParams(double lng, double ltd);

    boolean insert(Location location);
}
