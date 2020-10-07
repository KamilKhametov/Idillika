package com.example.idillika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;

import android.widget.ImageView;
import android.widget.TextView;


import com.example.idillika.API.ModelCatalog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_basket );

        // Закрепление actionBar
        actionBarAttach ();
        

    }

    public void actionBarAttach(){
        // Установка заголовка на actionBar
        getSupportActionBar ().setTitle ( Html.fromHtml ( "<font color='#000'>КОРЗИНА</font>" ) );
        // Установка иконки "Назад" на actionBar
        getSupportActionBar ().setHomeAsUpIndicator ( R.drawable.ic_line_back );
        // Позволяет возвращаться на прошлый активити
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
    }


}