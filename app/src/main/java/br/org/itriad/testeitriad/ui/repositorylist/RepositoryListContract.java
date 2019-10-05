package br.org.itriad.testeitriad.ui.repositorylist;

import java.util.ArrayList;

import br.org.itriad.testeitriad.model.Item;
import br.org.itriad.testeitriad.ui.base.BaseContract;

public class RepositoryListContract {

    public interface View extends BaseContract.View {

        void setRecyclerView();
        void showToastMessage(String message);
        void initInfo();
        void createSwipeRefreshLayout();
        void createRecyclerView();
        ArrayList<Item> setListRepositories(ArrayList<Item> listrepositories);

    }

    public
    interface Presenter extends BaseContract.Presenter<RepositoryListContract.View> {
        void getRepositories(String device, String language, String sort, String order, String page);
    }
}
