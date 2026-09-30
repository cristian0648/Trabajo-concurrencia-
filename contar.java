class Contador {

    private int valor = 0;

    public synchronized void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}

class Incrementador extends Thread {

    private Contador contador;

    public Incrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}

public class contar {

    public static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();

        Incrementador[] hilos = new Incrementador[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Incrementador(contador);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].join();
        }

        System.out.println("Valor final del contador: " + contador.getValor());
    }
}
// Synchronized resuelve el problema al hacer que solo un hilo a la vez modifique el contador. Los demas hilos esperan su turno. Así se evita que dos hilos modifiquen el contador a la vez y pierda incrementos