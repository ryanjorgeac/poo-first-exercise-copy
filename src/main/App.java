package br.ufpb.dcx.aps.atividades.atvXX;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] argsadd){

        ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo ao Sistema Acadêmico de POO.");
        System.out.println("Vamos começar com o cadastro de disciplinas.");


        boolean continuarDisci = true;

        while (continuarDisci) {
            System.out.println("Digite o código e o nome de uma disciplina:");
            System.out.print("Código: ");
            String codigo = input.nextLine();

            System.out.print("Nome: ");
            String nome = input.nextLine();

            Disciplina disciplinaASerCadastrada = new Disciplina(codigo, nome);
            listaDisciplinas.add(disciplinaASerCadastrada);

            System.out.println("Deseja continuar? (s/n)");

            if (input.nextLine().equals("n")) {
                continuarDisci = false;
            }
        }

        boolean continuarTurmas = true;

        System.out.println("Vamos cadastrar turmas para as disciplinas:");

        while(continuarTurmas) {
            System.out.println("Escolha uma disciplina:");

            for (Disciplina i : listaDisciplinas) {
                System.out.println(i.codigo + " - " + i.nome);
            }

            String escolhaDisciplina = input.nextLine();
            Disciplina disciplinaEscolhidaFor = new Disciplina();
            for (Disciplina d : listaDisciplinas) {
                if (escolhaDisciplina.equals(d.codigo)) {
                    System.out.println("Disciplina escolhida: " + d.nome + " - " + d.codigo);
                    disciplinaEscolhidaFor = d;
                    break;
                }
            }

            Turma novaTurma = new Turma(0);
            if (disciplinaEscolhidaFor.Turmas.isEmpty() && disciplinaEscolhidaFor.nome.length() > 1){
                novaTurma.id = 1;
                disciplinaEscolhidaFor.Turmas.add(novaTurma);
                System.out.println("Turma "+ novaTurma.id + " criada com sucesso.");
            } else if (disciplinaEscolhidaFor.Turmas.isEmpty() && disciplinaEscolhidaFor.nome.isBlank()) {
                System.out.println("Disciplina não encontrada.");

            } else {
                novaTurma.id = disciplinaEscolhidaFor.Turmas.size() + 1;
                disciplinaEscolhidaFor.Turmas.add(novaTurma);
                System.out.println("Turma "+ novaTurma.id + " criada com sucesso.");
            }



            System.out.println("Deseja continuar? (s/n)");

            if (input.nextLine().equals("n")) {
                continuarTurmas = false;
            }

        }

        System.out.println("Vamos matricular alunos: ");

        boolean continuarAlunos = true;
        while(continuarAlunos) {
            System.out.println("Escolha uma disciplina:");
            for (Disciplina i : listaDisciplinas) {
                System.out.println(i.codigo + " - " + i.nome);
            }

            String escolhaDisciplina2 = input.nextLine();
            Disciplina disciplinaEscolhida3 = new Disciplina();

            for (Disciplina d : listaDisciplinas) {
                if (escolhaDisciplina2.equals(d.codigo)) {
                    System.out.println("Disciplina escolhida: " + d.nome + " - " + d.codigo);
                    disciplinaEscolhida3 = d;
                    break;
                }
            }

            if (disciplinaEscolhida3.Turmas.isEmpty() && disciplinaEscolhida3.nome.isBlank()) {
                System.out.println("Disciplina não encontrada");
            } else if (disciplinaEscolhida3.Turmas.isEmpty()) {
                System.out.println("Não há turmas para essa disciplina.");
            }else {
                System.out.println("Escolha uma turma:");
                for (Turma t : disciplinaEscolhida3.Turmas){
                    System.out.println("Turma " + t.id);
                }
                String escolhaTurma = input.nextLine();
                Turma turmaEscolhida = new Turma(0);
                for (Turma t : disciplinaEscolhida3.Turmas) {
                    int escolha = Integer.parseInt(escolhaTurma);
                    if (escolha == t.id) {
                        turmaEscolhida = t;
                        System.out.println("Turma escolhida: " + turmaEscolhida.id);
                    }
                }

                if (disciplinaEscolhida3.Turmas.contains(turmaEscolhida)) {
                    System.out.println("Nome do aluno: ");
                    String nomeDoAluno = input.nextLine();
                    System.out.println("Matrícula: ");
                    String matriculaDoAluno = input.nextLine();
                    Aluno novoAluno = new Aluno(matriculaDoAluno, nomeDoAluno);
                    if (nomeDoAluno.isBlank()) {
                        System.out.println("Faltou o nome do aluno. Tente novamente.");

                    } else if (matriculaDoAluno.isBlank()){
                        System.out.println("Faltou a matrícula do aluno. Tente novamente.");

                    } else if (nomeDoAluno.isBlank() && matriculaDoAluno.isBlank()){
                        System.out.println("Nome e matrícula em branco. Tente novamente.");

                    } else {
                        turmaEscolhida.listaDeAlunos.add(novoAluno);
                        System.out.println("Aluno matrículado.");
                    }
                } else {
                    System.out.println("Turma inexistente. Digite apenas o número da turma.");
                }


            }



            System.out.println("Deseja continuar? (s/n)");

            if (input.nextLine().equals("n")) {
                continuarAlunos = false;
            }
        }

        System.out.println("\nTodos os alunos cadastrados: \n");
        for (Disciplina d : listaDisciplinas) {
            for (Turma t: d.Turmas) {
                System.out.println("Alunos cadastrados na Turma " + t.id + " de " + d.nome + ":");
                for (Aluno a : t.listaDeAlunos) {
                    System.out.println(a.nomeAluno + " - " +  a.matricula);
                }
                System.out.println();
            }
        }
        System.out.println("\nFim do programa.");
        input.close();
    }
}
