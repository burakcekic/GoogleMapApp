package api;

import core.Util;
import manager.HttpClientManager;
import manager.LocationManager;
import model.conn.DbConn;
import model.dal.LocationDal;
import model.entity.Location;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/getData")
public class LocationController
{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLocation")
    public String getLocation(@QueryParam("lng")double lng, @QueryParam("ltd")double ltd,@QueryParam("radius")int radius) throws IOException, InterruptedException
    {

        String url = "";
        LocationManager locationManager = new LocationManager(new LocationDal(new DbConn()));
        List<Location> locations = locationManager.findByParams(lng, ltd);

        JSONObject response = new JSONObject();


        try {
            response.put("status",200);
            response.put("message","api successful");


            if (locations.size() > 0)
            {
                Location location  = locations.get(0);
                JSONObject data = new JSONObject();
                data.put("lng",location.getLng());
                data.put("ltd",location.getLtd());
                JSONArray arrayData = new JSONArray();
                arrayData.put(data);
                response.put("data",arrayData);
            }
            else
            {

                HttpClientManager httpClientManager = new HttpClientManager();
                url = httpClientManager.urlCreater(lng, ltd, radius);
                HttpResponse httpResponse = httpClientManager.getHttpResponse(url);

                JSONObject jsonObject = new JSONObject(httpResponse.body().toString());

                System.out.println(url);
                String resultStatus = jsonObject.getString("status");
                if(resultStatus.equals("OK"))
                {
                    JSONArray results = jsonObject.getJSONArray("results");

                    for (int i = 0; i < results.length(); i++)
                    {
                        JSONObject result = results.getJSONObject(i);

                        double resultLng = result.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
                        double resultLtd = result.getJSONObject("geometry").getJSONObject("location").getDouble("lat");

                        String resultAddress = result.getJSONObject("plus_code").getString("compound_code");
                        Location location = new Location(resultLng,resultLtd,radius,resultAddress);
                        locationManager.insert(location);

                        JSONObject data = new JSONObject();
                        data.put("lng",resultLng);
                        data.put("ltd",resultLtd);
                        JSONArray arrayData = new JSONArray();
                        arrayData.put(data);
                        response.put("data",arrayData);

                    }
                }
                else
                {
                    JSONArray arrayData = new JSONArray();
                    response.put("data",arrayData);
                }

            }
        }
        catch (Exception e)
        {
            Util.getINSTANCE().exceptionHandler(e);
            response.put("status",500);
            response.put("message",e.getMessage());
        }



        return response.toString();
    }
}
