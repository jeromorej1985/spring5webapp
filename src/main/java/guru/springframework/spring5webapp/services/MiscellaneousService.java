package guru.springframework.spring5webapp.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MiscellaneousService {
    private static final Logger logger = LoggerFactory.getLogger(MiscellaneousService.class);
    private HttpClient httpClient = HttpClient.newBuilder()
        .version(Version.HTTP_2)
        .connectTimeout(Duration.ofSeconds(10))
        .build();

    public String getInformation() {

       HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("http://openjdk.java.net/"))
            .header("Content-Type", "plain/text")
            .build();

     
      CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
      String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
      return result;
    

       
    }
}
