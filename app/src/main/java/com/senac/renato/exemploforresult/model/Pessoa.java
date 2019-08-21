package com.senac.renato.exemploforresult.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private DadoPessoal dadoPessoal;
    private Endereco endereco;
    private Contato contato;

    public Pessoa() {
    }

    public Pessoa(DadoPessoal dadoPessoal, Endereco endereco, Contato contato) {
        this.dadoPessoal = dadoPessoal;
        this.endereco = endereco;
        this.contato = contato;
    }

    public DadoPessoal getDadoPessoal() {
        return dadoPessoal;
    }

    public void setDadoPessoal(DadoPessoal dadoPessoal) {
        this.dadoPessoal = dadoPessoal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return dadoPessoal.toString()+"\n"+endereco.toString()+"\n"+contato.toString();
    }


}
