package br.org.itriad.testeitriad;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import br.org.itriad.testeitriad.model.Item;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Item> mDataset;

    public RecyclerViewAdapter(ArrayList<Item> myDataset) {
        mDataset = myDataset;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, description, author, star, language;
        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.gitTitle);
            description = itemView.findViewById(R.id.gitDescription);
            author = itemView.findViewById(R.id.gitAuthor);
            star = itemView.findViewById(R.id.gitStart);
            language = itemView.findViewById(R.id.gitLanguage);
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
        holder.title.setText(mDataset.get(position).getName());

        if(mDataset.get(position).getDescription().length() > 90){
            holder.description.setText(mDataset.get(position).getDescription().substring(0,90) + "...");
        }else{
            holder.description.setText(mDataset.get(position).getDescription());

        }
        holder.author.setText(mDataset.get(position).getOwner().getLogin());
        holder.language.setText(mDataset.get(position).getLanguage());
        holder.star.setText("" + mDataset.get(position).getStargazersCount());

    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}