package com.senac.renato.exemploforresult.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.control.MainControl;

public class MainActivity extends Activity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }
    public void telaEndereco(View v){
        control.telaEnderecoAction();
    }

    public void telaDadosPessoais(View v){
        control.telaDadosPessoaisAction();
    }

    public void telaContato(View view) {
        control.telaContatoAction();
    }

    public void telaResultado(View v){
        control.enviarAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
