package com.JROD;

import java.text.DecimalFormat;

public class Steps { // check back , must be more precise
    private double Width;
    private double rise;
    private double run;
    private int steps;
    private double PlatformD;
    private CuFtPerUnit Yield;
    private double Volume;
    private DecimalFormat df = new DecimalFormat("###,###,##0.00");

    public Steps(double width, double rise, double run, int steps, double platformD, CuFtPerUnit yield) {
        Width = width;
        this.rise = rise;
        this.run = run;
        this.steps = steps;
        PlatformD = platformD;
        Yield = yield;
        Volume = 0;
    }

    private double getVUnderPlat() {          // gets the volume under the platform
        double R;      // PlatformDepth * Rise * Width
        double platVolume;
        R = PlatformD * rise * Width;
        platVolume = R * steps;         //Platform Vol = R * num of steps
        return platVolume;
    }

    private double getVUnderStairs() {
        int i;
        double StairVol;
        double TotalVol = 0;
        double R = rise * run * Width;
        for (i = 1; i <= steps; i++) {        // iterates through each step to find its volume
            StairVol = i * R;
            TotalVol = TotalVol + StairVol;   // adds each step Vol to total
        }
        return TotalVol;
    }
    private double getVolume(){
        return Volume;
    }
    public void setVolume() {         // Find the total  volume
        double StairVolume = getVUnderStairs();
        double PlatVolume = getVUnderPlat();
        Volume = StairVolume + PlatVolume;  // adds both of the volumes to find total
    }

    private double getYards() {   //method finds the concrete yards needed
        double yards;
        yards = getVolume()/ Yield.getCu_ft_perYard(); // find yards by dividing volume / 27
        return yards;
    }

    private double get80() {
        double bags;
        bags = getVolume() / Yield.getYield_80(); // find bags by dividing volume by proper yield
        return bags;
    }

    private double get60() {
        double bags;
        bags = getVolume() / Yield.getYield_60();
        return bags;
    }

    private double get40() {
        double bags;
        bags = getVolume() / Yield.getYield_40();
        return bags;
    }

    public String toString() {
        return "Yards: " + df.format(getYards()) +
                "\n#80 Lbs: " + df.format(get80()) +
                "\n#60 lbs: " + df.format(get60()) +
                "\n#40 Lbs: " + df.format(get40());
    }
}
