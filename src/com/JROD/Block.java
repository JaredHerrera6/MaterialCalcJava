package com.JROD;
import java.text.DecimalFormat;
public class Block {
    private double Block_Length;
    private double Block_Width;
    private double Wall_Length;
    private double Wall_Height;
    private double WallSQFT;
    private double BlockSQft;
    private DecimalFormat df = new DecimalFormat("###,###,##0");

    public Block(double block_Length, double block_Width, double wall_Length, double wall_Height) {
        Block_Length = block_Length;
        Block_Width = block_Width;
        Wall_Length = wall_Length;
        Wall_Height = wall_Height;
        WallSQFT = 0;
        BlockSQft = 0;
    }
    private double getWallSqFT(){ // Gets the square feet of the wall
        return WallSQFT;
    }
    public void setWallSQFT(){

        WallSQFT = Wall_Height * Wall_Length; // sets the square feet of the wall
    }
    private double getBlockSQft(){  // gets the sqft of the block used

        return BlockSQft;
    }

    public void setBlockSQft(){ // gets the square feet of the block used
        BlockSQft = (Block_Length * Block_Width);
    }
    private double getBlocks() {
        double blocks; // initialize the variable of blocks
        blocks = getWallSqFT()/getBlockSQft();  // gets the number of blocks needed by dividing the wall's
                                                // total square feet and the yield of a single block.
        return blocks;
    }
    public String toString(){
        return "Blocks needed: " + df.format(getBlocks());
    }
}
