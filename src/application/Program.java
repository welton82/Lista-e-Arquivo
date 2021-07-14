package application;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException, IOException {
        Scanner scan = new Scanner(System.in);

        operacao(scan);
        System.out.println("Valeww!!!");

    }


    public static void operacao(Scanner scan) throws ParseException, IOException {


        boolean bContinue = true;

        Pessoa pessoa = new Pessoa();

        while(bContinue){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            int op = menu(scan);
            switch(op){

                case 1:
                    System.out.print("Nome: ");
                    pessoa.setNome(scan.nextLine());
                    System.out.print("CPF: ");

                    pessoa.setCpf(scan.next());
                    scan.nextLine();
                    System.out.print("Data de Nascimento: ");

                    pessoa.setDataNascimento(scan.nextLine());
                    pessoa.adicionarLista(pessoa);
                    break;
                case 2:
                    System.out.println(pessoa.toString());
                    System.out.println("======");
                    System.out.println(pessoa.getLista());
                    break;
                case 3:
                    System.out.println("Gerando arquivo");
                    System.out.print("Informe Pasta e caminho para Salvar Arquivo: ");
                    String path = scan.next();
                    String[] lines = {pessoa.toString()};

                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

                        for(String l: lines){
                            bw.write(l);
                            bw.newLine();
                        }

                        System.out.println("Criado com sucesso");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Ler Arquivo Gerado");
                    try {
                        BufferedReader br = null;
                        FileReader fr = null;

                        System.out.print("Qual Arquivo deseja Ler? ");
                        String file = scan.next();

                        fr = new FileReader(file);
                        br = new BufferedReader(fr);

                        String line = br.readLine();
                        while(line != null){
                            System.out.println(line);
                            line = br.readLine();
                        }


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    bContinue = false;

                    break;
            }

        }



    }

    public static int menu(Scanner scan){
        System.out.println(" MENU ");
        System.out.println("\n1 - Inserir Pessoa na Lista");
        System.out.println("2 - Listagem");
        System.out.println("3 - Gerar arquivo FILE");
        System.out.println("4 - Ler Arquivo Gerado");
        System.out.println("5 - Sair");
        System.out.print("Opção: ");
        int op = scan.nextInt();
        scan.nextLine();
        return op;


    }
}

//======================================================================================