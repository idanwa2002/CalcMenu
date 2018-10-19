package com.example.idan.calcmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {       double x1;
    double x2;
    Button b1;
    EditText et;
    EditText et1;
    RadioButton rb1, rb2;
    int j;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        et1 = (EditText) findViewById(R.id.et1);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        b1 = (Button) findViewById(R.id.b1);
    }






    public void c(View view) {
        if ((et1.getText().toString().equals("")) || (et1.getText().toString().equals(".-")) || ((et1.getText().toString().equals(".")) || (et1.getText().toString().equals("-")) || (et1.getText().toString().equals("-."))) ||
                ((et.getText().toString().equals("")) || (et.getText().toString().equals(".-")) || ((et1.getText().toString().equals(".")) || (et.getText().toString().equals("-")) || (et.getText().toString().equals("-.")))))

            Toast.makeText(this, "Error - Enter a valid number", Toast.LENGTH_SHORT).show();

        else {
            String s1 = et.getText().toString();
            x1 = Double.parseDouble(s1);
            String s2 = et1.getText().toString();
            x2 = Double.parseDouble(s2);
            if ((!rb1.isChecked()) && (!rb2.isChecked()))
                Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
            else {
                if (rb1.isChecked())
                    j = 1;
                else {
                    j = 0;
                }
            }
        }
        i = new Intent(this, Main2Activity.class);
        i.putExtra("button", j);
        i.putExtra("cal", x1);
        i.putExtra("dif", x2);
        startActivity(i);

    }
}
