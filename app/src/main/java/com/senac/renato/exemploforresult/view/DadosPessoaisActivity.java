package com.senac.renato.exemploforresult.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.control.DadosPessoaisControl;
import com.senac.renato.exemploforresult.model.DadoPessoal;

public class DadosPessoaisActivity extends Activity {
    private DadosPessoaisControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);
        control = new DadosPessoaisControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }
}
