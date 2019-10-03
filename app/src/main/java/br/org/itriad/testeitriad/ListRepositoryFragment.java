package br.org.itriad.testeitriad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import br.org.itriad.testeitriad.model.Repositories;

public class ListRepositoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Repositories> listrepositories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listrepositories = new ArrayList<>();
        return inflater.inflate(R.layout.fragment_listrepository, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(requireActivity());

        Repositories myDataset = new Repositories();
        myDataset.setName("Jonathan Feitosa");
        listrepositories.add(myDataset);

        Repositories myDataset2 = new Repositories();
        myDataset2.setName("Jonathan Feitosa 2");
        listrepositories.add(myDataset2);

        Repositories myDataset3 = new Repositories();
        myDataset3.setName("Jonathan Feitosa 3");
        listrepositories.add(myDataset3);

        RecyclerView.Adapter mAdapter = new RecyclerViewAdapter(listrepositories);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
