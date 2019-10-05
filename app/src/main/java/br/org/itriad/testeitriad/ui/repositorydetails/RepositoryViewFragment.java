package br.org.itriad.testeitriad.ui.repositorydetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.Picasso;
import br.org.itriad.testeitriad.R;
import br.org.itriad.testeitriad.model.Item;
import br.org.itriad.testeitriad.util.Constants;

public class RepositoryViewFragment extends Fragment implements  RepositoryViewContract.View {

    private Item mDataset;
    private ImageView ivBasicImage;
    private TextView repository, description, author, star, language;
    private RepositoryViewContract.Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initInfo();

        return inflater.inflate(R.layout.fragment_viewrepository, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.attach(this);

        repository = view.findViewById(R.id.txtGitRepository);
        description = view.findViewById(R.id.txtGitDescription);
        author = view.findViewById(R.id.txtGitAuthor);
        star = view.findViewById(R.id.txtGitStar);
        language = view.findViewById(R.id.txtGitLanguage);
        ivBasicImage = view.findViewById(R.id.txtGitAvatar);

        presenter.setInfo();
    }

    @Override
    public void initInfo(){
        presenter = new RepositoryViewPresenter();
        this.mDataset = (Item) getArguments().getSerializable(Constants.TAG);
    }
    @Override
    public void updateRepository(String str){
        repository.setText(str);
    }
    @Override
    public void updateDescripton(String str){
        description.setText(str);
    }
    @Override
    public void updateAuthor(String str){
        author.setText(str);
    }
    @Override
    public void updateStar(String str){
        star.setText(str);
    }
    @Override
    public void updateLanguage(String str){
        language.setText(str);
    }
    @Override
    public Item getDataset(){
        return this.mDataset;
    }
    @Override
    public void updateImage(String imageUri){
        Picasso.with(requireActivity())
                .load(imageUri)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(ivBasicImage);
    }
}
