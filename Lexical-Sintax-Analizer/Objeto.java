import java.lang.reflect.Type;
import java.util.Set;

//clase con los atributos de las variables que se utilizan en el compilador
public class Objeto<T> {
    //valor que tiene la variable asignado
    T value;
    //valor que representa el tipo de la variable
    int type = -1;
    //auxiliar para detectar si existe en algun contexto o tabla de variables
    String status = "ok";
    //id de la variable
    String id = "m";
    //direccion de memoria en la que se encentra el valor
    int direccion = 0;
    //booleana que inidica si la variable es dimensionada
    boolean bDim = false;
    //tamaño de las varaibles con dimensiones
    int size=0;

    //constructores
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
    //funcion paraa imprimir las variables y saber el tipo su id el valor que tiene la direccion y el tamño de su dimension
    //debuging purposes
    public String toString() {
        return "[type: "+type+ " id: " + this.id  + " , Value: " + this.value + " Dir: " + this.direccion  +" Size: " + this.size +  "]";
    }

    //metodos de acceso y asignacion de los atributoss
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