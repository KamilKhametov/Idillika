package com.example.idillika;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idillika.API.ModelCatalog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class AdapterCatalog extends RecyclerView.Adapter<AdapterCatalog.ViewHolder> {

    public List<ModelCatalog> modelCatalogList;
    private SharedPreferences pref;



    // Создание конструктора
    public AdapterCatalog( List<ModelCatalog> modelCatalogList ) {
        this.modelCatalogList=modelCatalogList;
    }

    // Раздувание layout`a
    @NonNull
    @Override
    public AdapterCatalog.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        View v=LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.catalog_item, parent, false );
        ViewHolder vh=new ViewHolder ( v );
        if(pref == null) {
            pref=parent.getContext ().getSharedPreferences ( "NICE", Context.MODE_PRIVATE );
        }
        return vh;
    }

    // Получаем значения по позиции
    @Override
    public void onBindViewHolder( @NonNull AdapterCatalog.ViewHolder holder, int position ) {
        holder.bind ( modelCatalogList.get ( position ) );
    }


    @Override
    public int getItemCount() {
        return modelCatalogList.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Объявление полей
        public TextView textNameBrand;
        public TextView textDescBrand;
        private TextView textPriceBrand;
        public ImageView imageBrand;
        private ImageView imageLike;
        boolean s;
        private ModelCatalog currentModelCatalog;



        public ViewHolder( @NonNull View itemView ) {
            super ( itemView );
            textNameBrand=itemView.findViewById ( R.id.textNameClothes );
            textDescBrand=itemView.findViewById ( R.id.textDescClothes );
            textPriceBrand=itemView.findViewById ( R.id.textPriceClothes );
            imageBrand=itemView.findViewById ( R.id.imageClothes );
            imageLike = itemView.findViewById ( R.id.imageLike );

            imageLike.setOnClickListener ( v -> {
                if(pref.getBoolean ( String.valueOf ( currentModelCatalog.getId () ), false )){
                    imageLike.setImageResource ( R.drawable.heart_unlike);
                    saveData ( String.valueOf ( currentModelCatalog.getId () ), false );
                }else {
                    imageLike.setImageResource ( R.drawable.heart_like );
                    saveData ( String.valueOf ( currentModelCatalog.getId () ), true );
                }
            } );


        }




        public void bind( ModelCatalog modelCatalog ) {
            currentModelCatalog = modelCatalog;
            s = pref.getBoolean ( String.valueOf ( modelCatalog.getId () ), true );

            // Получение данных и их установка на модели
            textNameBrand.setText ( modelCatalog.getBrand () );
            textDescBrand.setText ( modelCatalog.getTitle () );
            String price=String.valueOf ( modelCatalog.getPrice () );
            textPriceBrand.setText ( price + " ₽" );
            String url=modelCatalog.getImageLink ();
            Picasso.with ( itemView.getContext () )
                    .load ( url )
                    .into ( imageBrand );


            if(pref.getBoolean ( String.valueOf ( currentModelCatalog.getId () ), false )){
                imageLike.setImageResource ( R.drawable.heart_like );
            }else {
                imageLike.setImageResource ( R.drawable.heart_unlike );
            }

        }


        public void saveData(String id, boolean dataToSave){
            SharedPreferences.Editor editor = pref.edit ();
            editor.putBoolean ( id, dataToSave );
            editor.apply ();
        }

    }

}

