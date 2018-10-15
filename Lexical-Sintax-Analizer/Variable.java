public class Variable {
    int type;
    int valueI;
    float valueF;
    char valueC;

    public Variable(int type, int value) {
        this.type= type;
        this.valueI = value;

    }

    public Variable(int type, float value) {
        this.type= type;
        this.valueF = value;

    }

    public Variable(int type, char value) {
        this.type= type;
        this.valueC = value;

    }

    /*public String toString() {
        return "[type: " + this.type + ", Value: " + this.valueI + "]";
    }*/

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValueI() {
        return valueI;
    }

    public void setValueI(int valueI) {
        this.valueI = valueI;
    }

    public float getValueF() {
        return valueF;
    }

    public void setValueF(float valueF) {
        this.valueF = valueF;
    }

    public char getValueC() {
        return valueC;
    }

    public void setValueC(char valueC) {
        this.valueC = valueC;
    }
}
