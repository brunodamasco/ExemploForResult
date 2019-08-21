package com.senac.renato.exemploforresult.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.control.ContatoControl;

public class ContatoActivity extends Activity {
    private ContatoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        control = new ContatoControl(this);
    }

    public void enviar(View view) {
        control.enviarAction();
    }

    public void cancelar(View view) {
        control.cancelarAction();
    }
}
