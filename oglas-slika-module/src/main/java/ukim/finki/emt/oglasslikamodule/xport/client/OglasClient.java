package ukim.finki.emt.oglasslikamodule.xport.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ukim.finki.emt.oglasslikamodule.domain.models.Oglas;

import java.util.Collections;
import java.util.List;


@Service
public class OglasClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public OglasClient(@Value("${app.oglas-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Oglas> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/oglas").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Oglas>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
