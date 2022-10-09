package manager;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface IHttpClientService
{
    String urlCreater(double lng, double ltd, int radius);
    HttpResponse getHttpResponse(String url) throws IOException, InterruptedException;
}
