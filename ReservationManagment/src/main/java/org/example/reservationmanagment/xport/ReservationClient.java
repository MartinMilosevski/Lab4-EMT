package org.example.reservationmanagment.xport;

import org.example.reservationmanagment.domain.valueobjects.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class ReservationClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public ReservationClient(@Value("${DDD-Rent-a-Car.Car-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Car> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/car").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Car>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Car> SearchCars(String brand, Integer moneyPerDay) {
        try {
            String url = uri().path("/api/car/search").queryParam("brand", brand).queryParam("moneyPerDay", moneyPerDay).build().toUriString();
            return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
