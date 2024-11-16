public class palindrome {
    
    public static boolean is_Palindrome(String word){
        
        char[] CharArray = word.toCharArray();
        int start = 0;
        int end = CharArray.length-1;

        while(start<end){
            if(CharArray[start] != CharArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }


    public static void main(String[] args) {
        
        String name1 = "madam";
        String name2 = "Tree";
        System.out.println(is_Palindrome(name1));
        System.out.println(is_Palindrome(name2));
    }
}
