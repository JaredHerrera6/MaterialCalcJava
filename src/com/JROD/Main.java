package com.JROD;

import java.sql.SQLOutput;
import java.util.*;
public class Main {
    private static CuFtPerUnit Yields = new CuFtPerUnit(27,0.6,0.45, 0.3);
                                            // SqFtPerUnit Stores the Cubicft that covered by either
                                            // yards, 60 lbs bag, or 80 lbs bag
    private static Scanner cin = new Scanner(System.in);
    private static boolean quit = false;
    private static double inches;   // used whenever both inches and ft are taken.
    public static void main(String[] args) {
        int choice;
        double Length;
        double width;
        double thickness;
        double rise;
        double run;

        while(!quit){
            choice = getSelection();
            switch (choice) {
                case 1:     //Slab
                    Slab slab;
                    System.out.println("---SLAB---");
                    Length = getDMeasurement("Enter Length(Ft): ");
                    width = getDMeasurement("Enter Width(Ft): ");
                    thickness = getDMeasurement("Enter(In.): ");
                    slab = new Slab(width,Length,thickness,Yields);// creates the slab object with measurements
                    slab.setVolume(); // creates the volume;
                    System.out.println(slab.toString());  // prints the Concrete needed
                break;

                case 2:     //Steps
                    Steps steps;
                    System.out.println("---STEPS---");
                    width = getDMeasurement("Enter Width(Ft): ");
                    rise = getDMeasurement("Enter Rise(In.): ")/12; // Turns inches to feet
                    run = getDMeasurement("Enter Run(In.): ")/12;   // Turns inches to feet
                    int StepCount = getStepCount();
                    double PlatformDepth = getDMeasurement("Enter Platform Depth(ft): ");
                    steps = new Steps(width,rise,run,StepCount,PlatformDepth,Yields); // creates the Steps object
                    steps.setVolume();//creates the volume
                    System.out.println(steps.toString()); // prints the concrete needed
                break;
                case 3:     // Footing
                    Footings footing;
                    System.out.println("---FOOTING---");
                    Length = getDMeasurement("Enter Length(Ft): ");
                    width = getDMeasurement("Enter Width(In.): ")/12;     //Turns inches to feet
                    thickness = getDMeasurement("Enter Depth(In.): ")/12; //Turns inches to feet
                    footing = new Footings(width,Length,thickness,Yields); // creates Footing object
                    footing.setVolume();
                    System.out.println(footing.toString()); // prints concrete needed
                    break;
                case 4:     //Walls,  Length,Thickness,Height
                    Walls walls;
                    System.out.println("---Walls---");
                    Length = getDMeasurement("Enter Length(Ft): ");
                    double height = getDMeasurement("Enter Height(Ft.): ");
                    thickness = getDMeasurement("Enter Thickness(In.): ")/12; //Turns inches to feet
                    walls = new Walls(Length,height,thickness,Yields);      //Creates Walls object
                    walls.setVolume();
                    System.out.println(walls.toString());// prints concrete needed
                    break;
                case 5:     //Curb
                    Curb curb;
                    System.out.println("---Curb---");
                    Length = getDMeasurement("Enter Length(Ft.): ");
                    double CurbDepth = getDMeasurement("Enter Curb Depth(In.): ")/12;//Turns inches to ft /12
                    double curbHeight = getDMeasurement("Enter Curb Height(In): ")/12;//Turns inches to ft /12
                    width = getDMeasurement("Enter Gutter Width(In.): ")/12;//Turns inches to ft /12
                    thickness = getDMeasurement("Enter Flag Thickness(In.): ")/12;//Turns inches to ft /12
                    curb = new Curb(Length,curbHeight,width, thickness,CurbDepth,Yields); // Creates curb object
                    curb.setVolume();
                    System.out.println(curb.toString());
                    break;
                case 6:     //Columns
                    Column column;
                    System.out.println("---Column---");
                    Length = getDMeasurement("Enter Length(In.): ")/12;//Turns inches to feet
                    width = getDMeasurement("Enter Width(In.):  +")/12;//Turns inches to feet
                    height = getDMeasurement("Enter Height(Ft.): ");
                    column = new Column(Length,width,height,Yields); //  Creates column object
                    column.setVolume();
                    System.out.println(column.toString());
                    break;
                case 7:     //Block
                    Block blocks;
                    System.out.println("---Blocks---");
                    Length = getDMeasurement("Enter Block Length(In.): ")/12;//Turns inches to feet,Block length
                    width = getDMeasurement("Enter Block Width(In.): ")/12;//Turns inches to feet,Block width
                    double wallLength = getDMeasurement("Enter Block wall Length(ft): ");//Wall Length
                    height = getDMeasurement("Enter Wall height(Ft): ");//Wall height
                    blocks = new Block(Length,width,wallLength,height);
                    blocks.setWallSQFT();
                    blocks.setBlockSQft();
                    System.out.println(blocks.toString());
                    break;
                case 8:     //Brick
                    Brick bricks;
                    System.out.println("---Bricks---");
                    Length = getDMeasurement("Enter Brick Length(In.): ")/12;//Turns inches to feet, Brick Length
                    width = getDMeasurement("Enter Brick Width(In.): ")/12;//Turns inches to feet,Brick width
                    wallLength = getDMeasurement("Enter wall length(Ft): ");// wall length
                    height = getDMeasurement("Enter Wall Height(Ft): ");//Wall Height
                    bricks = new Brick(Length,width,wallLength,height);
                    bricks.setBrickSQft();
                    bricks.setWallSQFT();
                    System.out.println(bricks.toString());
                    break;
                case 9:     //Quit
                    quit = true; // quit == true, the program ends.
                    break;
            }
        }
    }
    private static int getSelection(){
        int choice;
        System.out.println("Pour/Type:");
        System.out.println("1 - Slab");
        System.out.println("2 - Steps");
        System.out.println("3 - Footing ");
        System.out.println("4 - Wall");
        System.out.println("5 - Curb");
        System.out.println("6 - Columns");
        System.out.println("7 - Block");
        System.out.println("8 - Brick");
        System.out.println("9 - Quit");
        choice = cin.nextInt();
        return choice;
    }
    private static double getDMeasurement(String sLine){
        System.out.println(sLine);
        double Measurement = cin.nextDouble();
        return Measurement;
    }
    private static int getStepCount(){
        int steps;
        System.out.println("Enter Step Count: ");
        steps = cin.nextInt();
        return steps;
    }

}
