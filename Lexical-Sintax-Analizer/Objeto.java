import java.lang.reflect.Type;
import java.util.Set;

public class Objeto<T> {
    T value;
    int type = -1;
    int paramsNum;
    T ret;
    String status = "ok";

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

    public String toString() {
        return "[type: "+type+" , Value: " + this.value + "]";
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
}
