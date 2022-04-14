package com.JROD;
import java.text.DecimalFormat;
import java.util.List;

public class Column {
    private double Width;
    private double Length;
    private double Height;
    private CuFtPerUnit yield;
    private double volume;
    private DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public Column(double length, double width, double height,CuFtPerUnit yields) {
        Width = width;
        Length = length;
        Height = height;
        this.yield = yields;
        volume = 0;
    }
    public double getVolume(){
        return volume;
    }
    public void setVolume(){
        volume = Width * Length * Height;
    }
    private double getYards(){
        double yards;
        yards = getVolume()/ yield.getCu_ft_perYard(); // find yards by dividing volume / 27
        return yards;
    }
    private double get80(){
        double bags;
        bags = getVolume()/yield.getYield_80(); // find bags by dividing volume by proper yield
        return bags;
    }
    private double get60(){
        double bags;
        bags = getVolume()/yield.getYield_60();
        return bags;
    }
    private double get40(){
        double bags;
        bags=  getVolume()/yield.getYield_40();
        return bags;
    }
    public String toString(){
        return "Yards: " + df.format(getYards()) +
                "\n#80 Lbs: " + df.format(get80()) +
                "\n#60 lbs: " + df.format(get60()) +
                "\n#40 Lbs: " + df.format(get40());
    }
}