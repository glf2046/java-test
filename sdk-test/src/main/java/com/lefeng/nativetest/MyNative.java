package com.lefeng.nativetest;

public class MyNative
{
    public void showParams( String s, int i, boolean b )
    {
        showParams0( s, i , b );
    }
    private native void showParams0( String s, int i, boolean b );
    static
    {
        System.loadLibrary( "MyNative" );
    }
}
