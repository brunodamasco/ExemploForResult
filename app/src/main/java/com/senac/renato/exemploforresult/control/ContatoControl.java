package com.senac.renato.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.model.Contato;
import com.senac.renato.exemploforresult.model.PessoaBO;
import com.senac.renato.exemploforresult.uteis.Constantes;


public class ContatoControl {
    private Activity activity;
    private EditText editTelefone;
    private EditText editEmail;

    public ContatoControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editTelefone = activity.findViewById(R.id.editTelefone);
        editEmail =  activity.findViewById(R.id.editEmail);
    }

    private Contato getDadosForm(){
        Contato contato = new Contato();
        contato.setEmail(editEmail.getText().toString());
        contato.setTelefone(editTelefone.getText().toString());
        return contato;
    }

    private boolean valida(Contato c){
        if(PessoaBO.validaEmail(c)){
            editEmail.setError("Email inválido");
            editEmail.requestFocus();
            return false;
        }
        if(PessoaBO.validaTelefone(c)){
            editTelefone.setError("Idade inválida");
            editTelefone.requestFocus();
            return false;
        }
        return true;
    }

    public void enviarAction(){
        Contato c = getDadosForm();
        if(valida(c)){
            Intent it = new Intent();
            it.putExtra(Constantes.PARAM_CONTATO, c);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
