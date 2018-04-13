package com.example.jana.switchlistgridinrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    Integer []imageUrl = new Integer[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    String []names = new String[]{"Rs 255","Rs 599","Rs 999","Rs 99"};

    ImageView imglistgrid;

    RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (findViewById(R.id.my_recycler_view));


        imglistgrid = findViewById(R.id.imglistgrid);
        imglistgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isSwitched = mAdapter.toggleItemViewType();

                String strvalue = String.valueOf(isSwitched);
                if (strvalue.equals("false")){
                    mRecyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(MainActivity.this) : new GridLayoutManager(MainActivity.this, 2));
                    mAdapter.notifyDataSetChanged();
                    imglistgrid.setImageResource(R.drawable.grid);
                }else if (strvalue.equals("true")){
                    mRecyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(MainActivity.this) : new GridLayoutManager(MainActivity.this, 2));
                    mAdapter.notifyDataSetChanged();
                    imglistgrid.setImageResource(R.drawable.list);
                }else{
                    mRecyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(MainActivity.this) : new GridLayoutManager(MainActivity.this, 2));
                    mAdapter.notifyDataSetChanged();
                }

            }
        });

        initView();
    }

    private void initView() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List list = getList();
        mAdapter = new RecyclerAdapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


    }

    private List getList() {
        List list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            ItemModel model = new ItemModel();
            model.setName(names[i]);
            model.setImagePath(imageUrl[i]);
            list.add(model);
        }
        return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.switch_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.switch_view:
                supportInvalidateOptionsMenu();
                boolean isSwitched = mAdapter.toggleItemViewType();
                mRecyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(this) : new GridLayoutManager(this, 2));
                mAdapter.notifyDataSetChanged();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}