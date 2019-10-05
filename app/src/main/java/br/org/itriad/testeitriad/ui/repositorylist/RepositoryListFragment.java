package br.org.itriad.testeitriad.ui.repositorylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import br.org.itriad.testeitriad.R;
import br.org.itriad.testeitriad.adapters.RecyclerViewAdapter;
import br.org.itriad.testeitriad.model.Item;
import br.org.itriad.testeitriad.util.Constants;

public class RepositoryListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RepositoryListContract.View {

    //  Instances
    private RecyclerView recyclerView;
    private ArrayList<Item> listrepositories;
    private String device, language, sort, order, page;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView.LayoutManager mLayoutManager;
    private RepositoryListContract.Presenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initInfo();

        return inflater.inflate(R.layout.fragment_listrepository, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // View Reference
        presenter.attach(this);

        // RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewRL);
        createRecyclerView();

        // SwipeRefreshLayout
        mSwipeRefreshLayout = view.findViewById(R.id.scrollLayout);
        createSwipeRefreshLayout();

    }

//    ---- Getting Initial References
    @Override
    public void initInfo(){
        presenter = new RepositoryListPresenter(); // Presenter
        listrepositories = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(requireActivity());
        this.device = "android";
        this.language = "";
        this.sort = "stars";
        this.order = "desc";
        this.page = "1";
    }
    @Override
    public ArrayList<Item>  setListRepositories(ArrayList<Item> listrepositories){
        return this.listrepositories = listrepositories;
    }
    @Override
    public void setRecyclerView(){
        recyclerView.setAdapter(new RecyclerViewAdapter(listrepositories, new RecyclerViewAdapter.OnItemClickListener() {
            @Override public void onItemClick(Item item) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.TAG, item);
                Navigation.findNavController(recyclerView).navigate(R.id.action_navigation_home_to_navigation_config, bundle);
            }
        }));
        mSwipeRefreshLayout.setRefreshing(false);
    }
    @Override
    public void showToastMessage(String message) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void createRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
    }
    @Override
    public void createSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        //  Trigger the swipe refresh layout programmatically
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {

                if (mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(true);
                }
                presenter.getRepositories(device, language, sort, order, page);
            }
        });
    }
    @Override
    public void onRefresh() {
        presenter.getRepositories(device, language, sort, order, page);
    }
}
