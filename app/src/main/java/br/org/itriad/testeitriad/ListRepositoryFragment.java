package br.org.itriad.testeitriad;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import br.org.itriad.testeitriad.api.ApiServiceStart;
import br.org.itriad.testeitriad.api.ApiServiceInterface;
import br.org.itriad.testeitriad.model.GitHubRepositories;
import br.org.itriad.testeitriad.model.Item;
import br.org.itriad.testeitriad.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListRepositoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private ArrayList<Item> listrepositories;
    private String device, language, sort, order, page;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listrepositories = new ArrayList<>();
        this.device = "android";
        this.language = "kotlin";
        this.sort = "stars";
        this.order = "desc";
        this.page = "1";

        return inflater.inflate(R.layout.fragment_listrepository, container, false);

    }

    private void getRepositories() {

        ApiServiceInterface asi = ApiServiceStart.create(Constants.BASE_URL).create(ApiServiceInterface.class);
        asi.getTrendingRepositoriesAndroid(this.device + "+language:" + this.language, sort, order, page).enqueue(new Callback<GitHubRepositories>() {
            @Override
            public void onResponse(Call<GitHubRepositories> call, Response<GitHubRepositories> response) {

                if(response.isSuccessful()) {
                    try {

                        listrepositories = response.body().getItems();

                        // RV
                        RecyclerView.Adapter mAdapter = new RecyclerViewAdapter(listrepositories);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setAdapter(mAdapter);
                        mSwipeRefreshLayout.setRefreshing(false);

                    } catch (Exception e) {
                        Toast.makeText(requireActivity(), "Error[#1] loading repositories: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(requireActivity(), "Error[#2] loading repositories: " + response.code(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GitHubRepositories> call, Throwable t) {
                Toast.makeText(requireActivity(), "Error{[3] loading repositories: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerv);
        mLayoutManager = new LinearLayoutManager(requireActivity());

        // SwipeRefreshLayout
        mSwipeRefreshLayout = view.findViewById(R.id.scrollLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {

                if (mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(true);
                }
                getRepositories();
            }
        });
    }
    @Override
    public void onRefresh() {
        getRepositories();
    }

}
