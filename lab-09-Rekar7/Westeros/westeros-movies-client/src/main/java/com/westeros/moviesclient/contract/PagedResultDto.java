package com.westeros.moviesclient.contract;

import java.util.List;

public record PagedResultDto(List<MovieSummaryDto> movies, int page, int totalPages, int totalResults) {

    public record MovieSummaryDto(long id, String title){}
}
