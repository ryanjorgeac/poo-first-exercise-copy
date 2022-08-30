package br.ufpb.dcx.aps.atividades.atvXX;

import java.util.ArrayList;

public class Disciplina {

    public String codigo;
    public String nome;
    public ArrayList<Turma> Turmas;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.Turmas = new ArrayList<>();
    }
    public Disciplina() {
        this.nome = "";
        this.Turmas = new ArrayList<>();
    }

    public String toString(){
        return "Código: "+ this.codigo + "\n" + "Nome:" + this.codigo;
    }
}
