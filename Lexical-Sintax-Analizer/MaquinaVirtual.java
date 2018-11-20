import java.util.*;

public class MaquinaVirtual {
    private ArrayList<Cuadruplo> cuadruplosArr;
    private Memoria memGlobal = new Memoria(10000,40000);
    private Memoria memLocal = new Memoria(40000,70000);
    private Memoria memTemporal = new Memoria(70000,100000);
    private Memoria memConstante = new Memoria(100000,130000);
    private Vector<Function> listaFunciones;

    public MaquinaVirtual(ArrayList<Cuadruplo> cuadruplosArr, Memoria memGlobal,Memoria memLocal ,Memoria memTemporal ,Memoria memConstante, Vector<Function> listaFunciones){
        this.cuadruplosArr = cuadruplosArr;
        this.memGlobal = memGlobal;
        this.memLocal = memLocal;
        this.memTemporal = memTemporal;
        this.memConstante = memConstante;
        this.listaFunciones = listaFunciones;
    }

    private int accesoMemoriaEntero(int valor){
        if(valor>=memGlobal.getInicioMem() && valor<memGlobal.getFinMem()){
            return memGlobal.accesoMemoriaEntera(valor);
        }
        if(valor>=memLocal.getInicioMem() && valor<memLocal.getFinMem()){
            return memLocal.accesoMemoriaEntera(valor);
        }
        if(valor>=memTemporal.getInicioMem() && valor<memTemporal.getFinMem()){
            return memTemporal.accesoMemoriaEntera(valor);
        }
        if(valor>=memConstante.getInicioMem() && valor<memConstante.getFinMem()){
            return memConstante.accesoMemoriaEntera(valor);
        }
        return -1;
    }

    private float accesoMemoriaFlotante(int valor){
        if(valor>=memGlobal.getInicioMem() && valor<memGlobal.getFinMem()){
            return memGlobal.accesoMemoriaFlotante(valor);
        }
        if(valor>=memLocal.getInicioMem() && valor<memLocal.getFinMem()){
            return memLocal.accesoMemoriaFlotante(valor);
        }
        if(valor>=memTemporal.getInicioMem() && valor<memTemporal.getFinMem()){
            return memTemporal.accesoMemoriaFlotante(valor);
        }
        if(valor>=memConstante.getInicioMem() && valor<memConstante.getFinMem()){
            return memConstante.accesoMemoriaFlotante(valor);
        }
        return -1;
    }

    private char[] accesoMemoriaChar(int valor){
        if(valor>=memGlobal.getInicioMem() && valor<memGlobal.getFinMem()){
            return memGlobal.accesoMemoriaChar(valor);
        }
        if(valor>=memLocal.getInicioMem() && valor<memLocal.getFinMem()){
            return memLocal.accesoMemoriaChar(valor);
        }
        if(valor>=memTemporal.getInicioMem() && valor<memTemporal.getFinMem()){
            return memTemporal.accesoMemoriaChar(valor);
        }
        if(valor>=memConstante.getInicioMem() && valor<memConstante.getFinMem()){
            return memConstante.accesoMemoriaChar(valor);
        }
        return new char[]{'e'};
    }

    private void actualizarMemoriaEntero(int valor, int direccion){
        if(direccion>=memGlobal.getInicioMem() && direccion<memGlobal.getFinMem()){
            memGlobal.actualizacionMemoriaEntera(valor,direccion);
        }
        if(direccion>=memLocal.getInicioMem() && direccion<memLocal.getFinMem()){
            memLocal.actualizacionMemoriaEntera(valor,direccion);
        }
        if(direccion>=memTemporal.getInicioMem() && direccion<memTemporal.getFinMem()){
            memTemporal.actualizacionMemoriaEntera(valor,direccion);
        }
        if(direccion>=memConstante.getInicioMem() && direccion<memConstante.getFinMem()){
            memConstante.actualizacionMemoriaEntera(valor,direccion);
        }
    }

    private void actualizarMemoriaFlotante(float valor, int direccion){
        if(direccion>=memGlobal.getInicioMem() && direccion<memGlobal.getFinMem()){
            memGlobal.actualizacionMemoriaFlotante(valor,direccion);
        }
        if(direccion>=memLocal.getInicioMem() && direccion<memLocal.getFinMem()){
            memLocal.actualizacionMemoriaFlotante(valor,direccion);
        }
        if(direccion>=memTemporal.getInicioMem() && direccion<memTemporal.getFinMem()){
            memTemporal.actualizacionMemoriaFlotante(valor,direccion);
        }
        if(direccion>=memConstante.getInicioMem() && direccion<memConstante.getFinMem()){
            memConstante.actualizacionMemoriaFlotante(valor,direccion);
        }
    }

    private void actualizarMemoriaChar(char[] valor, int direccion){
        if(direccion>=memGlobal.getInicioMem() && direccion<memGlobal.getFinMem()){
            memGlobal.actualiacionMemoriaChar(valor,direccion);
        }
        if(direccion>=memLocal.getInicioMem() && direccion<memLocal.getFinMem()){
            memLocal.actualiacionMemoriaChar(valor,direccion);
        }
        if(direccion>=memTemporal.getInicioMem() && direccion<memTemporal.getFinMem()){
            memTemporal.actualiacionMemoriaChar(valor,direccion);
        }
        if(direccion>=memConstante.getInicioMem() && direccion<memConstante.getFinMem()){
            memConstante.actualiacionMemoriaChar(valor,direccion);
        }
    }

    private int memType(int value) {
        float result = (float)Math.floor((float)value / 10000.0);
        if(result % 3 == 0){
            return 2;
        }else if(result % 3 == (1.0 % 3.0)){
            return 0;
        }else {
            return 1;
        }
    }

    public void run(){
        boolean end = false;
        Cuadruplo cuadActual;
        int opDer,opIzq,opRes,operador,i=0;
        float valDer,valIzq=0,valRes;

        Function currentFunction = new Function();
        Stack<Integer> currentPosStack = new Stack<>();
        currentPosStack.push(cuadruplosArr.size()-1);
        int currentFunctionReturn = -1, paramTypePointer = 0, returnDir = 0;
        ArrayList<Integer> paramTypes = new ArrayList<>();
        ArrayList<Integer> paramList = new ArrayList<>();
        Vector<Memoria> memoriasLocales = new Vector<Memoria>();
        Vector<Memoria> memoriasTemporales = new Vector<Memoria>();
        Stack<Integer> pilaRetorno = new Stack<>();
        while(!end){
            cuadActual = cuadruplosArr.get(i);
            operador = cuadActual.getiOperador();
            switch (operador) {
                //+
                case 0:
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer= pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(opRes<0){
                        opRes = opRes * -1;
                        if(memType(opRes)==0){
                            actualizarMemoriaEntero((int)(valIzq + opDer),opRes);
                        }
                        else{
                            actualizarMemoriaFlotante(valIzq + opDer,opRes);
                        }
                    }
                    else {
                        if(memType(opRes)==0){
                            actualizarMemoriaEntero((int)(valIzq + valDer),opRes);
                        }
                        else{
                            actualizarMemoriaFlotante(valIzq + valDer,opRes);
                        }
                    }
                    i++;
                    break;
                //-
                case 1:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }

                    opRes = cuadActual.getiResultado();

                    if(memType(opRes)==0){
                        actualizarMemoriaEntero((int)(valIzq - valDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(valIzq - valDer,opRes);
                    }
                    i++;
                    break;
                // /
                case 2:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valDer==0.0){
                        System.out.println("Error found At line " + cuadActual.getiNumero()+" division by ZERO");
                        end = true;
                        break;
                    }
                    if(memType(opRes)==0){
                        actualizarMemoriaEntero((int)(valIzq / valDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(valIzq / valDer,opRes);
                    }
                    i++;
                    break;
                //*
                case 3:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(memType(opRes)==0){
                        actualizarMemoriaEntero((int)(valIzq * valDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(valIzq * valDer,opRes);
                    }
                    i++;
                    break;
                // ==
                case 4:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq == valDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // <=
                case 5:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq <= valDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // <
                case 6:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq < valDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // >=
                case 7:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq >= valDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // >
                case 8:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq > valDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // !=
                case 9:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer== 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq != valDer){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // ||
                case 10:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer == 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq == 1 || valDer == 1){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // &&
                case 11:
                    opDer = cuadActual.getiDerecha();
                    if(opDer<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opDer = accesoMemoriaEntero(opDer*-1);
                    }
                    if(opDer == 23){
                        opDer = pilaRetorno.pop();
                    }
                    opIzq = cuadActual.getiIzquierda();
                    if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                        opIzq = accesoMemoriaEntero(opIzq*-1);
                    }
                    if(opIzq == 23){
                        opIzq = pilaRetorno.pop();
                    }
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(valIzq == 1 && valDer == 1){
                        actualizarMemoriaEntero(1,opRes);
                    }
                    else{
                        actualizarMemoriaEntero(0,opRes);
                    }
                    i++;
                    break;
                // =
                case 12:
                    opIzq = cuadActual.getiIzquierda();
                    opRes = cuadActual.getiResultado();
                    if(opIzq != 23){
                        if(opIzq<0){// si la direccion es negativa, se utilizo direccionamiento indirecto
                        //cargamos la dirrecion real al operando
                            opIzq = accesoMemoriaEntero(opIzq*-1);
                        }
                        if(opRes<0){
                            opRes = accesoMemoriaEntero(opRes*-1);
                        }
                        if(memType(opRes)==0){
                            if(memType(opIzq)==0) {
                                valIzq = accesoMemoriaEntero(opIzq);
                                actualizarMemoriaEntero((int) valIzq, opRes);
                            }else {
                                System.out.println("\nError found at line "+cuadActual.getiNumero()+".\n\tType mismatch expected INT found FLOAT");
                                i = cuadruplosArr.size()-1;
                            }
                        }
                        else{
                            if(memType(opIzq)==1) {
                                valIzq = accesoMemoriaFlotante(opIzq);
                                actualizarMemoriaFlotante(valIzq,opRes);
                            }else {
                                System.out.println("\nError found at line " + cuadActual.getiNumero() + ".\n\tType mismatch expected FLOAT found INT");
                                i = cuadruplosArr.size() - 1;
                            }
                        }
                    }else {
                        returnDir = pilaRetorno.pop();
                        if(memType(returnDir)==0){
                            valIzq = accesoMemoriaEntero(returnDir);
                            actualizarMemoriaEntero((int) valIzq,opRes);
                        }
                        else{
                            valIzq = accesoMemoriaFlotante(returnDir);
                            actualizarMemoriaFlotante(valIzq,opRes);
                        }
                    }
                    i++;
                    break;
                // print
                case 13:
                    opRes = cuadActual.getiResultado();
                    if(opRes<0){
                        opRes = accesoMemoriaEntero(opRes*-1);
                    }
                    if(memType(opRes)==0) {
                        System.out.print(Integer.toString(accesoMemoriaEntero(opRes)));
                    }else if(memType(opRes)==1){
                        System.out.print(Float.toString(accesoMemoriaFlotante(opRes-20000)));
                    }else {
                        char txt[] = accesoMemoriaChar(opRes);
                        for(int x = 0; x < txt.length; x++) {
                            if(txt[x]!='\\') {
                                System.out.print(txt[x]);
                            }else {
                                if(txt[x + 1] == 'n') {
                                    System.out.print("\n");
                                }else if(txt[x+1] == 't'){
                                    System.out.print("\t");
                                }else if(txt[x+1] == '\\'){
                                    System.out.print("\\");
                                }
                                x++;
                            }
                        }
                    }

                    i++;
                    break;
                //ERA
                case 14:
                    /*Function currentFunction;
                    boolean currentFunctionReturn = false;
                    int paramTypePointer = 0;
                    ArrayList<Integer> paramTypes;*/

                    opRes = cuadActual.getiResultado();
                    currentFunction = listaFunciones.get(opRes);
                    paramTypes = currentFunction.getParams_Types();
                    paramList = currentFunction.getParams_list();
                    currentFunctionReturn = currentFunction.getReturn_type();
                    i++;
                    break;
                // Return
                case 15:
                    i = currentPosStack.pop();
                    int valori = 0;
                    float valorf = 0;
                    paramTypePointer = 0;
                    opRes = cuadActual.getiResultado();

                    if(memType(opRes)==0){
                        valori = accesoMemoriaEntero(opRes);
                    }
                    else{
                        valorf = accesoMemoriaFlotante(opRes);
                    }

                    if (memoriasLocales.size()>1) {
                        memoriasLocales.remove(memoriasLocales.get(memoriasLocales.size() - 1));
                        memoriasTemporales.remove(memoriasTemporales.get(memoriasTemporales.size() - 1));
                    }

                    if(!memoriasLocales.isEmpty()){
                        memLocal = new Memoria(memoriasLocales.get(memoriasLocales.size()-1));
                        memTemporal = new Memoria(memoriasTemporales.get(memoriasLocales.size()-1));

                        memoriasLocales.set(memoriasLocales.size()-1, memLocal);
                        memoriasTemporales.set(memoriasTemporales.size()-1, memTemporal);
                    }
                        /*for (int x = 0; x < memoriasLocales.size(); x++){
                            System.out.println("=============MEMORIAS LOCALES=============");
                            memoriasLocales.get(x).showMem();
                        }*/

                    if(memType(opRes)==0){
                        returnDir = memLocal.asignacionMemoriaEntera(valori);
                    }
                    else{
                        returnDir = memLocal.asignacionMemoriaFlotante(valorf);
                    }
                    pilaRetorno.push(returnDir);
                    break;
                // Param
                case 16:
                    opRes = cuadActual.getiResultado();
                    if(paramTypePointer < paramTypes.size()){
                        if(memType(opRes)==0) {
                            if(paramTypes.get(paramTypePointer)==0) {
                                actualizarMemoriaEntero(accesoMemoriaEntero(opRes),paramList.get(paramTypePointer));
                            }else {
                                if(paramTypes.get(paramTypePointer)==1) {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected FLOAT found INT");
                                    i = cuadruplosArr.size()-2;
                                }else {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected CHAR found INT");
                                    i = cuadruplosArr.size()-2;
                                }
                            }
                        }else if(memType(opRes)==1) {
                            if (paramTypes.get(paramTypePointer) == 1) {
                                actualizarMemoriaFlotante(accesoMemoriaFlotante(opRes), paramList.get(paramTypePointer));
                            } else {
                                if (paramTypes.get(paramTypePointer) == 0) {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected INT found FLOAT");
                                    i = cuadruplosArr.size()-2;
                                } else {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected CHAR found FLOAT");
                                    i = cuadruplosArr.size()-2;
                                }
                            }
                        }else {
                            if (paramTypes.get(paramTypePointer) == 2) {
                                actualizarMemoriaChar(accesoMemoriaChar(opRes), paramList.get(paramTypePointer));
                            } else {
                                if (paramTypes.get(paramTypePointer) == 0) {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected INT found CHAR");
                                    i = cuadruplosArr.size()-2;
                                } else {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected FLOAT found CHAR");
                                    i = cuadruplosArr.size()-2;
                                }
                            }
                        }
                    }

                    paramTypePointer++;
                    i++;
                    break;
                // GOTO
                case 17:
                    opRes = cuadActual.getiResultado();
                    i = opRes;
                    break;
                // GOTOF
                case 18:
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    if(valIzq == 1){
                        i++;
                        break;
                    }
                    opRes = cuadActual.getiResultado();
                    i = opRes;
                    break;
                // CONTEXTO
                case 19:
                    i++;
                    break;
                // VER
                case 20:
                    opIzq = cuadActual.getiIzquierda();
                    valIzq = accesoMemoriaEntero(opIzq);
                    opDer = cuadActual.getiDerecha();
                    opRes = cuadActual.getiResultado();
                    if(valIzq<opDer || valIzq>=opRes){
                        System.out.println("Error found At line " + cuadActual.getiNumero()+" Array out of bounds");
                        end = true;
                        break;
                    }
                    i++;
                    break;
                // GOSUB
                case 21:
                    opRes = cuadActual.getiResultado();
                    currentPosStack.push(i+1);

                    memoriasLocales.add(new Memoria(memLocal));
                    memoriasTemporales.add(new Memoria(memTemporal));

                    paramTypePointer = 0;
                    i = opRes;
                    break;
                // EOF
                case 22:
                    System.out.println("\nBuild Successfull.");
                    end = true;
                    break;
                //END PROC
                case 23:
                    i = currentPosStack.pop();
                    break;
            }
        }
    }
}


