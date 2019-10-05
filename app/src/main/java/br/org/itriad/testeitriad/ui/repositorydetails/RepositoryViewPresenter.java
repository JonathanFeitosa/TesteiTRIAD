package br.org.itriad.testeitriad.ui.repositorydetails;

public class RepositoryViewPresenter implements RepositoryViewContract.Presenter {

    private RepositoryViewContract.View view;

    @Override
    public void attach(RepositoryViewContract.View view) {
        this.view = view;
    }

    public void setInfo(){
        view.updateRepository(view.getDataset().getName());
        view.updateDescripton(view.getDataset().getDescription());
        view.updateAuthor(view.getDataset().getOwner().getLogin());
        view.updateStar(""+view.getDataset().getStargazersCount());
        view.updateLanguage(view.getDataset().getLanguage());
        view.updateImage(view.getDataset().getOwner().getAvatarUrl());
    }
}