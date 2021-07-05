package com.lefeng.generic;

public class RawType {
    public static void main(String[] args){
        Box<Integer> bi;
        bi = createBox();
    }

    static Box createBox(){
        return new Box();
    }
}

class Box<T>{

}
