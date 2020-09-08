package com.buildwithsiele.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {
    private EditText etFirstName,etLastName,etEmail,etGithubLink;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mGithubLink;
    private AlertDialog mDialog;


    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etGithubLink = findViewById(R.id.etGithubLink);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        Toolbar toolbar = findViewById(R.id.toolbar_submit);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(view -> {


        });

        btnSubmit.setOnClickListener(view -> submitDetails());
    }

    private void submitDetails() {
        verifyInputs();
    }

    private void verifyInputs() {
        mFirstName = etFirstName.getText().toString();
        mLastName = etLastName.getText().toString();
        mEmail = etEmail.getText().toString();
        mGithubLink = etGithubLink.getText().toString();

        if (mFirstName.isEmpty()){
            etFirstName.setError("Can't be empty");
            etFirstName.requestFocus();
            if (mLastName.isEmpty()){
            etLastName.setError("Can't be empty");
            etLastName.requestFocus();
            if (mEmail.isEmpty()){
                etEmail.setError("Can't be empty");
                etEmail.requestFocus();
                if (mGithubLink.isEmpty()){
                    etGithubLink.setError("Can't be empty");
                    etGithubLink.requestFocus();
                }
            }
        }
        }else{
            Toast.makeText(this, ("Name: "+mFirstName+" " +mLastName +"\n"+"Email: " + mEmail +"\n"+ "Github Link: "+ mGithubLink), Toast.LENGTH_SHORT).show();
            showConfirmDialog();
        }

    }

    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.confirm_submit,null);
        builder.setView(view)
                .setCancelable(false);
        Button btnYes = view.findViewById(R.id.btnYes);
        ImageView close = view.findViewById(R.id.cancelSubmit);
        btnYes.setOnClickListener(view1 -> {
            submitResponse();

        });
        close.setOnClickListener(view2 ->{
            showFailDialog();
        } );
        mDialog = builder.create();
        mDialog.show();
    }

    private void submitResponse() {
        ApiInterface apiService = ApiClient.sendResponse().create(ApiInterface.class);
        Call<Void> call = apiService.sendResponse(mFirstName,mLastName,mEmail,mGithubLink);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call,@NonNull Response<Void> response) {
                if (response.isSuccessful()){
                    showSuccessDialog();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                showFailDialog();
            }
        });
    }

    private void showSuccessDialog() {
        mDialog.hide();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.submit_successful,null);
        builder.setView(view)
                .setCancelable(true);
        builder.create().show();
    }
    private void showFailDialog() {
        mDialog.hide();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.submit_unsuccessful,null);
        builder.setView(view)
                .setCancelable(true);
        builder.create().show();
    }
}