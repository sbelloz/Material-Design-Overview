package it.bellotti.android.materialdesignsample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.bellotti.android.materialdesignsample.R;
import it.bellotti.android.materialdesignsample.ui.activity.DetailActivity;

/**
 * Created with Android Studio.
 * User: SimoneBellotti
 * Date: 09/11/2015
 * Time: 14.12
 * App:  MaterialDesignSample
 */
public class CardContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ListAdapter());
        return recyclerView;
    }

    static class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int LENGTH = 100;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            /* no-op */
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.item_card, parent, false));
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.getContext().startActivity(DetailActivity.newIntent(v.getContext()));
                    }
                });
            }
        }
    }
}
