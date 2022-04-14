package com.JROD;

public class CuFtPerUnit {
    private int Cubic_ft_perYard;
    private double Yield_60;
    private double Yield_80;
    private double Yield_40;

    public CuFtPerUnit(int ft_per, double d80, double d60, double d40){
        Cubic_ft_perYard = ft_per;
        Yield_80 = d80;
        Yield_60 = d60;
        Yield_40 = d40;
    }
    public int getCu_ft_perYard(){

        return Cubic_ft_perYard;
    } //gets yield or cubic-ft in a yard
    public double getYield_80(){

        return Yield_80;
    } //gets yield or cubic ft per 80lb bags
    public double getYield_60(){

        return Yield_60;
    } //gets yield or cubic ft per 60lb bags
    public double getYield_40(){

        return Yield_40;
    }  //gets yield or cubic ft per 40lb bags
}
