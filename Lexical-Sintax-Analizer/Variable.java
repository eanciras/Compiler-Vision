public class Variable {
    int type;  // type,in calculator expample there only is one type==> Int.
    int value; // value, the value in here is a string not a integer value.

    public Variable(int itype, int ivalue) {
        type=itype;
        value=ivalue;

    }
    public String toString() {
        return "[type: " + this.type + ", Value: " + this.value + "]";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
