package com.senac.renato.exemploforresult.view;

import android.app.Activity;
import android.os.Bundle;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.control.ResultadoControl;

public class ResultadoActivity extends Activity {
    private ResultadoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
    }
}
