package com.example.idan.calcmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {
    Intent in ;
    TextView v1;
    ListView lv1;
    int  n,r1;
    double s,x,d;
    String[] list = new String[20];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv1=(ListView) findViewById(R.id.lv1);
        v1=(TextView) findViewById(R.id.v1);

        if (getIntent()!= null){
            in= getIntent();
            r1 = in.getExtras().getInt("button", 11);
            x = in.getExtras().getDouble("cal", 9.22);
            d = in.getExtras().getDouble("dif", 9.22);
            list [0]=Double.toString(r1);
            if (r1==1) {
                for (int i = 1; i < 20; i++){
                    list[i] = Double.toString(Double.parseDouble(list[i - 1]) + d);}

            }else{
                for (int i = 1; i < 20; i++){
                    list[i] = Double.toString(Double.parseDouble(list[i - 1]) * d);}}


            lv1.setOnItemClickListener(this);
            lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            ArrayAdapter adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
            lv1.setAdapter(adp); }}


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.setOnCreateContextMenuListener(this);
        n = i + 1;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Details");
        menu.add("x1-");
        menu.add("d-");
        menu.add("n-");
        menu.add("sum-");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String s1 = item.getTitle().toString();
        if (s1.equals("sum-")){
            if (r1 == 1) {
                if (d == 1) {
                    s = x * n;
                } else {
                    s = ((x * ((Math.pow(d, n)) - 1)) / (d - 1));
                }
                return true;
            }
            if (r1 == 0){
                s = ((n * ((2 * x) + d * (n - 1))) / 2);}
            v1.setText(Double.toString(s));
            return true;}
        if (s1.equals("x1-")){
            v1.setText(Double.toString(x));
            return true;}
        if (s1.equals("d-")){
            v1.setText(Double.toString(d));
            return true;}
        if (s1.equals("n-")){
            v1.setText(Integer.toString(n));
            return true;}

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("CREDITS"))
            Toast.makeText(this, "Made by Idan Wasserblat", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    public void cc(View view) {
        Intent b = new Intent(this, MainActivity.class);
        startActivity(b);
    }
}
