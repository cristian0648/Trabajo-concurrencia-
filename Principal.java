class MiHilo extends Thread {
    public String nombre;

    public MiHilo(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("El "+this.nombre +" está corriendo en segundo plano.");
    }
}

public class Principal {
    public static void main(String[] args) {
        MiHilo hilo1 = new MiHilo("hilo 1");
        MiHilo hilo2 = new MiHilo("hilo 2");
        MiHilo hilo3 = new MiHilo("hilo 3");
        hilo1.start(); // Invoca al método run() en un nuevo hilo
        hilo2.start();
        hilo3.start();
    }
}
// El start() lo que hace es iniciar un hilo nuevo y despues ejecuta el run() en el hilo
// Si se ejecuta run() entonces se ejecuta el hilo actual y no se crea uno nuevo