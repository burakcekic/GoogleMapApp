package model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_location")
public class Location
{
    @Id
    @Column(name="location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @Column(name = "longitude")
    private double lng;

    @Column(name = "latitude")
    private double ltd;

    @Column(name = "radius")
    private int radius;

    @Column(name = "address")
    private String address;

    public Location(double lng, double ltd, int radius, String address)
    {
        this.lng = lng;
        this.ltd = ltd;
        this.radius = radius;
        this.address = address;
    }

    public Location(int locationId) { this.locationId = locationId;}

    public Location() { }

    public Location(double lng, double ltd)
    {
        this.lng = lng;
        this.ltd = ltd;
    }

    public int getLocation_id() {
        return locationId;
    }

    public void setLocation_id(int locationId) {
        this.locationId = locationId;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLtd() {
        return ltd;
    }

    public void setLtd(double ltd) {
        this.ltd = ltd;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + locationId +
                ", lng=" + lng +
                ", ltd=" + ltd +
                ", radius=" + radius +
                ", address='" + address + '\'' +
                '}';
    }
}
