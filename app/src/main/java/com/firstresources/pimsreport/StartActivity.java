package com.firstresources.pimsreport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firstresources.pimsreport.contract.FAHarianContract;
import com.firstresources.pimsreport.helper.Utils;
import com.firstresources.pimsreport.helper.DBHelper;
import com.firstresources.pimsreport.model.ReportFAHarian;
import com.firstresources.pimsreport.rest.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 13/05/2019
 */
public class StartActivity extends AppCompatActivity implements FAHarianContract.View{

    private ProgressDialog progressDialog;
    private Calendar calendar;
    private String date;
    private ApiClient apiClient;

    private DBHelper dbHelper = new DBHelper(this);
    private final String TAG = StartActivity.class.getSimpleName();

    //initialize component
    @BindView(R.id.btnSignin)
    Button btnSignin;
//    @BindView(R.id.btnSync) Button btnSync;
//    @BindView(R.id.txtSync)
//    TextView txtSync;

    @Override
    public void initViews() {
        ButterKnife.bind(this);

        calendar = Calendar.getInstance();
        date = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(calendar.getTime());

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        btnSync.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dbHelper.deleteAllTable();
//                onClickSynchronize();
//            }
//        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        initViews();
    }
    public void onClickSynchronize(){
        progressDialog = new ProgressDialog(StartActivity.this);
        progressDialog.setMessage("Synchronizing...");
        progressDialog.setTitle(R.string.str_sync);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        if(getNetworkAvailability()){
            getFAHarianJSON();
        }
        else{
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Error : No Connection",Toast.LENGTH_SHORT).show();
        }
    }
    public void getFAHarianJSON(){
        apiClient = new ApiClient();
        Call<List<ReportFAHarian>> call = apiClient.getApiInterface().getReportFAHarian();
        call.enqueue(new Callback<List<ReportFAHarian>>() {
            @Override
            public void onResponse(Call<List<ReportFAHarian>> call, Response<List<ReportFAHarian>> response) {
                if (response.isSuccessful()){
                    Log.e("successful","sukses");
                    List<ReportFAHarian> listFAHarian = response.body();
                    for (int i=0; i<listFAHarian.size(); i++){
                        ReportFAHarian reportFAHarian = listFAHarian.get(i);
                        dbHelper.addReportFAHarian(reportFAHarian);
                    }
//                    txtSync.setText("Terakhir di sinkronisasi pada : " + date);
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ReportFAHarian>> call, Throwable t) {
                progressDialog.dismiss();
                Log.e(TAG, t.toString());
            }
        });

    }
    public boolean getNetworkAvailability() {
        return Utils.isNetworkAvailable(getApplicationContext());
    }
}
