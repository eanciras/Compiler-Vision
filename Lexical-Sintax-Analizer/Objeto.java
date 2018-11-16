import java.lang.reflect.Type;
import java.util.Set;

public class Objeto<T> {
    T value;
    int type = -1;
    String status = "ok";
    String id = "m";
    int direccion = 0;
    boolean bDim = false;
    int size=0;

    public Objeto(){

    }

    public Objeto(String status){
        this.status = status;
    }

    public Objeto(int type, T value) {
        this.type= type;
        this.value = value;

    }
    public Objeto(int type, T value , String id, int direccion) {
        this.type= type;
        this.value = value;
        this.id  = id;
        this.direccion = direccion;

    }
    public Objeto(int type, String id, int direccion) {
        this.type= type;
        this.id  = id;
        this.direccion = direccion;
    }

    public String toString() {
        return "[type: "+type+ " id: " + this.id  + " , Value: " + this.value + " Dir: " + this.direccion  +" Size: " + this.size +  "]";
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

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public boolean isbDim() {
        return bDim;
    }

    public void setbDim(boolean bDim) {
        this.bDim = bDim;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}