package com.senac.renato.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.model.DadoPessoal;
import com.senac.renato.exemploforresult.model.PessoaBO;
import com.senac.renato.exemploforresult.uteis.Constantes;

public class DadosPessoaisControl {
    private Activity activity;
    private EditText editNome;
    private EditText editIdade;

    public DadosPessoaisControl(Activity activity) {
        this.activity = activity;
        initComponents();
        carregarForm();
    }

    private void initComponents(){
        editNome = activity.findViewById(R.id.editNome);
        editIdade = activity.findViewById(R.id.editIdade);
    }

    private void carregarForm(){
        try {
            DadoPessoal dadoPessoal = (DadoPessoal)
                    activity.getIntent().getSerializableExtra(Constantes.PARAM_DADO_PESSOAL);
            editNome.setText(dadoPessoal.getNome());
            if (editIdade==null){
                editIdade.setText(String.valueOf(dadoPessoal.getIdade()));
            }

        } catch (Exception e){

        }
    }

    private DadoPessoal getDadosForm(){
        DadoPessoal dadoPessoal = new DadoPessoal();
        dadoPessoal.setIdade(editIdade.getText().toString());
        dadoPessoal.setNome(editNome.getText().toString());
        return dadoPessoal;
    }

    private boolean valida(DadoPessoal d){
        if(!PessoaBO.validaNome(d)){
            editNome.setError("Nome inválido");
            editNome.requestFocus();
            return false;
        }
        if(!PessoaBO.validaIdade(d)){
            editIdade.setError("Idade inválida");
            editIdade.requestFocus();
            return false;
        }
        return true;
    }

    public void enviarAction(){
        DadoPessoal dp = getDadosForm();
        if(valida(dp)){
            Intent it = new Intent();
            it.putExtra(Constantes.PARAM_DADO_PESSOAL, dp);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }

}
