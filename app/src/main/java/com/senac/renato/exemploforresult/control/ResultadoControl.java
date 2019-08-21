package com.senac.renato.exemploforresult.control;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.model.Pessoa;
import com.senac.renato.exemploforresult.uteis.Constantes;

public class ResultadoControl {
    private Activity activity;
    private TextView tvResultado;
    private ImageView ivResultado;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResultado();
    }

    private void initComponents(){
        tvResultado = activity.findViewById(R.id.tvResultado);
        ivResultado = activity.findViewById(R.id.ivResultado);
    }

    private void showResultado(){
        //Resgatar pessoa passada como parâmetro
        Pessoa p = (Pessoa) activity.getIntent().getSerializableExtra(
                Constantes.PARAM_PESSOA
        );
        tvResultado.setText(p.toString());
        if(p.getDadoPessoal().getIdade()>=18){
            ivResultado.setImageResource(R.drawable.adulto);
        } else {
            ivResultado.setImageResource(R.drawable.crianca);
        }
    }
}
