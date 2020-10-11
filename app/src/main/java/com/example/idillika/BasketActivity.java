package com.example.idillika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.idillika.API.ModelCatalog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    Button btnGoFromBasket;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_basket );

        // Закрепление actionBar
        actionBarAttach ();
        init ();
        btnOnClickFromBasket ();


    }

    public void actionBarAttach(){
        // Установка заголовка на actionBar
        getSupportActionBar ().setTitle ( Html.fromHtml ( "<font color='#000'>КОРЗИНА</font>" ) );
        // Установка иконки "Назад" на actionBar
        getSupportActionBar ().setHomeAsUpIndicator ( R.drawable.ic_line_back );
        // Позволяет возвращаться на прошлый активити
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
    }

    public void init(){
        btnGoFromBasket = findViewById ( R.id.btnGoFromBasket );
    }


    public void btnOnClickFromBasket(){
        btnGoFromBasket.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent ( BasketActivity.this, CatalogActivity.class );
                startActivity ( intent );
            }
        } );
    }



}