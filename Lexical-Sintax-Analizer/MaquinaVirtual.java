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
        float valDer,valIzq,valRes;

        Function currentFunction;
        int currentPos = cuadruplosArr.size()-1;
        int currentFunctionReturn = -1;
        int paramTypePointer = 0;
        ArrayList<Integer> paramTypes = new ArrayList<>();
        ArrayList<Integer> paramList = new ArrayList<>();

        Stack<Memoria> memoriasLocales = new Stack<>();
        Stack<Memoria> memoriasTemporales = new Stack<>();
        while(!end){
            cuadActual = cuadruplosArr.get(i);
            operador=cuadActual.getiOperador();
            switch (operador) {
                //+
                case 0:
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
                    if(memType(opDer)==0){
                        valDer = accesoMemoriaEntero(opDer);
                    }
                    else{
                        valDer = accesoMemoriaFlotante(opDer);
                    }
                    opRes = cuadActual.getiResultado();
                    if(memType(opRes)==0){
                        actualizarMemoriaEntero((int)(valIzq + valDer),opRes);
                    }
                    else{
                        actualizarMemoriaFlotante(valIzq + valDer,opRes);
                    }
                    i++;
                    break;
                //-
                case 1:
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    opIzq = cuadActual.getiIzquierda();
                    if(memType(opIzq)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                    }
                    opDer = cuadActual.getiDerecha();
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
                    if(memType(opRes)==0){
                        valIzq = accesoMemoriaEntero(opIzq);
                        actualizarMemoriaEntero((int) valIzq,opRes);
                    }
                    else{
                        valIzq = accesoMemoriaFlotante(opIzq);
                        actualizarMemoriaFlotante(valIzq,opRes);
                    }
                    i++;
                    break;
                // print
                case 13:
                    opRes = cuadActual.getiResultado();
                    if(memType(opRes)==0) {
                        System.out.print(Integer.toString(accesoMemoriaEntero(opRes)));
                    }else if(memType(opRes)==1){
                        System.out.print(Float.toString(accesoMemoriaFlotante(opRes-20000)));
                    }else {
                        char txt[] = accesoMemoriaChar(opRes);
                        System.out.print(new String(txt));
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

                    memoriasLocales.push(memLocal);
                    memoriasTemporales.push(memTemporal);

                    i++;
                    break;
                // Return
                case 15:
                    i = currentPos;
                    currentPos = cuadruplosArr.size()-1;
                    paramTypePointer=0;
                    if(!memoriasLocales.empty()) {
                        memLocal = memoriasLocales.pop();
                        memTemporal = memoriasTemporales.pop();
                    }
                    opRes = cuadActual.getiResultado();
                    //TODO asign return value to variable
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
                                }else {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected CHAR found INT");
                                }
                            }
                        }else if(memType(opRes)==1) {
                            if (paramTypes.get(paramTypePointer) == 1) {
                                actualizarMemoriaEntero(accesoMemoriaEntero(opRes), paramList.get(paramTypePointer));
                            } else {
                                if (paramTypes.get(paramTypePointer) == 0) {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected INT found FLOAT");
                                } else {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected CHAR found FLOAT");
                                }
                            }
                        }else {
                            if (paramTypes.get(paramTypePointer) == 2) {
                                actualizarMemoriaEntero(accesoMemoriaEntero(opRes), paramList.get(paramTypePointer));
                            } else {
                                if (paramTypes.get(paramTypePointer) == 0) {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected INT found CHAR");
                                } else {
                                    System.out.println("Error found at line " + cuadActual.getiNumero() + ". Expected FLOAT found CHAR");
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
                    currentPos = i+1;
                    i = opRes;
                    break;
                // EOF
                case 22:
                    System.out.println("\nEnd of execution");
                    end = true;
                    break;
            }
        }
    }
}


