package br.org.itriad.testeitriad.ui.repositorydetails;

import br.org.itriad.testeitriad.model.Item;

public class ViewRepositoryPresenter implements ViewRepositoryContract.Presenter {

    //  private val subscriptions = CompositeDisposable()

    private ViewRepositoryContract.View view;


    @Override
    public void subscribe() {

    }
    @Override
    public void unsubscribe() {

    }
    @Override
    public void attach(ViewRepositoryContract.View view) {
        this.view = view;
    }
    public void setInfo(){
        view.updateRepository(view.getDataset().getName());
        view.updateDescripton(view.getDataset().getDescription());
        view.updateAuthor(view.getDataset().getOwner().getLogin());
        view.updateStar(""+view.getDataset().getStargazersCount());
        view.updateLanguage(view.getDataset().getLanguage());
    }
}