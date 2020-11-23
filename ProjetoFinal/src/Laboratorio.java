import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Laboratorio {

    private ArrayList <Exame> exames;

    public Laboratorio() {
        this.exames = new ArrayList<>();
    }

    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Digite " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public RaioX leRaioX() {
        String [] valores = new String [4];
        String [] nomeVal = {"Nome Paciente", "Codigo Exame", "Preparo", "Liberação"};
        valores = leValores (nomeVal);

        RaioX exameRaioX = new RaioX (valores[0],valores[1],valores[2], valores[3]);
        return exameRaioX;

    }

    public Sangue leSangue() {
            String [] valores = new String [3];
            String [] nomeVal = {"Nome Paciente", "Codigo Exame", "Preparo"};
            valores = leValores (nomeVal);

            Sangue exameSangue = new Sangue (valores[0],valores[1],valores[2]);
            return exameSangue ;

        }

    public Tomografia leTomografia() {
            String [] valores = new String [4];
            String [] nomeVal = {"Nome Paciente", "Codigo Exame", "Liberação", "Contraste"};
            valores = leValores (nomeVal);

            Tomografia exameTomografia = new Tomografia (valores[0],valores[1],valores[2], valores[3]);
            return exameTomografia;

        }


    public void mostraExame(String dados) {
        JOptionPane.showMessageDialog(null,"Exame\n-------\n +" +dados);

    }

    public void salvaExames() {
        ObjectOutputStream outputStream = null;
        try{
            outputStream = new ObjectOutputStream (new FileOutputStream("exames.dat"));
            for(Exame exame:exames){
                outputStream.writeObject(exame);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (outputStream != null){
                    outputStream.flush();
                    outputStream.close();
                }

            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }


    public void recuperarExames(){
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream("exames.dat"));

            Object obj = null;

            while ((obj = inputStream.readObject()) != null) {

                if(obj instanceof Sangue)
                    this.exames.add((Sangue) obj);
                else if(obj instanceof RaioX)
                    this.exames.add((RaioX)obj);
                else if(obj instanceof Tomografia)
                    this.exames.add((Tomografia)obj);
            }

        }

        catch (EOFException ex) {
            System.out.println("End of file reached");
        }

        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar os exames.");
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                    System.out.println("Exames recuperados com sucesso!");
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private boolean numeroInteiroValido(String s) {
        boolean resultado;
        try {
            Integer.parseInt(s);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        }
        return resultado;
    }



    public void menuExames (){

        String menu = "";
        String entrada;
        int    opc1, opc2;

        do {
            menu = "Controle Laboratório\n" +
                    "Opções:\n" +
                    "1. Entrar Exames\n" +
                    "2. Exibir Exames\n" +
                    "3. Limpar Exames\n" +
                    "4. Gravar Exames\n" +
                    "5. Recuperar Exames\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");

            while (!numeroInteiroValido(entrada)) {
                entrada = JOptionPane.showInputDialog(null, menu +
                        "\n\nEntrada inválida! Digite um número inteiro.");
            }
            opc1 = new Integer(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Exames\n" +
                            "Opções:\n" +
                            "1. Exame de Sangue\n" +
                            "2. Raio X\n" +
                            "3. Tomografia\n";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    while (!numeroInteiroValido(entrada)) {
                        entrada = JOptionPane.showInputDialog(null, menu +
                                "\n\nEntrada inválida! Digite um número inteiro.");
                    }
                    opc2 = new Integer(entrada);

                    switch (opc2){
                        case 1: exames.add((Exame)leSangue());
                            break;
                        case 2: exames.add((Exame)leRaioX());
                            break;
                        case 3: exames.add((Exame)leTomografia());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Exame para entrada NÃO escolhido!");
                    }

                    break;
                case 2: // Exibir dados
                    if (exames.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com exames primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < exames.size(); i++)	{
                        dados += exames.get(i).toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3: // Limpar Dados
                    if (exames.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com exames primeiramente");
                        break;
                    }
                    exames.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;
                case 4: // Grava Dados
                    if (exames.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com exames primeiramente");
                        break;
                    }
                    salvaExames();
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;
                case 5: // Recupera Dados
                    recuperarExames();
                    if (exames.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Fim do aplicativo LABORATÓRIO");
                    break;
            }
        } while (opc1 != 9);
    }

    public static void main(String[] args) {

        Laboratorio laboratorio = new Laboratorio();

        laboratorio.menuExames();


    }

}