//clase que representa y guarda los atributos de los cudruplos
//cuadruplo [inumero de linea, operador, operando izquierdo, operando derecho, operando resultante
public class Cuadruplo {
    //inumero := numero de linea en donde se creo el cudruplo
    //iOperador:= operador del cudruplo
    //iDerecha:= operando derecha
    //iZquierda:= operando izquierdo
    //iResultado:= operando resultante

    private int iNumero, iOperador, iDerecha, iIzquierda, iResultado;
    /*
    "+" = 0, "-" = 1, "/" = 2, "*" = 3, "==" = 4, "<=" = 5, "<" = 6,
    ">=" = 7, ">" = 8, "!=" = 9, "||" = 10, "&&" = 11 "=" = 12
    "print" = 13, "era" = 14, "retorno" = 15 "param" = 16
    */
    //contructor base
    public void Cuadruplo() {
        this.iNumero = -1;
        this.iOperador = -1;
        this.iDerecha = -1;
        this.iIzquierda = -1;
        this.iResultado = -1;
    }
    //metodo para asignar todos loa atributos del cuadruplo
    // +,-,*- .... && ,|| ver
    public void CuadruploSetComplete(int iNumero, int iOperador, int iIzquierda, int iDerecha, int iResultado) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = iDerecha;
        this.iIzquierda = iIzquierda;
        this.iResultado = iResultado;
    }

    //metodo para asignar los atributos inumero ioperador iZquierda e iresultado al cudruplo
    //cudruplos que utilizan esto =, gotof,param
    public void CuadruploSetIzqRes(int iNumero, int iOperador, int iIzquierda, int iResultado) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = -1;
        this.iIzquierda = iIzquierda;
        this.iResultado = iResultado;
    }

    //metodo para asignar los atributos inumero ioperador e iresultado al cudruplo
    //cudruplos que utilizan esto goto, context, print, era, gosub
    public void CuadruploSetRes(int iNumero, int iOperador, int iResultado) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = -1;
        this.iIzquierda = -1;
        this.iResultado = iResultado;
    }

    //metodos de acceso y retorno de los atributos

    public int getiNumero() {
        return iNumero;
    }

    public void setiNumero(int iNumero) {
        this.iNumero = iNumero;
    }

    public int getiOperador() {
        return iOperador;
    }

    public void setiOperador(int iOperador) {
        this.iOperador = iOperador;
    }

    public int getiDerecha() {
        return iDerecha;
    }

    public void setiDerecha(int iDerecha) {
        this.iDerecha = iDerecha;
    }

    public int getiIzquierda() {
        return iIzquierda;
    }

    public void setiIzquierda(int iIzquierda) {
        this.iIzquierda = iIzquierda;
    }

    public int getiResultado() {
        return iResultado;
    }

    public void setiResultado(int iResultado) {
        this.iResultado = iResultado;
    }

    //metodo para imprimir los cuadruplos
    public String toString() {
        String op = "";
        switch (iOperador) {
            case 0:
                op = "+";
                break;
            case 1:
                op = "-";
                break;
            case 2:
                op = "/";
                break;
            case 3:
                op = "*";
                break;
            case 4:
                op = "==";
                break;
            case 5:
                op = "<=";
                break;
            case 6:
                op = "<";
                break;
            case 7:
                op = ">=";
                break;
            case 8:
                op = ">";
                break;
            case 9:
                op = "!=";
                break;
            case 10:
                op = "||";
                break;
            case 11:
                op = "&&";
                break;
            case 12:
                op = "=";
                break;
            case 13:
                op = "print";
                break;
            case 14:
                op = "era";
                break;
            case 15:
                op = "return";
                break;
            case 16:
                op = "param";
                break;
            case 17:
                op = "GOTO";
                break;
            case 18:
                op = "GOTOF";
                break;
            case 19:
                op = "CONTXT";
                break;
            case 20:
                op = "VER";
                break;
            case 21:
                op = "GOSUB";
                break;
            case 22:
                op = "EOF";
                break;
            case 23:
                op = "END_PROC";
                break;
        }
        return "["+iNumero+",\t"+ op + ",\t" + iIzquierda + ",\t" + iDerecha + ",\t" + iResultado +   "]";
    }
}

