import javax.swing.*;

public class Memoria implements Cloneable{
    private int inicioMem, finMem, tamMem;

    private int enteroAct, flotanteActual, charActual;
    private int[] memoriaEntera;
    private float[] memoriaFlotante;
    private char[][] memoriaChar;

    public Memoria(int inicioMem, int finMem) {
        this.inicioMem = inicioMem;
        this.finMem = finMem;

        tamMem = (finMem - inicioMem) / 3;
        memoriaEntera = new int[tamMem+1];
        memoriaFlotante = new float[tamMem+1];
        memoriaChar = new char[tamMem+1][1];

        enteroAct = 0;
        flotanteActual = 0;
        charActual = 0;
    }

    public int asignacionMemoriaEntera(int value){
        memoriaEntera[enteroAct] = value;
        enteroAct = enteroAct + 1;
        return inicioMem + enteroAct - 1;
    }

    public int asignacionMemoriaFlotante(float value){
        memoriaFlotante[flotanteActual] = value;
        flotanteActual++;
        return inicioMem + tamMem + flotanteActual - 1;
    }

    public int asignacionMemoriaChar(char[] value){
        memoriaChar[charActual] = value;
        charActual++;
        return inicioMem + (2*tamMem) + charActual - 1;
    }

    public int asignacionMemoriaEnteraDim(int value, int size){
        int i = 0;
        while(i<size){
           // System.out.println("Dir dim Entera" + (inicioMem + enteroAct));
            memoriaEntera[enteroAct] = value;
            enteroAct = enteroAct + 1;
            i++;
        }
        return inicioMem + enteroAct - size;
    }

    public int asignacionMemoriaFlotanteDim(float value, int size){
        int i = 0;
        while(i<size){
            //System.out.println("Dir dim Flotante" + (inicioMem +tamMem+ flotanteActual));
            memoriaFlotante[flotanteActual] = value;
            flotanteActual++;
            i++;
        }
        return inicioMem + tamMem + flotanteActual  - size;
    }

    public int asignacionMemoriaCharDim(char[] value, int size){
        int i = 0;
        while(i<size){
            //System.out.println("Dir dim Flotante" + (inicioMem +tamMem+ flotanteActual));
            memoriaChar[flotanteActual] = value;
            charActual++;
            i++;
        }
        return inicioMem + (2*tamMem) + charActual  - size;
    }

    public void actualizacionMemoriaEntera(int value , int direccion){
        memoriaEntera[direccion-inicioMem] = value;
    }

    public void actualizacionMemoriaFlotante(float value, int direccion){
        memoriaFlotante[direccion-inicioMem-tamMem] = value;
    }

    public void actualiacionMemoriaChar(char[] value, int direccion){
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