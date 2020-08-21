package com.company;

public class Holes {
    //if mole = true, then this hole has a mole.
    private boolean mole;

    //A constructor used for initialization.
    Holes(boolean m){
        this.mole = m;
    }

    //Let external class change the state of hole.
    public void setMole(boolean x){
        mole = x;
    }
    //Let external class get the state of hole
    public boolean getMole(){
        return mole;
    }
}
