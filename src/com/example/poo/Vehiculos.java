package com.example.poo;

// No es la clase principal del programa y por lo tanto no lleva método main
// En este ejemplo el método main está en "UsoVehiculos"
public class Vehiculos {

    // Creamos las posibles propiedades de la clase
    // Definimos las propiedades como private porque en este caso no queremos
    // que sean modificables directamente desde fuera de la clase.
    private int ruedas;
    private int largo;
    private int ancho;
    private int peso;
    private String color;
    private boolean clima; // Recordar que el valor por defecto será FALSE
    private boolean gps;
    private boolean keyless;

    // Constructor de la clase para dar un estado inicial a las instancias de clase
    // Debe llevar el mismo nombre que la clase
    public Vehiculos(int ruedas, int largo, int ancho, int peso, String color) {

        this.ruedas = ruedas;
        this.largo = largo;
        this.ancho = ancho;
        this.peso = peso;
        if (color.equals("")) this.color = "sin color";
        else this.color = color;
    }
    // Exite la sobrecarga de constructores.
    // Podemos definir diferentes constructores siempre que lleven diferentes parámetros
    public Vehiculos(int ruedas, int largo, int ancho, int peso) {

        this.ruedas = ruedas;
        this.largo = largo;
        this.ancho = ancho;
        this.peso = peso;
        this.color = "sin color";
    }
    public Vehiculos(String color) {

        this.ruedas = 4;
        this.largo = 400;
        this.ancho = 170;
        this.peso = 1300;
        this.color = color;
        this.clima = true;
    }


    // Construimos método para informar una propiedad
    // A estos métodos se los conoce como GETTER
    // Por convención el nombre suele comenzar por "get"
    public String getColor() {
        return this.color;
    }

    public String getDatosVehiculo() {
        return ("Ruedas: "+this.ruedas+"\nLargo: "+this.largo+"\nAncho: "+this.ancho+"\nPeso: "+this.peso);
    }

    public String getExtra() {
        String extras;
        if (this.clima) extras = "Clima: Si\n";
        else extras = "Clima: No\n";
        if (this.gps) extras = extras+"GPS: Si\n";
        else extras = extras+"GPS: No\n";
        if (this.keyless) extras = extras+"Keyless: Si\n";
        else extras = extras+"Keyless: No\n";

        return extras;
    }

    // Construimos método para alterar una propiedad
    // A estos médotos se los conoce como SETTER
    // Por convención el nombre suele comenzar por "set"
    public void setColor(String color) {
        this.color = color;
    }

    // Esto es la sobrecarga de métodos
    // Para poder aplicarla, los métodos deben recibir diferente tipo o número de parámetros

    public void setExtra(boolean clima) { this.clima = clima; }

    public void setExtra(boolean clima,boolean gps,boolean keyless) {
        this.clima = clima;
        this.gps = gps;
        this.keyless = keyless;
    }

}

