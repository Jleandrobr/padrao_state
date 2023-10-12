public class VermelhoState implements StateSemaforo {
    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setup(new VerdeState());
    }

    @Override
    public String getDescricao() {
        return "VERMELHO";
    }

    @Override
    public String getAcao() {
        return "PARE";
    }
}