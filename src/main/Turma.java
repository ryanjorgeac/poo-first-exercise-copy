package br.ufpb.dcx.aps.atividades.atvXX;

import java.util.ArrayList;

public class Turma {

    public int id;
    public ArrayList<Aluno> listaDeAlunos;

    public Turma(int id) {
        this.id = id;
        this.listaDeAlunos = new ArrayList<>();
    }

    public Turma(int id, ArrayList listaDeAlunos) {
        this.id = id;
        this.listaDeAlunos = listaDeAlunos;
    }


}
