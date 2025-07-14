package Recursion;
import java.util.*;
public class GenerateIpsOfString {
    public static void main(String[] args) {
        String s = "25525511135";
        ArrayList<String> list = new ArrayList<>();
        helper(s,0,0,"",list);
        System.out.println(list);
    }
    private static void helper(String s, int idx, int dots, String res, ArrayList<String> ans){
        if(dots == 4 && idx == s.length()){ // Base
            ans.add(res.substring(0,res.length()-1));
            return;
        }

        if(dots > 4){
            return;
        }

        for(int j = idx; j < Math.min(idx+3,s.length());j++){
            int currnum = Integer.parseInt(s.substring(idx,j+1));
            if(currnum <= 255 && (idx == j || s.charAt(idx) != '0')){
                helper(s,j+1,dots+1,res + s.substring(idx,j+1) + ".",ans);
            }
        }
    }
}
