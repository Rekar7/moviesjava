package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.*;
import com.westeros.moviesclient.contract.ActorDto;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class MoviesClient implements IMoviesClient {

    RestTemplate restClient;

    IMoviesClientUriBuilderProvider provider;
    public MoviesClient(IMoviesClientUriBuilderProvider provider) {
        restClient = new RestTemplate();
        this.provider=provider;
    }

    @Override
    public PagedResultDto getByDateRange(LocalDate from, LocalDate to) {
        String url = provider.builder()
                .pathSegment("discover")
                .pathSegment("movie")
                .queryParam("release_date.gte", from)
                .queryParam("release_date.lte", to)
                .build()
                .toUriString();
        var response = restClient.getForEntity(url, PagedResultDto.class).getBody();
        return response;
    }
//'https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&release_date.gte=2022-12-30&release_date.lte=2024-11-05'
    @Override
    public PagedResultDto getByDateRange(LocalDate from, LocalDate to, int page) {
        return null;
    }

    @Override
    public MovieDto getMovie(long id) {
        String url = provider.builder()
                .pathSegment("movie")
                .pathSegment(""+id)
                .build()
                .toUriString();
        var response = restClient.getForEntity(url, MovieDto.class).getBody();
        return response;
    }

    @Override
    public CreditsDto getCredits(long id) {
        return null;
    }

    @Override
    public ActorDto getActorDetails(long id) {
        return null;
    }
}
