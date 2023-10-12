import java.util.HashMap;
import java.util.Map;

import java.lang.Thread;

public class Semaforo {
	
	private String numTombamento = null;
	private StateSemaforo StateSemaforo;

//	private boolean[] estado = {true,false,false};
	private Map<Sinal, Integer> transicao = new HashMap<Sinal,Integer>();
	
	public Semaforo(String numTombamento) {
        this.numTombamento = numTombamento;
        // tempo de transicao em segundos
        transicao.put(Sinal.VERMELHO,3);
        transicao.put(Sinal.AMARELO,1);
        transicao.put(Sinal.VERDE,5);
		StateSemaforo = new VermelhoState();
	}

	public String getNumTombamento() {
		return numTombamento;
	}

	public void setNumTombamento(String numTombamento) {
		this.numTombamento = numTombamento;
	}

	public String getEstadoAtual() {
	return StateSemaforo.getDescricao();
	}

	public String getAcao(){
		return StateSemaforo.getAcao();
	}
	
	public void setup(StateSemaforo novo_estado) {
		StateSemaforo = novo_estado;
	}
	
	public void exibir() {
		System.out.println(" vermelho  ( " + (getEstadoAtual().equals("VERMELHO")?"X":" ") + " )");
		System.out.println(" amarelo   ( " + (getEstadoAtual().equals("AMARELO")?"X":" ") + " )");
		System.out.println(" verde     ( " + (getEstadoAtual().equals("VERDE")?"X":" ") + " )");
	}
	
	public void efetuarTransicao() {
		StateSemaforo.efetuarTransicao(this);
	}
	
	public void showVisorRegressivo() {
		for (int i = transicao.get(Sinal.valueOf(getEstadoAtual())); i >0 ; i--) {
			System.out.println(i + " segundo(s)");
			try {
				// 1000 milisegundos equivale a 1 segundo
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void start() {
		this.start(10);
	}

	public void start(int time_in_seconds) {
		while(time_in_seconds > 0) {
			System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
			System.out.println( getEstadoAtual() + " : " + transicao.get(Sinal.valueOf(getEstadoAtual())) + " segundos.");
			exibir();
			time_in_seconds -= transicao.get(Sinal.valueOf(getEstadoAtual()));
			showVisorRegressivo();
			efetuarTransicao();
			System.out.println();

		}
	}
	
	public String toString() {
		String s = "";
		s += "Numero Tombamento: " + numTombamento + "\n";
		s += "Tempo de permanencia em cada estagio:\n";
		s += Sinal.VERMELHO + " : " + transicao.get(Sinal.VERMELHO) + " segundos\n";
		s += Sinal.AMARELO + " : " + transicao.get(Sinal.AMARELO) + " segundos\n";
		s += Sinal.VERDE + " : " + transicao.get(Sinal.VERDE) + " segundos\n";
		return s;
	}


}
