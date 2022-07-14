package com.example.calculadora;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewOp extends AppCompatActivity {

    private ArrayList<OpModal> opModalArrayList;
    private DBHandler dbHandler;
    private OpRVAdpt opRVAdpt;
    private RecyclerView opRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_op);

        opModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewOp.this);

        opModalArrayList = dbHandler.readOp();

        opRVAdpt = new OpRVAdpt(opModalArrayList, ViewOp.this);
        opRV = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewOp.this, RecyclerView.VERTICAL, false);
        opRV.setLayoutManager(linearLayoutManager);

        opRV.setAdapter(opRVAdpt);
    }
}