package br.org.itriad.testeitriad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import br.org.itriad.testeitriad.model.Repositories;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Repositories> mDataset;

    public RecyclerViewAdapter(ArrayList<Repositories> myDataset) {
        mDataset = myDataset;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView nome;
        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textView);

        }
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listrow, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nome.setText(mDataset.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}