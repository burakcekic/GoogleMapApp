package manager;

import core.Util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientManager implements IHttpClientService
{

    @Override
    public String urlCreater(double lng, double ltd, int radius)
    {
        Util util = Util.getINSTANCE();
        String url = "";
        try
        {
            String baseUrl = util.getProperties("api.base_url");
            String apiKey = util.getProperties("api.key");
            url = baseUrl + "?keyword=cruise&location=" + ltd + "," + lng + "&radius="+radius+"&key=" + apiKey;

        }
        catch (IOException e )
        {
            util.exceptionHandler(e);
        }

        return url;
    }

    @Override
    public HttpResponse getHttpResponse(String url) throws IOException, InterruptedException
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(url))
                .build();

        HttpResponse httpResponse =  httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse;
    }
}
