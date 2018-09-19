import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/* Areeba Waheed
 * Comp 482
 * Project 2: Longest Common Subsequence of 3 Strings
 * Takes an input text file: input2.txt
 */

public class Project2 {
static String one;
static String two;
static String three;
static int [][][] commonSub;
	public static void main(String[] args) {
		int a=0;
		int b=0;
		int c=0;
		/*******Read the File*******/
		java.io.File file = new java.io.File("input2.txt");	 
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				one = scan.next();
				two = scan.next();
				three = scan.next();
			}
			scan.close();
			
			/*******Initialize the array with input lengths*******/
			commonSub = new int[one.length()+1][two.length()+1][three.length()+1]; //stores the length of common subsequence in all sequences
			/**************/
			for (int i=0; i<=one.length(); i++)
	        {
	            for (int j=0; j<=two.length(); j++)
	            {
	                for (int k=0; k<=three.length(); k++)
	                {
	                		//if any one of the string is empty, then no common subsequence
	                    if (i == 0 || j == 0 || k==0)
	                        commonSub[i][j][k] = 0;
	                    //if characters match in all the strings
	                    else if (one.charAt(i - 1) == two.charAt(j - 1) 
	                                && one.charAt(i - 1)==three.charAt(k - 1)) {
	                    	commonSub[i][j][k] = commonSub[i-1][j-1][k-1] + 1;
		                    	a=i;
		                    	b=j;
		                    	c=k;
	                    }
	                    else
	                    	//if characters don't match
	                    	commonSub[i][j][k] = Math.max(Math.max(commonSub[i-1][j][k],
	                    			commonSub[i][j-1][k]),
	                    			commonSub[i][j][k-1]);
	                }
	            }
	        }
			/*******Prints the Solution*******/
			String lcs ="";
			while(commonSub[a][b][c] != 0) {
				lcs += one.charAt(a-1);
				a--;
				b--;
				c--;
			}
			
			String reverse = new StringBuffer(lcs).reverse().toString();
			System.out.println(commonSub[one.length()][two.length()][three.length()]+"\n");
			System.out.println("because the longest common substring is " + reverse + "\n");

		}
		catch(FileNotFoundException e){	
			System.out.println("File not found\n");
		}
		
		
	}

}
