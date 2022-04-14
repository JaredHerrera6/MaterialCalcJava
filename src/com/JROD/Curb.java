package com.JROD;

import java.text.DecimalFormat;

public class Curb {
    private double Length;
    private double Depth;
    private double height;
    private double width;
    private double thickness;
    private double volume;
    private CuFtPerUnit yield;
    private DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public Curb(double length, double height, double width, double thickness,double depth, CuFtPerUnit yield) {
        Length = length;
        this.height = height;
        this.width = width;
        this.thickness = thickness;
        Depth = depth;
        this.yield = yield;
        volume = 0;
    }
    private double getvolume(){
        return volume;
    }
    public void setVolume(){
        double curbVol = Depth * (height + thickness) * Length; // Calculate the total volume of the curb
        double gutterVol = width * thickness * Length;          // Calculates the total volume of the gutter
        volume = curbVol + gutterVol;     // Total volume = Curb + Gutter
    }
    private double getYards(){
        double yards;
        yards = getvolume()/yield.getCu_ft_perYard(); // find yards by dividing volume / 27
        return yards;
    }
    private double get80(){
        double bags;
        bags = getvolume()/yield.getYield_80(); // find bags by dividing volume by proper yield
        return bags;
    }
    private double get60(){
        double bags;
        bags = getvolume()/yield.getYield_60();
        return bags;
    }
    private double get40(){
        double bags;
        bags= getvolume()/yield.getYield_40();
        return bags;
    }
    public String toString(){
        return "Yards: " + df.format(getYards()) +
                "\n#80 Lbs: " + df.format(get80()) +
                "\n#60 lbs: " + df.format(get60()) +
                "\n#40 Lbs: " + df.format(get40());
    }





}
