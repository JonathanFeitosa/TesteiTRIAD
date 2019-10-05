package br.org.itriad.testeitriad.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.org.itriad.testeitriad.R;
import br.org.itriad.testeitriad.model.Item;

public class ViewRepositoryFragment extends Fragment {

    private Item mDataset;
    private TextView repository, description, author, star, language;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.mDataset = (Item) getArguments().getSerializable("Teste");




        return inflater.inflate(R.layout.fragment_viewrepository, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repository = view.findViewById(R.id.txtGitRepository);
        description = view.findViewById(R.id.txtGitDescription);
        author = view.findViewById(R.id.txtGitAuthor);
        star = view.findViewById(R.id.txtgitStar);
        language = view.findViewById(R.id.txtgitLanguage);


        repository.setText(mDataset.getName());
        description.setText(mDataset.getDescription());
        author.setText(mDataset.getOwner().getLogin());
        star.setText(""+mDataset.getStargazersCount());
        language.setText(mDataset.getLanguage());

    }
}
