package br.org.itriad.testeitriad.ui.repositorydetails;

import br.org.itriad.testeitriad.model.Item;
import br.org.itriad.testeitriad.ui.base.BaseContract;

public class ViewRepositoryContract {

    public interface View extends BaseContract.View {
        //   fun showAboutFragment()
        //    fun showListFragment()]
        //fun setInfoView()
    //    fun addDots(size: Int, position: Int = 0)
        void updateRepository(String str);
        void updateDescripton(String str);
        void updateAuthor(String str);
        void updateStar(String str);
        void updateLanguage(String str);
        Item getDataset();

    }

    public
    interface Presenter extends BaseContract.Presenter<ViewRepositoryContract.View> {
        // fun onDrawerOptionAboutClick()
        //  fun loadData(user: User)
        void setInfo();
    }
}
