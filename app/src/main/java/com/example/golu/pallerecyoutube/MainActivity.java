package com.example.golu.pallerecyoutube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onSelectCategory(View view){

        String category = "";

        if(view.getId() == R.id.layout_csharpfreshers) {
            category = "csharpFreshers";

        }

        else if(view.getId() ==  R.id.layout_csharpProf){
            category = "csharpProf";
        }
        else if(view.getId() == R.id.layout_sql)
        {
            category = "sql";
        }

        //pass the category selected to next activity
        Intent i = new Intent(MainActivity.this,List.class);
        i.putExtra("id",category);
        startActivity(i);

    }


}
