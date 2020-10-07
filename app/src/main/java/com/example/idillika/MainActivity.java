package com.example.idillika;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

    }
    // Переход на Активити Каталог
    public void onClickBtnGoCatalog( View view ){
        Intent intent = new Intent ( MainActivity.this, CatalogActivity.class );
        startActivity ( intent );
    }
}