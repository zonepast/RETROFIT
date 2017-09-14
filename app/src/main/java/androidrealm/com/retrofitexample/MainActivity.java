package androidrealm.com.retrofitexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ImageView imageView;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }






    private void initViews() {

        recyclerView=(RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        loadJSON();
        }

    private void loadJSON() {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://27.109.20.118/SilverPixelz/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<ProductResponse>> call = request.getJSON();
        call.enqueue(new Callback<List<ProductResponse>>() {

            @Override
            public void onResponse(retrofit2.Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                List<ProductResponse> jsonResponse = response.body();
                adapter = new DataAdapter(jsonResponse,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<ProductResponse>> call, Throwable t) {

            }
        });
    }
}