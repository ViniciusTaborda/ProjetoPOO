import java.io.Serializable;

public abstract class Exame implements Serializable {

    private String nomePaciente;

    private String codigoExame;

    public Exame(String nomePaciente, String codigoExame) {
        this.nomePaciente = nomePaciente;
        this.codigoExame = codigoExame;
    }

    public Exame() {

    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCodigoExame() {
        return codigoExame;
    }

    public void setCodigoExame(String codigoExame) {
        this.codigoExame = codigoExame;
    }

    @Override
    public String toString() {
        return "--------------------------" +
                "Exame: " + getClass().getSimpleName() +
                "--------------------------\n" +
                "Nome Paciente: " + this.getNomePaciente() +  "\n" +
                "Codigo Exame: " + this.getCodigoExame() + "\n";
    }
}