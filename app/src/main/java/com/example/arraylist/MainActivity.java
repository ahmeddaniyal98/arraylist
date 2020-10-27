package com.example.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button save;
    ListView show;
    EditText text;

    ArrayList<String> arraylist= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.btn);
        text=findViewById(R.id.inputtext);
        show=findViewById(R.id.arraylist);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getinput=text.getText().toString();

                if(arraylist.contains(getinput))
                {
                    Toast.makeText(getBaseContext(),"Items already added to list", Toast.LENGTH_LONG).show();
                }
                else if(getinput==null || getinput.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(),"Input field is empty", Toast.LENGTH_LONG).show();

                }
                else
                {
                    arraylist.add(getinput);
                    ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,arraylist);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.inputtext)).setText(" ");

                }


            }
        });

    }
}