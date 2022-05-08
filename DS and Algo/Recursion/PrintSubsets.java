public class PrintSubsets{
    public static void main(String[] args){
        subsets("ABC", "", 0);
    }

    public static void subsets(String s, String curr, int index){
        if(s.length()==index){
            System.out.print(curr+" ");
            return;
        }
        subsets(s,curr,index+1);
        subsets(s,curr+s.charAt(index),index+1);
    }
}