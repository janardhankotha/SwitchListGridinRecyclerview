package com.example.jana.switchlistgridinrecyclerview;

/**
 * Created by Jana on 3/30/2018.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;



public class RecyclerAdapter extends RecyclerView.Adapter {

    private List <ItemModel> itemModels;
    private Context context;
    private static final int LIST_ITEM = 0;
    private static final int GRID_ITEM = 1;
    boolean isSwitchView = true;

    public RecyclerAdapter(Context context, List itemModels) {
        this.itemModels = itemModels;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView;
        if (i == LIST_ITEM){
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.item_layout, null);
        }else{
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_grid, null);
        }
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemModel model = itemModels.get(position);
        initializeViews(model, holder, position);
    }

    @Override
    public int getItemViewType (int position) {
        if (isSwitchView){
            return LIST_ITEM;
        }else{
            return GRID_ITEM;
        }
    }

    public boolean toggleItemViewType () {
        isSwitchView = !isSwitchView;
        return isSwitchView;
    }



    private void initializeViews(ItemModel model, final RecyclerView.ViewHolder holder, int position) {

       // String imageUrl = model.getImagePath();

        ((ItemViewHolder)holder).imageView.setImageResource(model.getImagePath());
      /*  if (imageUrl != null && !imageUrl.isEmpty()){
            Glide.with(context)
                    .load(imageUrl)
                    .into(((ItemViewHolder)holder).imageView);

        }*/
        ((ItemViewHolder)holder).name.setText(model.getName());
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {


        TextView name;

        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}