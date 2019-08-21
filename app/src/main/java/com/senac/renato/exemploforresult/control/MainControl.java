package com.senac.renato.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.senac.renato.exemploforresult.R;
import com.senac.renato.exemploforresult.model.Contato;
import com.senac.renato.exemploforresult.model.DadoPessoal;
import com.senac.renato.exemploforresult.model.Endereco;
import com.senac.renato.exemploforresult.model.Pessoa;
import com.senac.renato.exemploforresult.uteis.Constantes;
import com.senac.renato.exemploforresult.view.ContatoActivity;
import com.senac.renato.exemploforresult.view.DadosPessoaisActivity;
import com.senac.renato.exemploforresult.view.EnderecoActivity;
import com.senac.renato.exemploforresult.view.ResultadoActivity;

public class MainControl {
    private Activity activity;
    private Pessoa pessoa;
    private TextView tvTeste;

    public MainControl(Activity activity) {
        this.activity = activity;
        tvTeste = activity.findViewById(R.id.tvTeste);

        pessoa = new Pessoa();
        pessoa.setDadoPessoal(new DadoPessoal());
        pessoa.setEndereco(new Endereco());
        pessoa.setContato(new Contato());
    }

    public void telaEnderecoAction(){
        Intent it = new Intent(activity, EnderecoActivity.class);
        it.putExtra(Constantes.PARAM_ENDERECO, pessoa.getEndereco());
        activity.startActivityForResult(it, Constantes.REQUEST_ENDERECO);
    }

    public void telaDadosPessoaisAction(){
        Intent it = new Intent(activity, DadosPessoaisActivity.class);
        it.putExtra(Constantes.PARAM_DADO_PESSOAL, pessoa.getDadoPessoal());
        activity.startActivityForResult(it, Constantes.REQUEST_DADO_PESSOAL);
    }

    public void telaContatoAction(){
        Intent it = new Intent(activity, ContatoActivity.class);
        it.putExtra(Constantes.PARAM_CONTATO, pessoa.getContato());
        activity.startActivityForResult(it, Constantes.REQUEST_CONTATO);
    }

    public void enviarAction(){
        Intent it= new Intent(activity, ResultadoActivity.class);
        it.putExtra(Constantes.PARAM_PESSOA, pessoa);
        activity.startActivity(it);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==activity.RESULT_OK) {
            if (requestCode == Constantes.REQUEST_ENDERECO) {
                Endereco endereco = (Endereco)
                        data.getSerializableExtra(Constantes.PARAM_ENDERECO);
                pessoa.setEndereco(endereco);

                tvTeste.setText(endereco.toString());
            } else if (requestCode == Constantes.REQUEST_DADO_PESSOAL) {
                DadoPessoal dadosPessoais = (DadoPessoal)
                        data.getSerializableExtra(Constantes.PARAM_DADO_PESSOAL);
                pessoa.setDadoPessoal(dadosPessoais);

                tvTeste.setText(dadosPessoais.toString());
            }
            if (requestCode == Constantes.REQUEST_CONTATO) {
                Contato contato = (Contato)
                        data.getSerializableExtra(Constantes.PARAM_CONTATO);
                pessoa.setContato(contato);
                tvTeste.setText(contato.toString());
            }
        }else if(resultCode==activity.RESULT_CANCELED){
            Toast.makeText(activity, "Operação cancelada", Toast.LENGTH_SHORT).show();
        }
    }
}
