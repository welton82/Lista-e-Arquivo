package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Pessoa {

    private String nome;
    private String cpf;
    private Date dataNascimento;

    SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
    List<Pessoa>lista = new ArrayList<>();
    Pessoa pessoa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws ParseException {

        Date dt = sdf.parse(dataNascimento);
        this.dataNascimento = dt;
    }

    public void adicionarLista(Pessoa p){
        this.pessoa = p;
        lista.add(pessoa);
    }

    public List<Pessoa> getLista() throws ParseException {
        for(Pessoa p: lista){
            System.out.println("Nome: " + p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Data Nascimento: " + p.getDataNascimento());
        }
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Pessoa x:lista){
            s.append("\nNome: ");
            s.append(x.getNome());
            s.append("\nCpf: ");
            s.append(x.getCpf());
            s.append("\nData de Nascimento: ");
            //obs usar format na classe para formatar "data"
            s.append(sdf.format(x.getDataNascimento()));

        }
        return s.toString();
    }
}

//==============================================================================================
