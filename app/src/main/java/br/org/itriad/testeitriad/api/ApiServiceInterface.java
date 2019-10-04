package br.org.itriad.testeitriad.api;

import br.org.itriad.testeitriad.model.GitHubRepositories;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceInterface {
    @GET("/search/repositories")
    Call<GitHubRepositories> getTrendingRepositoriesAndroid(@Query("q") String filter, @Query("sort") String sort, @Query("order") String order, @Query("page") String page);
}
