


/**
 * Created by Rose on 1/27/17.
 * Assignment for your lecture 3. Please finish all the questions under
 * 'Assignment'. Please try to think the extra credit questions. The deadline
 * of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
 * for any questions. Please write your comments about this assignment in the
 * end.
 */


public class Assignment3 {
    /**
     *  Given an array, reverse the elements within this array and print the result
     *  eg, given{1,2,3,4}, print{4,3,2,1}
     * @return 
     */
    public static void reverseArray(int[] nums) {
        
	//write your code here
	//FL' code:
		for( int i = 0; i < nums.length; i++) {
			int b = nums[(nums.length -1 - i)];
			System.out.print(b + " ");
		}
		//return nums; 
	}		
	//Q:There some solution like sample show later, which is more based on array concept, is this normal or better solution? :for(int i=0,int J<arr.length-1;i<j;i++,j--) temp =a[i];a[i]=a[j];a[j]=temp;
 	//solution 2 could be array=>string, but the output would be string by print, so it's still good for this Q?
	/**
     *  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     *  Assume the integer do not contain any leading zero, except the number 0 itself.
     *  The digits are stored such that the most significant digit is at the head of the array.
     *  eg, given {1,2,9}, return{1,3,0}.
     */
    public static void plusOne(int[] digits) {
        //write your code here
        //Q:the output should be array {} not just a list of no.?
        //FL'code:
        //Q:The logic is: I setup another method to locate the first int which is not equal to "9", but why I also got the "method return" things?
        int x = locateNine();      
        for( int i = 0; i < digits.length; i++) {
        	if( x == digits.length-1) {
    			System.out.print(digits[i] + " ");    			
        	}else {
        		while ( i < (x-1)) {
        			System.out.print(digits[i] + " ");       			
        		}
        		while (i == (x-1)) {
        			System.out.print(digits[(x-1)] + 1 + " ");     		
        		}
        		while (i >= x) {
        			System.out.print(0 + " ");	
        		}
        	}	
        } 
    }		   		
	    public static void locateNine(int[] digits){
	    	
	    	int b;
	    	for ( int j = digits.length-1;j >= 0; j = j - 1) {
    			if( digits[j] != 9) {
    				System.out.println(j);   				
    			}
	    	}		
	    }	   		
       		
       
    /**
     *  Assume you have a method isSubstring which checks if one word is a substring of another.
     *  Given two strings, s1 and s2, write a program to check if s2 is a rotation of s1, using only one call
     *  to isSubstring
     *  eg, "pineapple" is a rotation of "neapplepi"
     */
    public boolean isRotation(String s1, String s2) {

		if ( s1.length() == 0) {
			return false;
		}else if (s1.length() < s2.length()) {
			return false;
		}else if ( isSubString(s1,s2)) {
			if (s1.length() == s2.length()) {
			// I actually try to do the "isPermutation" first, but I failed to figure out a way to define the in the char's location in the string.
			// And I keep the solution below I found from google(blue part), it's a really smart way!
			}
		}
	return false;
    }
    /***
     * public boolean isRotated(String s1, String s2){
		if(s1.length()!=s2.length()){
		return false;
				}
		String sAdd = s1 + s1;
		if(sAdd.contains(s2)){
		return true;
				}else{
		return false;
		}
	}
	***/
    
    	
    public static boolean isSubString(String s1, String s2) {
		if (s2 == null || s2.length() == 0) {
			return true;
		}
		if (s1 == null || s1.length() == 0)	{
			return false;
		}
		for (int i =0; i<= s1.length() - s2.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				if (s1.substring(i, i + s2.length()).equals(s2)) {
					return true;
				}
			} 
		}		
		return false;
    }    	
        
		
   /**
     *  Given two strings, write a method to decide if one is a permutation of the other
     *  hint: the comparison is case sensitive and whitespace is significant
     */
    public boolean isPermutation(String s1, String s2) {
    //write your code here
    //FL's code:
    if ( s1.length() == 0) {
			return false;
		}else if (s1.length() < s2.length()) {
			return false;
		}else if ( isSubString(s1,s2)) {
			if (s1.length() == s2.length()) {
			return true;
			}
		}
	return false;
    }
    
    /**
     *  Write a program to implement encoding and decoding string. The rule is simple: encode successive
     *  repeated characters by the repetition count and the character. For example, the input of encoding()
     *  is "aaaabcccaa", you should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee". Assume
     *  the string to be encoded consists of letters of the alphabet, with no digits, and the string to be
     *  decoded is a valid encoding.
     */
    public static void encoding(String s) {
        //write your code here
        //FL's code:
        int x = 0; 
        for (int i = 0; i < s.length(); i++) {	
        	while ( i < s.length() - 1) {
        		String a = s.substring(i, i+1);
        		String b = s.substring(i+1, i+2);
	        	if ( s.substring(i, i+1).equals(s.substring(i+1, i+2) )) {
	        	} else {		
	        		System.out.print(i + 1 -x + s.substring(i,i+1));
	        		x = i + 1; // to record the i when "else" run last time.      	  			
	        	}
	        	break;
        	}      	
        	while (i == s.length() - 1) {
        		System.out.print(i + 1 -x + s.substring(i,i+1));
        		break;	
        	}
        }   	
    }
    public static String decoding(String s) {
        //write your code here
 	//FL's code:
	for ( int i = 0; i < s.length(); i ++) {

		while (2 * i < s.length()) {
			Integer a = Integer.valueOf(s.substring(2 * i, 2 * i + 1));
			String b = s.substring(2 * i + 1,2 * i+ 2);
			int n = 0;
				for (int u =0; u < a; u++) {
					System.out.print(s.substring(2 * i + 1, 2 *i + 2));
				}
			i++;	  
		}
		while (2 * i == s.length()) {
			System.out.print("");
			i++;
		} 		
 	}	    
    }
    
	public static void main(String[] args) {
	String s = "aaaabcccaa";
	encoding(s);
	/*int[] a = {1,3,2,9};
	System.out.println(a[0]);
	System.out.println(a[1]);
	System.out.println(a[2]);
	System.out.println(a[3]);
	locateNine(a);
	plusOne(a);*/

	//System.out.println(a.length);
	//System.out.print(a);
	//System.out.println(b);
	}

}
    /* 	int array[] = nums; 
     	int i;
     	for (i = 0; i<nums.length; i++) {
     		System.out.print(array[nums.length-1-i]);	
     	}
     }  
     public static void main(String[] args) {
     int nums = 12345;
     char cn = Integer.toS;
     
     //int ra = reverseArray(cn);
     System.out.println(cn);
     
     }  */
        
        


