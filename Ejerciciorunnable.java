class MiTarea implements Runnable {

    @Override
    public void run() {
        System.out.println("¡Hola desde mi tarea con Runnable!");
    }
}

public class Ejerciciorunnable {

    public static void main(String[] args) {

        MiTarea tarea = new MiTarea();

        Thread hilo = new Thread(tarea);

        hilo.start();
    }
}

// La ventaja de runnable sobre thread es que separa la tarea del hilo que la ejecuta y es mas flexible para extender que thread