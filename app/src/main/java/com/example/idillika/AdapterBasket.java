package com.example.idillika;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idillika.API.ModelCatalog;

import java.util.List;

public class AdapterBasket extends RecyclerView.Adapter<AdapterBasket.ViewHolder> {

    Context context;
    List<ModelForBasket> list;


    public AdapterBasket( Context context, List<ModelForBasket> list ) {
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        View v =LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.basket_item, parent, false );
        ViewHolder viewHolder = new ViewHolder ( v );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {


    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textGetBrand;
        private TextView textGetDescBrand;
        private TextView textGetPriceBrand;

        public ViewHolder( @NonNull View itemView ) {
            super ( itemView );
            textGetBrand = itemView.findViewById ( R.id.text1 );
            textGetDescBrand = itemView.findViewById ( R.id.text2 );
            textGetPriceBrand = itemView.findViewById ( R.id.text3 );

        }

    }
}
