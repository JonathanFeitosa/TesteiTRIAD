package br.org.itriad.testeitriad.ui.repositorydetails;

import br.org.itriad.testeitriad.model.Item;
import br.org.itriad.testeitriad.ui.base.BaseContract;

public class RepositoryViewContract {

    public interface View extends BaseContract.View {

        void updateRepository(String str);
        void updateDescripton(String str);
        void updateAuthor(String str);
        void updateStar(String str);
        void updateLanguage(String str);
        void initInfo();
        void updateImage(String imageUri);
        Item getDataset();

    }

    public
    interface Presenter extends BaseContract.Presenter<RepositoryViewContract.View> {

        void setInfo();
    }
}
