import javax.swing.*;

//clase que administra las memorias virtuales
public class Memoria implements Cloneable{
    //limiites de la memoria y auxiliar para ver el tamaño de cada seccion de la memoria
    private int inicioMem, finMem, tamMem;

    //auxiliares para saber cuales es el siguiente espacio disponible de memoria para cada seccion
    private int enteroAct, flotanteActual, charActual;

    //secciones para cada tipo de variables que se utiliza
    private int[] memoriaEntera;
    private float[] memoriaFlotante;
    private char[][] memoriaChar;

    //constructor de memoria, iniicio Mem se refiere al inicio de la memoria virtual y finMem indica el final
    public Memoria(int inicioMem, int finMem) {
        this.inicioMem = inicioMem;
        this.finMem = finMem;

        //calculamos el tamaño de cada seccion de la memoria
        tamMem = (finMem - inicioMem) / 3;

        //inciamos las secciones de memoria con el tam
        memoriaEntera = new int[tamMem+1];
        memoriaFlotante = new float[tamMem+1];
        memoriaChar = new char[tamMem+1][1];

        //iniciamos los espacios disponibles en 0
        enteroAct = 0;
        flotanteActual = 0;
        charActual = 0;
    }

    //metodo para asignarle a una variable entera su direccion de memoria
    // y guardar en dicha memoria el valor de la variable recibida en value
    public int asignacionMemoriaEntera(int value){
        memoriaEntera[enteroAct] = value;
        enteroAct = enteroAct + 1;
        return inicioMem + enteroAct - 1;
    }

    //metodo para asignarle a una variable flotante su direccion de memoria
    // y guardar en dicha memoria el valor de la variable recibida en value
    public int asignacionMemoriaFlotante(float value){
        memoriaFlotante[flotanteActual] = value;
        flotanteActual++;
        return inicioMem + tamMem + flotanteActual - 1;
    }

    //metodo para asignarle a una variable char su direccion de memoria
    // y guardar en dicha memoria el valor de la variable recibida en value
    public int asignacionMemoriaChar(char[] value){
        memoriaChar[charActual] = value;
        charActual++;
        return inicioMem + (2*tamMem) + charActual - 1;
    }

    //metodo para asignarle a un arreglo de enteros su direccion de memoria inicial
    // y prepara las siguientes "size" direcciones como parte de la variable
    public int asignacionMemoriaEnteraDim(int value, int size){
        int i = 0;
        while(i<size){
            memoriaEntera[enteroAct] = value;
            enteroAct = enteroAct + 1;
            i++;
        }
        return inicioMem + enteroAct - size;
    }
    //metodo para asignarle a un arreglo de flotantes su direccion de memoria inicial
    // y prepara las siguientes "size" direcciones como parte de la variable
    public int asignacionMemoriaFlotanteDim(float value, int size){
        int i = 0;
        while(i<size){
            memoriaFlotante[flotanteActual] = value;
            flotanteActual++;
            i++;
        }
        return inicioMem + tamMem + flotanteActual  - size;
    }
    //metodo para asignarle a un arreglo de caracteres su direccion de memoria inicial
    // y prepara las siguientes "size" direcciones como parte de la variable
    public int asignacionMemoriaCharDim(char[] value, int size){
        int i = 0;
        while(i<size){
            memoriaChar[flotanteActual] = value;
            charActual++;
            i++;
        }
        return inicioMem + (2*tamMem) + charActual  - size;
    }

    public void actualizacionMemoriaEntera(int value , int direccion){
        //se resta el inicio de memorria a la direccion para conseguir la posicion deseada
        memoriaEntera[direccion-inicioMem] = value;
    }

    public void actualizacionMemoriaFlotante(float value, int direccion){
        //se resta el inicio de memoria  y el tam de la seccion entera a la direccion
        // para conseguir la posicion deseada
        memoriaFlotante[direccion-inicioMem-tamMem] = value;
    }

    public void actualiacionMemoriaChar(char[] value, int direccion){
        //se resta el inicio de memoria , el tam de la seccion entera a la direccion
        // y el tam de la seccion flotante
        // para conseguir la posicion deseada
        memoriaChar[direccion-inicioMem-tamMem*2] = value;
    }

    public int accesoMemoriaEntera(int direccion){
        return memoriaEntera[direccion-inicioMem];
    }

    public float accesoMemoriaFlotante(int direccion){
        direccion = direccion - tamMem;
        return memoriaFlotante[direccion-inicioMem];
    }

    public char[] accesoMemoriaChar(int direccion){
        direccion = direccion - (2*tamMem);
        return memoriaChar[direccion-inicioMem];
    }

    public int getInicioMem() {
        return inicioMem;
    }

    public void setInicioMem(int inicioMem) {
        this.inicioMem = inicioMem;
    }

    public int getFinMem() {
        return finMem;
    }

    public void setFinMem(int finMem) {
        this.finMem = finMem;
    }

    public void showMem(){
        for(int i = 0; i < enteroAct; i++){
            System.out.println("DIR: "+inicioMem+i+" VAL: "+memoriaEntera[i]);
        }
        for(int i = 0; i < flotanteActual; i++){
            System.out.println("DIR: "+inicioMem+i+tamMem+" VAL: "+memoriaFlotante[i]);
        }
    }

    public Memoria(Memoria memoria){
        this.inicioMem = memoria.inicioMem;
        this.finMem = memoria.finMem;
        this.tamMem = memoria.tamMem;
        this.enteroAct = memoria.enteroAct;
        this.flotanteActual = memoria.flotanteActual;
        this.charActual = memoria.charActual;
        this.memoriaEntera = new int[tamMem];
        this.memoriaFlotante = new float[tamMem];
        this.memoriaChar = new char[tamMem][1];
        for(int i = 0; i < tamMem; i++){
            this.memoriaEntera[i] = memoria.memoriaEntera[i];
            this.memoriaFlotante[i] = memoria.memoriaFlotante[i];
            this.memoriaChar[i] = memoria.memoriaChar[i];
        }
    }
}