package com.JROD;

import java.text.DecimalFormat;

public class Slab {
    private double iWidth;
    private double iLength;
    private double thickness;
    private CuFtPerUnit yield;
    private double volume;
    private DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public Slab(double width,double length,double thickness,CuFtPerUnit yields){
        iWidth = width;
        iLength = length;
        this.thickness = thickness;
        yield = yields;
        volume = 0;
    }
    public double getVolume(){
        return volume;
    }
    public void setVolume(){
        thickness = thickness/12; // turns the thickness into feet
        volume = thickness * iLength * iWidth;  // find the volume using L * W * H
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
