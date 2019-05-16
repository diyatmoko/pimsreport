package com.firstresources.pimsfa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.firstresources.pimsfa.contract.FAHarianContract;
import com.firstresources.pimsfa.helper.DBHelper;
import com.firstresources.pimsfa.model.ReportFAHarian;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 13/05/2019
 */
public class RptFAHarian extends AppCompatActivity implements FAHarianContract.View, AdapterView.OnItemSelectedListener {

    private DBHelper dbHelper;
    private List<String> listLocation;
    private List<String> listAfdeling;

    @BindView (R.id.btnGenerate)
    Button btnGenerate;
    @BindView(R.id.sp_location)
    Spinner sp_location;
    @BindView(R.id.sp_afdeling)
    Spinner sp_afdeling;
    @BindView(R.id.toolbar) Toolbar toolbar;


    @Override
    public void initViews() {
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnGenerate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intentNewFinger = new Intent(getBaseContext(), RptFAHarian.class);
                startActivity(intentNewFinger);
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rpt_fa_harian);
        initViews();
        dbHelper = new DBHelper(this);
        loadSpinner();

    }

    private void loadSpinner() {
        listLocation = new ArrayList<String>();
        listAfdeling = new ArrayList<String>();

        //Location
        List<ReportFAHarian> locationList = dbHelper.getAllLocation();

        for(int i =0; i<locationList.size();i++){
            listLocation.add(locationList.get(i).getLocationDesc());
        }
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listLocation);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_location.setAdapter(locationAdapter);

        //Afdeling
        List<ReportFAHarian> afdelingList = dbHelper.getAllAfdeling();

        for(int i =0; i<afdelingList.size();i++){
            listAfdeling.add(afdelingList.get(i).getAfdelingDesc());
        }
        ArrayAdapter<String> afdelingAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listAfdeling);
        afdelingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_afdeling.setAdapter(afdelingAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
