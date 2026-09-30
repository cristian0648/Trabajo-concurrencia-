class Buffer {

    private int dato;
    private boolean disponible = false;

    public synchronized void put(int valor) {

        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.dato = valor;
        disponible = true;

        System.out.println("Productor puso: " + dato);

        notifyAll();
    }

    public synchronized int get() {

        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        disponible = false;

        System.out.println("Consumidor obtuvo: " + dato);

        notifyAll();

        return dato;
    }
}

class Productor extends Thread {

    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.put(i);
        }
    }
}

class Consumidor extends Thread {

    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.get();
        }
    }
}

public class Consumir {

    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer();

        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();

        System.out.println("Proceso terminado.");
    }
}

// Se usa while para poder comprobar otra vez si el dato esta disponible despues de que el hilo despierta. Evitando que el hilo siga antes de tiempo y el if solo comprueba una vez y podria seguir incluso si no se cumple la condicion