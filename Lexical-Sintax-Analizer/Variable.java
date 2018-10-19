import java.lang.reflect.Type;
import java.util.Set;

public class Variable<T> {
    T value;
    int type = -1;

    public Variable(int type, T value) {
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
}
