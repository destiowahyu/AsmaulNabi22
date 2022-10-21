package com.example.asmaulnabi22;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AsmaulNabiAdapter.ItemClickListener{
    private RecyclerView recyclerView;
    private AsmaulNabiAdapter adapter;
    private ArrayList<AsmaulNabi> asmaulArrayList;
    private String KEY_JUDUL="JUDUL";
    private String KEY_GAMBAR="gambar";
    int gambar[] = {R.drawable.kitab, R.drawable.an2,
            R.drawable.an3, R.drawable.an4,
            R.drawable.an5,R.drawable.an6,R.drawable.an7,R.drawable.an8,
            R.drawable.an9,R.drawable.an10,R.drawable.an11};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        recyclerView = (RecyclerView)
                findViewById(R.id.recycler_view);
        adapter = new AsmaulNabiAdapter(asmaulArrayList);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }
    public void onClick(View view, int position) {
        final AsmaulNabi mhs =
                asmaulArrayList.get(position);
        switch (view.getId()) {
            case R.id.txt_nama:{
                TextView text2 = (TextView)
                        view.findViewById(R.id.txt_nama);
                String judul=text2.getText().toString();
                ImageView img=(ImageView)
                        view.findViewById(R.id.img_card);
                int gbr=gambar[position];
                Intent i=new
                        Intent(MainActivity.this,DetailActivity.class);
                i.putExtra(KEY_JUDUL, judul);
                i.putExtra(KEY_GAMBAR,gbr);
                startActivity(i);
                break;}
            case R.id.img_card:{
                String judul=mhs.getNama();
                ImageView img=(ImageView)
                        view.findViewById(R.id.img_card);
                int gbr=gambar[position];
                Intent i=new
                        Intent(MainActivity.this,DetailActivity.class);
                i.putExtra(KEY_JUDUL, judul);
                i.putExtra(KEY_GAMBAR,gbr);
                startActivity(i);
                break;}
            default:
        }
    }
    void addData(){
        asmaulArrayList = new ArrayList<>();
        asmaulArrayList.add(new AsmaulNabi("Halaman 1", 0));
        asmaulArrayList.add(new AsmaulNabi("Halaman 2", 1));
        asmaulArrayList.add(new AsmaulNabi("Halaman 3", 2));
        asmaulArrayList.add(new AsmaulNabi("Halaman 4", 3));
        asmaulArrayList.add(new AsmaulNabi("Halaman 5", 4));
        asmaulArrayList.add(new AsmaulNabi("Halaman 6", 5));
        asmaulArrayList.add(new AsmaulNabi("Halaman 7", 6));
        asmaulArrayList.add(new AsmaulNabi("Halaman 8", 7));
        asmaulArrayList.add(new AsmaulNabi("Halaman 9", 8));
        asmaulArrayList.add(new AsmaulNabi("Halaman 10",
                9));
        asmaulArrayList.add(new AsmaulNabi("Halaman 11",
                10));

    }
}