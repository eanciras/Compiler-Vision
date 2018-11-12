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

    public void actualizacionMemoriaEntera(int value , int direccion){
        iMemoriaEntera[iInicioMem-direccion] = value;
    }

    public void actualizacionMemoriaFlotante(float value, int direccion){
        fMemoriaFlotante[iInicioMem-direccion] = value;
    }

}