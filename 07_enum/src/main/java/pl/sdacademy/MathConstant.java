package pl.sdacademy;

public enum MathConstant {

    PI(3.14),
    G(2.097);

    private final double value;

    private MathConstant(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }


}
