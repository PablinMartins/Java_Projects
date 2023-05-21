package imc;

import java.util.Calendar;

class Pessoa {
    private String nome;
    private String sobrenome;
    private Data dataNascimento;
    private double peso;
    private double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public int calculaIdade(Data dataAtual) {
        Calendar calAtual = Calendar.getInstance();
        calAtual.set(dataAtual.getAno(), dataAtual.getMes() - 1, dataAtual.getDia());

        Calendar calNascimento = Calendar.getInstance();
        calNascimento.set(dataNascimento.getAno(), dataNascimento.getMes() - 1, dataNascimento.getDia());

        int idade = calAtual.get(Calendar.YEAR) - calNascimento.get(Calendar.YEAR);
        if (calAtual.get(Calendar.MONTH) < calNascimento.get(Calendar.MONTH)
                || (calAtual.get(Calendar.MONTH) == calNascimento.get(Calendar.MONTH)
                && calAtual.get(Calendar.DAY_OF_MONTH) < calNascimento.get(Calendar.DAY_OF_MONTH))) {
            idade--;
        }
        return idade;
    }
    public double calculaIMC() {
        return peso / Math.pow(altura,2);
    }
    public String getClassificacaoCorporal() {
        double imc = calculaIMC();
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc > 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc > 25 && imc < 29.9) {
        	return "Sobrepeso";
        } else if (imc > 30 && imc < 34.9) {
            return "Obesidade grau 1";
        } else if (imc > 35 && imc < 39.9) {
        	return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }
}