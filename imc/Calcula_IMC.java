package imc;

import java.util.Calendar;
import java.util.Scanner;

public class Calcula_IMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[10];
        int quantidadePessoas = 0;

        while (quantidadePessoas < 10) {
            Pessoa pessoa = new Pessoa();

            System.out.print("Digite o nome da pessoa:");
            String nome = scanner.nextLine();
            pessoa.setNome(nome);

            System.out.print("Digite o sobrenome da pessoa:");
            String sobrenome = scanner.nextLine();
            pessoa.setSobrenome(sobrenome);

            System.out.print("Digite a data de nascimento (formato: dia/mês/ano):");
            String dataNascimentoStr = scanner.nextLine();
            String[] dataNascimentoParts = dataNascimentoStr.split("/");
            int dia = Integer.parseInt(dataNascimentoParts[0]);
            int mes = Integer.parseInt(dataNascimentoParts[1]);
            int ano = Integer.parseInt(dataNascimentoParts[2]);

            Data dataNascimento = new Data();
            dataNascimento.setDia(dia);
            dataNascimento.setMes(mes);
            dataNascimento.setAno(ano);

            pessoa.setDataNascimento(dataNascimento);

            System.out.print("Digite o peso (em kg):");
            double peso = scanner.nextDouble();
            pessoa.setPeso(peso);

            System.out.print("Digite a altura (em metros):");
            double altura = scanner.nextDouble();
            pessoa.setAltura(altura);

            scanner.nextLine(); 

            boolean mesmoNome = false;
            if (quantidadePessoas > 0) {
                Pessoa pessoaAnterior = pessoas[quantidadePessoas - 1];
                if ((pessoa.getNome() + pessoa.getSobrenome()).equalsIgnoreCase(pessoaAnterior.getNome() + pessoaAnterior.getSobrenome())) {
                    mesmoNome = true;
                }
            }

            if (mesmoNome) {
                break;
            }

            pessoas[quantidadePessoas] = pessoa;
            quantidadePessoas++;
        }

        for (int i = 0; i < quantidadePessoas; i++) {
            Pessoa pessoa = pessoas[i];
            Data dataAtual = new Data();
            dataAtual.setDia(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            dataAtual.setMes(Calendar.getInstance().get(Calendar.MONTH) + 1);
            dataAtual.setAno(Calendar.getInstance().get(Calendar.YEAR));

            int idade = pessoa.calculaIdade(dataAtual);
            double imc = pessoa.calculaIMC();
            String classificacaoCorporal = pessoa.getClassificacaoCorporal();

            System.out.println("Cadastro " + (i + 1) + ":");
            System.out.println("Nome completo: " + pessoa.getNome() + " " + pessoa.getSobrenome());
            System.out.println("Nome de referência: " + pessoa.getSobrenome().toUpperCase() + ", " + pessoa.getNome().toUpperCase());
            System.out.println("Idade: " + idade);
            System.out.println("Peso: " + pessoa.getPeso());
            System.out.println("Altura: " + pessoa.getAltura());
            System.out.println("IMC: " + imc);
            System.out.println("Classificação: " + classificacaoCorporal);
        }

        scanner.close();
    }
}