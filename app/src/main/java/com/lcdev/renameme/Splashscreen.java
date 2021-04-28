package com.lcdev.renameme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Initialize();
        //aaa
    }
    private void Initialize()
    {
        Global.gloPFID = AuxFunctions.ReadSharedPreference(this,
                "PFID");
        if (Global.gloPFID.equals("")) {
            Global.gloPFID = AuxFunctions.CreateRandomString("AN",8);
            AuxFunctions.WriteSharedPref(this, "PFID",
                    Global.gloPFID);
        }
        Global.gloAPIURL = "http://10.0.2.2:44364/api/";
        //Global.gloAPIURL = "http://test1.mc2techservices.com/api/";
        String ShowDisclaimerTest=AuxFunctions.ReadSharedPreference(this, "DisclaimerShown");
        if (ShowDisclaimerTest.equals(""))
        {
            ShowDisclaimer();
        }
        else
        {
            SetupMainUI();
        }
    }

    private void ShowDisclaimer()
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DoShowDialogDone();
                SetupMainUI();
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Full Disclosure");
        builder.setMessage("This app is not developed by Planet Fitness." +
                "It's only function is to load instantly, getting you checked in quicker.");
        builder.setNeutralButton("OK", dialogClickListener);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void DoShowDialogDone()
    {
        AuxFunctions.WriteSharedPref(this, "DisclaimerShown","1");
    }

    private void SetupMainUI()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}