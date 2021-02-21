package com.example.programacionGenerica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ArrayList1 {

    /* ARRAYLIST
    *
    * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
    *
    * Un "arraylist" puede almacenar diferentes tipos de objetos (mezclados incluso si se
    * indica un tipo de objeto que comprenda todos los tipos posibles esperados), puede crecer
    * dinámicamente, pero no puede contener de forma directa tipos de datos primitivos
    * como int, char, string... etc. Para esto se usará lo que se conoce como clase
    * envoltorio. */
    public static void main(String[] args) {

        /* Creamos un arraylist para contenter objetos de tipo Empleado. Si no se especifica
        * el tamaño en memoria por defecto es para 10 elementos. Se puede especificar informando
        * un int. */
        ArrayList <Empleado> listaEmpleados = new ArrayList<Empleado>();

        /* Cada vez que un arraylist se redimensiona, se genera mediante una creación de un nuevo
        * arraylist de mayor capacidad, copia del arraylist origen y borrado del arralist origen.
        *
        * Para intentar optimizar recursos se pueden usar dos métodos de la clase "ArrayList":
        *
        * - "ensureCapacity(int cap)", que otorgará una nueva capcidad en memoria al arraylist,
        * para evitar la operación de creación y copiado si se conoce de antemano el tamaño
        * nuevo necesario.
        *
        * - "trimToSize()", que elimina las posiciones de memoria no usadas en un arraylist. */

        /* Aunque el arraylist tenga una capacidad reservada en memoria, realmente solo
        * tendrá ocupados los huecos asignados. Un arraylist recién creado tendrá un
        * tamaño de 0. */
        System.out.println(listaEmpleados.size());

        listaEmpleados.add(new Empleado("Antonio",2100.5,2005,7,5));
        listaEmpleados.add(new Empleado("Juan",2100.10,2005,3,18));
        listaEmpleados.add(new Empleado("Maria",2200.8,2003,4,11));
        listaEmpleados.add(new Empleado("Susana",2300.9,2011,8,29));

        // Añadimos 4 elemenos y el tamaño del arraylist pasa a ser 4.
        System.out.println(listaEmpleados.size());

        for (Empleado empleado:listaEmpleados) {
            System.out.println(empleado.getDatosEmpleado() + " Sueldo: " + empleado.getSueldo());
        }



        /* Ejemplo de arraylist conteniendo dos objetos de tipos totalmente distintos.
        * A pesar de ser posible, el manejo se complica mucho, al tener que comprobar que
        * tipo de objeto estamos tratando al leerlo del arraylist. */
        System.out.println("\nEjemplo arraylist con clases custom mezcladas.");
        ArrayList <Object> listaObjetos = new ArrayList();
        listaObjetos.add(new Empleado("Pepe",1500,2019,10,20));
        listaObjetos.add(new Vehiculos(4,250,170,1200,"Rojo"));

        for(Object obj:listaObjetos){
            if(obj.getClass() == Empleado.class) {
                Empleado emp = (Empleado) obj;
                System.out.println(emp.getDatosEmpleado());
            }
            else if (obj.getClass() == Vehiculos.class) {
                Vehiculos vehic = (Vehiculos)obj;
                System.out.println(vehic.getDatosVehiculo());
            }
        }
        System.out.println("\nEjemplo arraylist con tipos mezclados.");
        ArrayList <Object> listaMixta = new ArrayList<>();
        listaMixta.add("String");
        listaMixta.add(123f);
        listaMixta.add(1024L);
        int array_val[] = {12,11,12,13,14};
        listaMixta.add(array_val);

        /* En este ejemplo he podido almacenar un array, pero no sé como determinar
        si el objeto leído es un array y en este caso acceder a alguna de sus posiciones. */
        for(Object obj:listaMixta){
            Class clase = obj.getClass();
            if (clase == Integer.class) System.out.println("El objeto es Integer: "+obj.getClass());
            if (clase == String.class) System.out.println("El objeto es String: "+obj.getClass());
            if (clase == Float.class) System.out.println("El objeto es Float: "+obj.getClass());
            if (clase == Long.class) System.out.println("El objeto es Long: "+obj.getClass());

            if (obj.getClass() == Arrays.class) {
                System.out.println(obj+" es un array");
            }

        }
    }
}

// Definimos la clase Empleado en el mismo fichero/módulo que la clase main
class Empleado {

    private static int ID = 1;
    private final int id;
    private final String NOMBRE;
    private double sueldo;
    private GregorianCalendar fechaAlta;


    //Constructor
    public Empleado(String nombre, double sueldo, int anno, int mes, int dia){
        //Usamos una variable de clase static,
        //para crear un secuencial para el id de empleado
        this.id = ID;
        ID++;
        this.NOMBRE = nombre;
        this.sueldo = sueldo;
        this.fechaAlta = new GregorianCalendar(anno,mes,dia);
    }

    //Setters

    public void setSubeSueldo(double subida){
        this.sueldo += this.sueldo*subida/100;
    }

    //Getters
    public String getDatosEmpleado(){

        //Alternativa a la concatenación normal, con método StringBuilder.append
        return (new StringBuilder().append("\nID Empleado: ").append(this.id).append(" Nombre Empleado: ").append(this.NOMBRE).toString());
    }

    public double getSueldo(){
        return this.sueldo;
    }

    // En este método mantenemos la clase GregorianCalendar, para poder operar con fechas
    public GregorianCalendar getFechaAlta() { return this.fechaAlta; }

    public String getFechaAltaFormat() {
        String date = this.fechaAlta.get(Calendar.DAY_OF_MONTH)+"/"+fechaAlta.get(Calendar.MONTH)+"/"+this.fechaAlta.get(Calendar.YEAR);
        return date;
    }

    public static String getSiguienteId(){
        return "El Id del siguiente empleado será: "+ID;
    }
}

// Esta clase hereda de Emepleado
class Jefe extends Empleado {

    // Propiedad exclusiva de la clase Jefe
    private double incentivo;

    // Constructor heredado de la superclase
    public Jefe(String nombre, double sueldo, int anno, int mes, int dia) {
        super(nombre, sueldo, anno, mes, dia);
    }

    // Setter exclusivo de la clase Jefe
    public void setIncentivo(double importe) {
        this.incentivo = importe;
    }

    // Getter

    // Sobreescritura de métodos y uso del própio método heredado
    // con la palabra reservada "super"
    public double getSueldo () {
        return super.getSueldo() + this.incentivo;
    }
}

// Esta clase hereda de Jefe, pero también de Empleado
// Al agregar el modificador "final", bloqueamos la posibilidad de que sea heredada
final class Director extends Jefe {

    // Atributos específicos de clase
    private boolean cocheEmpresa;
    private boolean casaEmpresa;

    public Director(String nombre, double sueldo, int anno, int mes, int dia) {
        super(nombre, sueldo, anno, mes, dia);
    }

    // Setters
    public void setCocheEmpresa(boolean coche) { this.cocheEmpresa = coche; }

    public void setCasaEmpresa(boolean casa) { this.casaEmpresa = casa; }

    // Getters
    public boolean getCocheEmpresa() { return this.cocheEmpresa; }

    public boolean getCasaEmpresa() { return this.casaEmpresa; }


}

class Vehiculos {

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