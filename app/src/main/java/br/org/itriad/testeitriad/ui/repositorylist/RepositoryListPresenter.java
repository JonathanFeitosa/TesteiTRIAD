package br.org.itriad.testeitriad.ui.repositorylist;

import br.org.itriad.testeitriad.api.ApiServiceInterface;
import br.org.itriad.testeitriad.api.ApiServiceStart;
import br.org.itriad.testeitriad.model.GitHubRepositories;
import br.org.itriad.testeitriad.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryListPresenter implements RepositoryListContract.Presenter {

    private RepositoryListContract.View view;

    @Override
    public void attach(RepositoryListContract.View view) {
        this.view = view;
    }

    @Override
    public void getRepositories(String device, String language, String sort, String order, String page){
        ApiServiceInterface asi = ApiServiceStart.create(Constants.BASE_URL).create(ApiServiceInterface.class);
        asi.getTrendingRepositoriesAndroid(device + "+language:" + language, sort, order, page).enqueue(new Callback<GitHubRepositories>() {
            @Override
            public void onResponse(Call<GitHubRepositories> call, Response<GitHubRepositories> response) {

                if(response.isSuccessful()) {
                    try {

                        view.setListRepositories(response.body().getItems());

                        // set RecyclerView
                        view.setRecyclerView();


                    } catch (Exception e) {
                        view.showToastMessage("Error[#1] loading repositories: " + e.getMessage());
                    }
                }else {
                    view.showToastMessage("Error[#2] loading repositories: " + response.code());

                }
            }

            @Override
            public void onFailure(Call<GitHubRepositories> call, Throwable t) {

                view.showToastMessage("Error{[3] loading repositories: ");
            }
        });
    }
}