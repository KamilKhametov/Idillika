package com.example.idillika;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;


import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.idillika.API.APIConfig;
import com.example.idillika.API.APIRetrofitConstructor;
import com.example.idillika.API.APIService;
import com.example.idillika.API.ModelCatalog;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager = new GridLayoutManager ( this, 2 );
    AdapterCatalog adapterCatalog;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_catalog );

        onAttachActionBar ();

        APIService apiService = APIRetrofitConstructor.CreateService ( APIService.class );
        Call<List<ModelCatalog>> call = apiService.getData ( APIConfig.section, APIConfig.session_id );
        call.enqueue ( new Callback<List<ModelCatalog>> () {
            @Override
            public void onResponse( Call<List<ModelCatalog>> call, Response<List<ModelCatalog>> response ) {
                if(response.isSuccessful ()){
                    List<ModelCatalog> catalogList = response.body ();

                    recyclerView = findViewById ( R.id.recyclerView );


                    adapterCatalog = new AdapterCatalog ( catalogList );
                    recyclerView.setLayoutManager ( layoutManager );
                    recyclerView.setHasFixedSize ( true );
                    recyclerView.setAdapter ( adapterCatalog );
                }
            }

            @Override
            public void onFailure( Call<List<ModelCatalog>> call, Throwable t ) {

            }
        } );



    }

    // Установка иконки "Корзина" на actionBar
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater menuInflater=getMenuInflater ();
        menuInflater.inflate ( R.menu.basket_in_action_bar, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        // Получение id
        int id=item.getItemId ();

        // сравнивание id, что делать при нажатии на иконку "Корзина"
        if (id == R.id.action_cart) {
            Intent intent = new Intent ( CatalogActivity.this, BasketActivity.class );
            startActivity ( intent );
        }
        return true;
    }


    public void onAttachActionBar(){
        // Установка заголовка на actionBar
        getSupportActionBar ().setTitle( Html.fromHtml( "<font color='#000'>ОДЕЖДА</font>"));
        // Установка иконки "Назад" на actionBar
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_line_back);
        // Позволяет возвращаться на прошлый активити
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




}