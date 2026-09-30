class Milanesa implements Runnable {

    private String nombre;

    public Milanesa(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " - ejecución " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Multiples {

    public static void main(String[] args) {

        new Thread(new Milanesa("Milanesa 1")).start();
        new Thread(new Milanesa("Milanesa 2")).start();
        new Thread(new Milanesa("Milanesa 3")).start();
    }
} 
// El orden no siempre es igual porque los hilos se ejecutan concurrentemente. El sistema elige cuando ejecuta cada hilo, asi que pueden aparecer en orden diferente al ejecutarse