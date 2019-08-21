package com.senac.renato.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.model.Endereco;
import com.senac.renato.exemploforresult.model.PessoaBO;
import com.senac.renato.exemploforresult.uteis.Constantes;

public class EnderecoControl {
    private Activity activity;
    private EditText editCep;
    private EditText editCidade;
    private EditText editUf;

    public EnderecoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        carregarForm();
    }

    private void carregarForm(){
        try {
            Endereco endereco = (Endereco)
                    activity.getIntent().getSerializableExtra(Constantes.PARAM_ENDERECO);
            editCep.setText(endereco.getCep());
            editCidade.setText(endereco.getCidade());
            editUf.setText(endereco.getUf());
        } catch (Exception e){

        }
    }

    public void initComponents(){
        editCep = activity.findViewById(R.id.editCep);
        editCidade = activity.findViewById(R.id.editCidade);
        editUf = activity.findViewById(R.id.editUf);
    }

    private Endereco getDadosForm(){
        Endereco endereco = new Endereco();
        endereco.setCep(editCep.getText().toString());
        endereco.setCidade(editCidade.getText().toString());
        endereco.setUf(editUf.getText().toString());
        return endereco;
    }

    private boolean valida(Endereco e){
        if(!PessoaBO.validaCep(e)){
            editCep.setError("CEP inválido");
            editCep.requestFocus();
            return false;
        }
        if(!PessoaBO.validaCidade(e)){
            editCidade.setError("Cidade inválida");
            editCidade.requestFocus();
            return false;
        }
        if(!PessoaBO.validaUf(e)){
            editUf.setError("UF inválida");
            editUf.requestFocus();
            return false;
        }
        return true;
    }

    public void enviarAction(){
        Endereco endereco = getDadosForm();

        if(valida(endereco)) {
            //Montagem da variável com os dados
            Intent it = new Intent();
            it.putExtra(Constantes.PARAM_ENDERECO, endereco);

            //Enviar para activity chamadora
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void retornarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
