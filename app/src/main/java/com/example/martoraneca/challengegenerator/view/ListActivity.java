package com.example.martoraneca.challengegenerator.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.martoraneca.challengegenerator.R;
import com.example.martoraneca.challengegenerator.data.FakeDataSource;
import com.example.martoraneca.challengegenerator.data.ListItem;
import com.example.martoraneca.challengegenerator.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface, View.OnClickListener {

    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    private static final String EXTRA_TIME = "EXTRA_TIME";
    private static final String EXTRA_CHALLENGE = "EXTRA_CHALLENGE";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        //Dependency Injection
        controller = new Controller(this, new FakeDataSource());

        Button button = (Button) findViewById(R.id.rec_list_button);

        button.setOnClickListener(this);

    }

    @Override
    public void startDetailActivity(int color, String time, String challenge) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_COLOR, color);
        i.putExtra(EXTRA_TIME, time);
        i.putExtra(EXTRA_CHALLENGE, challenge);
        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addNewListItemToView(ListItem newItem) {
        listOfData.add(newItem);

        int endOfList = listOfData.size() - 1;

        adapter.notifyItemInserted(endOfList);

        recyclerView.smoothScrollToPosition(endOfList);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.rec_list_button) {
            controller.createNewListItem();
        }
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = layoutInflater.inflate(R.layout.item_data, parent, false);

            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);

            holder.color.setBackgroundResource(currentItem.getDrawables());
            holder.time.setText(currentItem.getTimes());
            holder.challenges.setText(currentItem.getChallenges());

        }

        @Override
        public int getItemCount() {
            //Helps the adapter decide how many Items it will need to manage
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private View color;
            private TextView time;
            private TextView challenges;
            private ViewGroup container;

            CustomViewHolder(View itemView) {
                super(itemView);

                this.color = itemView.findViewById(R.id.item_drawable);
                this.time = itemView.findViewById(R.id.item_time);
                this.challenges = itemView.findViewById(R.id.item_challenge);
                this.container = itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {

                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onItemClick(
                        listItem
                );

            }
        }

    }
}
