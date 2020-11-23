public class RaioX extends Exame {

    private String preparo;

    private String liberacao;

    public RaioX(String nomePaciente, String codigoExame, String preparo, String liberacao) {
        super(nomePaciente, codigoExame);
        this.preparo = preparo;
        this.liberacao = liberacao;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public String getLiberacao() {
        return liberacao;
    }

    public void setLiberacao(String liberacao) {
        this.liberacao = liberacao;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Liberação: " + this.getLiberacao() + "\n" +
                "Preparo: " + this.getPreparo();
    }
}