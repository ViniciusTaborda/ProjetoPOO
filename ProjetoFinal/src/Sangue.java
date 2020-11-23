
public class Sangue extends Exame {

    private String preparo;

    public Sangue(String nomePaciente, String codigoExame, String preparo) {
        super(nomePaciente, codigoExame);
        this.preparo = preparo;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Preparo: " + this.getPreparo();
    }
}