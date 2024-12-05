package com.westeros.moviesclient.contract;

import java.util.List;

public record PagedResultDto(int page, List<MovieSummaryDto> results, int totalPages, int totalResults) {

    public record MovieSummaryDto(boolean adult, String backdropPath, List<Integer> genreIds,
                                  long id, String originalLanguage, String originalTitle, String overview,
                                  float popularity, String posterPath, String releaseDate, String title, boolean video, float voteAverage, int voteCount){}
}
