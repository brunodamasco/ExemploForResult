package com.senac.renato.exemploforresult.model;

import java.io.Serializable;

public class Contato implements Serializable {
    private String telefone;
    private String email;

    public Contato() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String res = "E-mail: " + email + "\n";
        res += "Telefone:" + telefone + "\n";
        return res;
    }
}
