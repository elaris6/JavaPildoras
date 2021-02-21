package com.example.poo;

public class CadenaHerencia {

    public static void main(String[] args) {

        // Objetos creados para representar la hernecia en cadena.
        // El objetoTipo1 solo puede usar sus propiedades, contrutores y métodos
        // El objetoTipo4 puede usar los suyos y todos los otros heredados
        // En java no exite la herencia múltiple.
        // Para paliar esto se usan las "interfaces", que no es exactamente lo mismo
        Clase1 objetoTipo1 = new Clase3();
        Clase4 objetoTipo4 = new Clase4();

        objetoTipo4.metodoPrueba();

    }
}

class Clase1 {

    public void metodo1() {
        System.out.println("Soy la Clase1");
    }
}

class Clase2 extends Clase1 {

    public void metodo2() {
        System.out.println("Soy la Clase2");
    }
    public void metodo1() {
        System.out.println("Soy la Clase2 usando metodo1");
    }
}

class Clase3 extends Clase2 {

    public void metodo3() {
        System.out.println("Soy la Clase3");
    }
    public void metodo1() {
        System.out.println("Soy la Clase3 usando metodo 1");
    }
}

// Al agregar el modificador "final", se impide que Clase4 sea heredada
final class Clase4 extends Clase3 {

    public void metodo4() {
        System.out.println("Soy la Clase4");
    }
    // Con super solo podemos hacer referencia a la clase padre
    // si la clase padre a su vez sobreescribe otro método heredado
    // no podremos ya acceder a este
    public void metodoPrueba(){
        super.metodo1();
    }
}
