public class Tomografia extends Exame {

    private String liberacao;

    private String contraste;

    public Tomografia(String nomePaciente, String codigoExame, String liberacao, String contraste) {
        super(nomePaciente, codigoExame);
        this.liberacao = liberacao;
        this.contraste = contraste;
    }

    public String getLiberacao() {
        return liberacao;
    }

    public void setLiberacao(String liberacao) {
        this.liberacao = liberacao;
    }

    public String getContraste() {
        return contraste;
    }

    public void setContraste(String contraste) {
        this.contraste = contraste;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Liberação: " + this.getLiberacao() + "\n" +
                "Constraste: " + this.getContraste();
    }
}