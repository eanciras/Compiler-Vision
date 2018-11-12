import java.lang.reflect.Type;
import java.util.Set;

public class Objeto<T> {
    T value;
    int type = -1;
    int paramsNum;
    T ret;
    String status = "ok";
    String id = "m";
    int iDireccion = 0;

    public Objeto(){
        //placeholder
    }

    public Objeto(String status){
        this.status = status;
    }

    public Objeto(int type, int paramsNum, T ret){
        this.type = type;
        this.paramsNum = paramsNum;
        this.ret = ret;
    }

    public Objeto(int type, T value) {
        this.type= type;
        this.value = value;

    }
    public Objeto(int type, T value , String id, int iDireccion) {
        this.type= type;
        this.value = value;
        this.id  = id;
        this.iDireccion = iDireccion;

    }
    public Objeto(int type, String id, int iDireccion) {
        this.type= type;
        this.id  = id;
        this.iDireccion = iDireccion;
    }

    public String toString() {
        return "[type: "+type+ " id: " + this.id  + " , Value: " + this.value + " Dir: " + this.iDireccion  + "]";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public int getParamsNum() {
        return paramsNum;
    }

    public void setParamsNum(int paramsNum) {
        this.paramsNum = paramsNum;
    }

    public T isRet() {
        return ret;
    }

    public void setRet(T ret) {
        this.ret = ret;
    }

    public T getRet() {
        return ret;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getiDireccion() {
        return iDireccion;
    }

    public void setiDireccion(int iDireccion) {
        this.iDireccion = iDireccion;
    }
}