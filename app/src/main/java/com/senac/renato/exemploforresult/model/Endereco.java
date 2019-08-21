package com.senac.renato.exemploforresult.model;

import java.io.Serializable;

public class Endereco implements Serializable{
    private String cep;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cep, String cidade, String uf) {
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        String res = "CEP: " + cep + "\n";
        res += "Cidade:" + cidade + "\n";
        res += "UF: " + uf;
        return res;
    }
}
