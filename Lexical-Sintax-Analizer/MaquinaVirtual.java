import java.util.*;

public class MaquinaVirtual {
    private ArrayList<Cuadruplo> cuadruplosArr;
    private Memoria memGlobal = new Memoria(10000,20000);
    private Memoria memLocal = new Memoria(20000,30000);
    private Memoria memTemporal = new Memoria(30000,40000);
    private Memoria memConstante = new Memoria(40000,50000);

    public MaquinaVirtual(ArrayList<Cuadruplo> cuadruplosArr, Memoria memGlobal,Memoria memLocal ,Memoria memTemporal ,Memoria memConstante){
        this.cuadruplosArr = cuadruplosArr;
        this.memGlobal = memGlobal;
        this.memLocal = memLocal;
        this.memTemporal = memTemporal;
        this.memConstante = memConstante;
    }

    private int accesoMemoriaEntero(int valor){
        if(valor>=memGlobal.getiInicioMem() && valor<memGlobal.getiFinMem()){
            return memGlobal.accesoMemoriaEntera(valor);
        }
        if(valor>=memLocal.getiInicioMem() && valor<memLocal.getiFinMem()){
            return memLocal.accesoMemoriaEntera(valor);
        }
        if(valor>=memTemporal.getiInicioMem() && valor<memTemporal.getiFinMem()){
            return memTemporal.accesoMemoriaEntera(valor);
        }
        if(valor>=memConstante.getiInicioMem() && valor<memConstante.getiFinMem()){
            return memConstante.accesoMemoriaEntera(valor);
        }
        return -1;
    }

    private float accesoMemoriaFlotante(int valor){
        valor= valor - 5000;
        if(valor>=memGlobal.getiInicioMem() && valor<memGlobal.getiFinMem()){
            return memGlobal.accesoMemoriaFlotante(valor);
        }
        if(valor>=memLocal.getiInicioMem() && valor<memLocal.getiFinMem()){
            return memLocal.accesoMemoriaFlotante(valor);
        }
        if(valor>=memTemporal.getiInicioMem() && valor<memTemporal.getiFinMem()){
            return memTemporal.accesoMemoriaFlotante(valor);
        }
        if(valor>=memConstante.getiInicioMem() && valor<memConstante.getiFinMem()){
            return memConstante.accesoMemoriaFlotante(valor);
        }
        return -1;
    }

    private void actualizarMemoriaEntero(int valor, int direccion){
        if(direccion>=memGlobal.getiInicioMem() && direccion<memGlobal.getiFinMem()){
            memGlobal.actualizacionMemoriaEntera(valor,direccion);
        }
        if(direccion>=memLocal.getiInicioMem() && direccion<memLocal.getiFinMem()){
            memLocal.actualizacionMemoriaEntera(valor,direccion);
        }
        if(direccion>=memTemporal.getiInicioMem() && direccion<memTemporal.getiFinMem()){
            memTemporal.actualizacionMemoriaEntera(valor,direccion);
        }
        if(direccion>=memConstante.getiInicioMem() && direccion<memConstante.getiFinMem()){
            memConstante.actualizacionMemoriaEntera(valor,direccion);
        }
    }

    private void actualizarMemoriaFlotante(float valor, int direccion){
        direccion= direccion - 5000;
        if(direccion>=memGlobal.getiInicioMem() && direccion<memGlobal.getiFinMem()){
            memGlobal.actualizacionMemoriaFlotante(valor,direccion);
        }
        if(direccion>=memLocal.getiInicioMem() && direccion<memLocal.getiFinMem()){
            memLocal.actualizacionMemoriaFlotante(valor,direccion);
        }
        if(direccion>=memTemporal.getiInicioMem() && direccion<memTemporal.getiFinMem()){
            memTemporal.actualizacionMemoriaFlotante(valor,direccion);
        }
        if(direccion>=memConstante.getiInicioMem() && direccion<memConstante.getiFinMem()){
            memConstante.actualizacionMemoriaFlotante(valor,direccion);
        }
    }

    private boolean isMemEntera(int value) {
        String string = String.valueOf(value);
        if(string.charAt(1)=='5'){
            return false;
        }

        return true;
    }

    public void run(){
        boolean bEnd = false;
        int i = 0;
        Cuadruplo cuadActual;
        int opDer,opIzq,opRes;
        float fValDer,fValIzq,fValRes;
        int iOperador;
        while(!bEnd){
            cuadActual = cuadruplosArr.get(i);
            iOperador=cuadActual.getiOperador();
            switch (iOperador) {
                case 0:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(isMemEntera(opRes)){
                        actualizarMemoriaEntero((int)(fValIzq + fValDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(fValIzq + fValDer,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");
                    System.out.println("suma " + (fValIzq + fValDer));
                    i++;
                    break;
                case 1:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(isMemEntera(opRes)){
                        actualizarMemoriaEntero((int)(fValIzq - fValDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(fValIzq - fValDer,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");
                    System.out.println("resta " + (fValIzq - fValDer));
                    i++;
                    break;
                case 2:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValDer==0.0){
                        System.out.println("Error found At line " + cuadActual.getiNumero()+" division by ZERO");
                        bEnd = true;
                        break;
                    }
                    if(isMemEntera(opRes)){
                        actualizarMemoriaEntero((int)(fValIzq / fValDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(fValIzq / fValDer,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");
                    System.out.println("div " + (fValIzq / fValDer));
                    i++;
                    break;
                case 3:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(isMemEntera(opRes)){
                        actualizarMemoriaEntero((int)(fValIzq * fValDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(fValIzq * fValDer,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("mult " + (fValIzq * fValDer));
                    i++;
                    break;
                case 4:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq == fValDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("== " + (fValIzq == fValDer));
                    i++;
                    break;
                case 5:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq <= fValDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("<= " + (fValIzq <= fValDer));
                    i++;
                    break;
                case 6:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq < fValDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("< " + (fValIzq < fValDer));
                    i++;
                    break;
                case 7:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq >= fValDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println(">= " + (fValIzq >= fValDer));
                    i++;
                    break;
                case 8:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq > fValDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("> " + (fValIzq > fValDer));
                    i++;
                    break;
                case 9:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq != fValDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("!= " + (fValIzq != fValDer));
                    i++;
                    break;
                case 10:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq == 1 || fValDer == 1){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("|| " + (fValIzq * fValDer));
                    i++;
                    break;
                case 11:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(isMemEntera(opDer)){
                        fValDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        fValDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(fValIzq == 1 && fValDer == 1){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("&& " + (fValIzq * fValDer));
                    i++;
                    break;
                case 12:
                    opIzq = cuadActual.getiIzquierda();
                    opRes = cuadActual.getiResultado();
                    if(isMemEntera(opRes)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                        actualizarMemoriaEntero((int) fValIzq,opRes);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                        actualizarMemoriaFlotante(fValIzq,opRes);
                    }
                    System.out.print(cuadActual.getiNumero() + " ");

                    System.out.println("= " + (fValIzq));
                    i++;
                    break;
                case 13:
                    i++;
                    break;
                case 14:
                    i++;
                    break;
                case 15:
                    i++;
                    break;
                case 16:
                    i++;
                    break;
                case 17:
                    opRes = cuadActual.getiResultado();
                    i = opRes;
                    break;
                case 18:
                    opIzq = cuadActual.getiIzquierda();
                    if(isMemEntera(opIzq)){
                        fValIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        fValIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(fValIzq == 1){
                        i++;
                        break;
                    }
                    opRes = cuadActual.getiResultado();
                    i = opRes;
                    break;
                case 19:
                    i++;
                    break;
                case 20:
                    opIzq = cuadActual.getiIzquierda();
                    fValIzq = accesoMemoriaEntero(opIzq);
                    opDer = cuadActual.getiDerecha();
                    opRes = cuadActual.getiResultado();
                    if(fValIzq<opDer || fValIzq>=opRes){
                        System.out.println("Error found At line " + cuadActual.getiNumero()+" Array out of bounds");
                        bEnd = true;
                        break;
                    }
                    i++;
                    break;
                case 21:
                    i++;
                    break;
                case 22:
                    System.out.println("End of execution");
                    bEnd = true;
                    break;
            }
        }
    }
}


