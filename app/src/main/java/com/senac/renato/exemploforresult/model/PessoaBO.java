package com.senac.renato.exemploforresult.model;

public class PessoaBO {
    public static boolean validaNome(DadoPessoal d){
        return d.getNome()!=null
                && !d.getNome().isEmpty();
    }

    public static boolean validaIdade(DadoPessoal d){
        return d.getIdade()!=null
                && d.getIdade()>=0;
    }

    public static boolean validaCep(Endereco e){
        return e.getCep()!=null
                && e.getCep().length()==9;
    }

    public static boolean validaCidade(Endereco e){
        return e.getCidade()!=null
                && !e.getCidade().isEmpty();
    }

    public static boolean validaUf(Endereco e){
        return e.getUf()!=null
                && e.getUf().length()==2;
    }

    public static boolean validaEmail(Contato c){
        return c.getEmail()!=null
                && c.getEmail().isEmpty();
    }

    public static boolean validaTelefone(Contato c){
        return c.getTelefone()!=null
                && c.getTelefone().isEmpty();
    }
}
