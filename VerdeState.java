public class VerdeState implements StateSemaforo {
    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setup(new AmareloState());
    }

    @Override
    public String getDescricao() {
        return "VERDE";
    }

    @Override
    public String getAcao() {
        return "SIGA";
    }
}