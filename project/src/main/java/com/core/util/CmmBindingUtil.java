package com.core.util;
public class CmmBindingUtil {
    
    public static String[] copyStringArray(String[] array){
        String[] ref = null;
        
        if(array != null){
            
            ref = new String[array.length];
            
            for(int i = 0 ; i < array.length ; i++){
                ref[i] = new String(array[i]);
            }
        }
        
        return ref;
    }

	public static int[] copyIntArray(int[] array){
        int[] ref = null;
        
        if(array != null){
            
            ref = new int[array.length];
            
            for(int i = 0 ; i < array.length ; i++){
            	 ref[i] = array[i];
            }
        }
        
        return ref;
    }
}
