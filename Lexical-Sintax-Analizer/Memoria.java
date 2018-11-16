import java.lang.reflect.Type;
import java.util.Set;

public class Memoria<T> {
    private int iInicioMem, iFinMem, iTamMem;
    private int iEnteroAct, iFlotanteActual;
    private int[] iMemoriaEntera;
    private float[] fMemoriaFlotante;

    public Memoria(int iInicioMem, int iFinMem) {
        this.iInicioMem = iInicioMem;
        this.iFinMem = iFinMem;

        iTamMem = (iFinMem - iInicioMem) / 2;
        iMemoriaEntera = new int[iTamMem];
        fMemoriaFlotante = new float[iTamMem];

        iEnteroAct = 0;
        iFlotanteActual = 0;
    }

    public int asignacionMemoriaEntera(int value){
        iMemoriaEntera[iEnteroAct] = value;
        iEnteroAct = iEnteroAct + 1;
        return iInicioMem + iEnteroAct - 1;
    }

    public int asignacionMemoriaFlotante(float value){
        fMemoriaFlotante[iFlotanteActual] = value;
        iFlotanteActual++;
        return iInicioMem + iTamMem + iFlotanteActual - 1;
    }

    public int asignacionMemoriaEnteraDim(int value, int size){
        int i = 0;
        System.out.println(iEnteroAct);
        while(i<size){
            iMemoriaEntera[iEnteroAct] = value;
            iEnteroAct = iEnteroAct + 1;
            i++;
        }
        return iInicioMem + iEnteroAct - size;
    }

    public int asignacionMemoriaFlotanteDim(float value, int size){
        int i = 0;
        while(i<size){
            fMemoriaFlotante[iFlotanteActual] = value;
            iFlotanteActual++;
            i++;
        }
        return iInicioMem + iTamMem + iFlotanteActual - 1 - size;
    }

    public void actualizacionMemoriaEntera(int value , int direccion){
        iMemoriaEntera[direccion-iInicioMem] = value;
    }

    public void actualizacionMemoriaFlotante(float value, int direccion){
        fMemoriaFlotante[direccion-iInicioMem] = value;
    }
    public int accesoMemoriaEntera(int direccion){
        return iMemoriaEntera[direccion-iInicioMem];
    }
    public float accesoMemoriaFlotante(int direccion){
        return fMemoriaFlotante[direccion-iInicioMem];
    }

    public int getiInicioMem() {
        return iInicioMem;
    }

    public void setiInicioMem(int iInicioMem) {
        this.iInicioMem = iInicioMem;
    }

    public int getiFinMem() {
        return iFinMem;
    }

    public void setiFinMem(int iFinMem) {
        this.iFinMem = iFinMem;
    }
}