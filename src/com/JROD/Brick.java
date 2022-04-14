package com.JROD;
import java.text.DecimalFormat;
public class Brick {
    private double Brick_Length;
    private double Brick_Width;
    private double Wall_Length;
    private double Wall_Height;
    private double WallSQFT;
    private double BrickSQft;
    private DecimalFormat df = new DecimalFormat("###,###,##0");

    public Brick(double brick_length,double brick_Width,double wall_Length,double wall_Height){
        Brick_Length = brick_length;
        Brick_Width = brick_Width;
        Wall_Length = wall_Length;
        Wall_Height = wall_Height;
        WallSQFT =0;
        Brick_Width = 0;
    }
    private double getWallSqFT(){ // Gets the square feet of the wall
        return WallSQFT;
    }
    public void setWallSQFT(){
        WallSQFT = Wall_Height  * Wall_Length; // sets the square feet of the wall
    }
    private double getBrickSQft(){  // gets the sqft of the brick used

        return BrickSQft;
    }
    public void setBrickSQft(){ // gets the square feet of the brick used
        //double mortorjoint = (3/8)/12;// The measurement of the mortorjoint 3/8 in / 12
        //Brick_Length = Brick_Length + mortorjoint; // add the joint measurement for each brick
        //Brick_Width = Brick_Width + mortorjoint;// add the joint measurement for each brick
        BrickSQft = Brick_Length * Brick_Width;
    }
    private double getBricks() {
        double bricks; // initialize the variable of bricks
        bricks = getWallSqFT()/getBrickSQft();  // gets the number of bricks needed by dividing the wall's
        // total square feet and the yield of a single brick.
        return bricks;
    }
    public String toString(){
        return "Bricks needed: " + df.format(getBricks());
    }
}
