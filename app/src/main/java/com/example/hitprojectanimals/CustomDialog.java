package com.example.hitprojectanimals;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import java.security.AccessControlContext;

public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_update_lay);
    }
}
