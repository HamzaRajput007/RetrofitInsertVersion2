package com.example.m.retrofitinsert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText Id, CategoryName;
    Button SubmitBtn;
    Api_Interface mAPIService = RetrofitClient.getClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Id = findViewById(R.id.idTextBoxId);
        CategoryName = findViewById(R.id.categoryNameTextBoxId);
        SubmitBtn = findViewById(R.id.subimtBtnId);
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Id.getText() != null && CategoryName.getText() != null)
                sendPost(Id.getText().toString().trim(),CategoryName.getText().toString().trim());
                else
                    Toast.makeText(MainActivity.this, "Null References", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void sendPost(String username, String password) {
        mAPIService.savePost(username, password).enqueue(new Callback<Post>() {


            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {

//                    Log.i(TAG, "post submitted to API." + response.body().toString());
                    Toast.makeText(MainActivity.this,"post submitted to API." +response.body().toString(),Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Toast.makeText(MainActivity.this,"Unable to submit post to API." + t.toString(),Toast.LENGTH_LONG).show();
//                Log.i(TAG, "Unable to submit post to API." +t.toString());

            }
        });
}
}
