package com.example.alexander.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MyActivity extends Activity {


    String[] names = { "Alex Alexanders", "John Jones", "Ann Anderson", "Ammy Nobodyknows" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        android.widget.Button myButton = (android.widget.Button)findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // из MainActivity в RegistrationActivity
                Intent intent = new Intent(MyActivity.this, MySecondActivity.class);
                startActivity(intent);
            }
        });


        // находим список
        ListView lvMyAct = (ListView) findViewById(R.id.listView);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, names);

        // присваиваем адаптер списку
        lvMyAct.setAdapter(adapter);


        lvMyAct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = null;
                switch(position)
                {
                    case 0:
                    {
                        intent = new Intent(MyActivity.this, AlexActivity.class);
                        break;
                    }
                    case 1:
                    {
                        intent = new Intent(MyActivity.this, JohnsActivity.class);
                        break;
                    }
                    case 2:
                    {
                        intent = new Intent(MyActivity.this, AnnActivity.class);
                        break;
                    }
                    case 3:
                    {
                        intent = new Intent(MyActivity.this, AmmyActivity.class);
                        break;
                    }
                }

                startActivity(intent);


            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
