package com.JROD;

import java.text.DecimalFormat;

public class Walls {
    private double Length;
    private double thickness;
    private double Height;
    private CuFtPerUnit yield;
    private double Volume;
    private DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public Walls(double length, double thickness, double height, CuFtPerUnit yield) {
        Length = length;
        this.thickness = thickness;
        Height = height;
        this.yield = yield;
        Volume = 0;
    }
    public double getVolume(){
        return Volume;
    }
    public void setVolume(){
        Volume = thickness * Length * Height;  // find the volume using L * W * H
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
        bags = getVolume()/yield.getYield_40();
        return bags;
    }
    public String toString(){
        return "Yards: " + df.format(getYards()) +
                "\n#80 Lbs: " + df.format(get80()) +
                "\n#60 lbs: " + df.format(get60()) +
                "\n#40 Lbs: " + df.format(get40());
    }
}
