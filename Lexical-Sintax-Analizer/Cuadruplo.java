public class Cuadruplo {
    private int iNumero, iOperador, iDerecha, iIzquierda, iResultado;
    /*
    "+" = 0, "-" = 1, "/" = 2, "*" = 3, "==" = 4, "<=" = 5, "<" = 6,
    ">=" = 7, ">" = 8, "!=" = 9, "||" = 10, "&&" = 11 "=" = 12
    "print" = 13, "era" = 14, "retorno" = 15 "param" = 16
    */

    public void Cuadruplo() {
        this.iNumero = -1;
        this.iOperador = -1;
        this.iDerecha = -1;
        this.iIzquierda = -1;
        this.iResultado = -1;
    }

    public void CuadruploSetComplete(int iNumero, int iOperador, int iIzquierda, int iDerecha, int iResultado) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = iDerecha;
        this.iIzquierda = iIzquierda;
        this.iResultado = iResultado;
        //System.out.println("Debug" + "["+iNumero+",\t"+ iOperador + ",\t" + iIzquierda + ",\t" + iDerecha + ",\t" + iResultado +   "]");
    }

    public void CuadruploSetIzqRes(int iNumero, int iOperador, int iIzquierda, int iResultado) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = -1;
        this.iIzquierda = iIzquierda;
        this.iResultado = iResultado;
    }


    public void CuadruploSetIzq(int iNumero, int iOperador, int iIzquierda) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = iDerecha;
        this.iIzquierda = -1;
        this.iResultado = -1;
    }


    public void CuadruploSetRes(int iNumero, int iOperador, int iResultado) {
        this.iNumero = iNumero;
        this.iOperador = iOperador;
        this.iDerecha = -1;
        this.iIzquierda = -1;
        this.iResultado = iResultado;
    }

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
        }
        return "["+iNumero+",\t"+ op + ",\t" + iIzquierda + ",\t" + iDerecha + ",\t" + iResultado +   "]";
    }
}

