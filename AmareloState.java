public class AmareloState implements StateSemaforo {
    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setup(new VermelhoState());
    }

    @Override
    public String getDescricao() {
        return "AMARELO";
    }

    @Override
    public String getAcao() {
        return "ATENÇÃO";
    }
}