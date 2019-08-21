package com.senac.renato.exemploforresult.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.control.EnderecoControl;

public class EnderecoActivity extends Activity {
    private EnderecoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        control = new EnderecoControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v){
        control.retornarAction();
    }
}
