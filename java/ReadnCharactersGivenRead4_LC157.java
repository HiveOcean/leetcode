/*
	https://leetcode.com/problems/read-n-characters-given-read4 (locked)
	https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleEasy/157.html
	157. Read N Characters Given Read4
	
	Given a file and assume that you can only read the file using a given method read4, 
	implement a method to read n characters.
	
	Method read4:
	The API 'read4' reads four conscutive characters at a time from a file, then 
	writes those character into the buffer array buf4.

	The return value is the actual number of characters read. For example, it 
	returns 3 if there is only 3 characters left in the file.
	Note that read4() has its own file pointer, much like File *fp in C.
	By using the read4 API, implement the function int read(char *buf, int n) that 
	reads n characters from the file.

	Note: The 'read' function will only be called once for each test case.
	
	-----------------------------------------------------------------------------

	Definition of read4:
		Parameter char[] buf
		Returns int 
	
	Note: buf[] is destination not source, the results from read4 will be copied to buf[]
	
	Below is a high level example of how read4 works:
		File file("abcdefghijk");	// File is "abcdefghijk"
		initially file pointer (fp) points to 'a'
		char[] buf = new char[4]	// Create buffer with enough space to store characters 
		read4(buf);		// read4 return 4.  Now buf ="abcd", fp points to 'e'
		read4(buf);		// read4 return 4.  Now buf = "efgh", fp points to 'i'
		read4(buf);		// read4 return 3.  Now buf = "ijk", fp points to end of file 

	Method read:
		By using the read4 method, implement the method read that reads n characters
		from the file and store it in the buffer array buf.  Consider that you cannot
		manipulate the file directly.
		The return value is the number of actually character read.
		
	Definition of read:
		parameter: char[] buf, int n 
		return: 	int 
		
	Example 1:
		Input: file = "abc", n = 4
		Output: 3
		Explanation: After calling your read method, buf should contain "abc".  We 
		read a total of 3 characters from the file, so return 3.  Note that "abc" is 
		the file's content, not buf.  Buf is the destination buffer that you will have
		to write the results to.
		
	Example 2:
		Input: file = "abcde", n = 5
		Output: 5
		Explanation: After calling your read method, buff should contain "abcde", we
		read a total of 5 characters from the file, so return 5.
		
	Example 3:
		Input: file = "abcdABCD1234", n = 12
		Output: 12
		Explanation: After calling your read method, buf should conatin "abcdABCD1234".
		We read a total of 12 characters from the file, so return 12.
	
	Example 4:
		Input: file = "leetcode", n = 5
		Output: 5
		Explanation: After calling your read method, buf should contain "leetc", we 
		read a total of 5 characters from the file, so return 5.
	
	Note:
	1. Consider that you cannot manipulate the file directly, the file is only accessible
	   for read4 but for read.
	2. The read function will only be called once for each test case.
	3. You may assume the destination buffer array buf, is guaranteed to have enough space
	   for storing n characters.
	   
	Constraints:
		1 <= file.length <= 500	
		file consist of English letters and digits.
		1 <= n <= 1000	   
	----------------------------------
	abcd efgh ijk 11
	case1: n = 8 first time read 4 next count == 4 index == n 
	case2: n = 7 first time read 4 next count == 4 index == n

	case:
	abc 3
	case1: n = 4 count = 3 count < 4
	time: O(n);
	space: O(1);
	
	public int read4(char[] buf) {
		char[] res = new char[10];
		char[] ret = new char[4];
		int index = 0;
		for (int i = 0; i < res.length; i++) {
			if (index < 4) {
				ret[index++] = buf[i];
			}
		}
		return index;
	}
	
		https://www.youtube.com/watch?v=dz2vDJubvhI
*/
import java.io.*;

public class ReadnCharactersGivenRead4_LC157 {
	public static RandomAccessFile input;
	public static long pointer;
	
	ReadnCharactersGivenRead4_LC157(String filename) throws Exception {
		input = new RandomAccessFile(filename, "r");
		System.out.println("Length of file: " + input.length());
		pointer = 0;
		char c;
		for (int k = 0; k < 4; k++) {
			//c = input.readChar();
			System.out.println(input.readChar());
		}
			
	}
	public static void main(String[] args) throws Exception {
		ReadnCharactersGivenRead4_LC157 rc = new ReadnCharactersGivenRead4_LC157("textfile1.dat");
		
		char[] buf = new char[4];
		
		//long num = Read4(buf);
		//System.out.println("file pointer: " + num);
		//for (char c: buf)
		//	System.out.print(" " + c);
	}
	public static long Read4(char[] buf) throws Exception {
		
		char c;
		for (int i = 0; i < 4; i++) {
		
			c = input.readChar();
			System.out.print("  " + c);
			buf[i] = c;
		}
		System.out.println("\n*****");
		pointer = input.getFilePointer();
		return pointer;
	}
}





//import java.io.Reader;
//import java.io.File;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.FileInputStream;

/*
public class ReadnCharactersGivenRead4_LC157 {
	public static File file;
	public static InputStream in;
	public static Reader reader;
	
	ReadnCharactersGivenRead4_LC157(String filename) throws Exception {
		file = new File(filename);
		in = new FileInputStream(file);
		reader = new InputStreamReader(in);
	}
	
	public static void main(String[] args)  throws Exception {
		ReadnCharactersGivenRead4_LC157 rc = new ReadnCharactersGivenRead4_LC157("textfile1.txt");
		
		char[] buf = new char[4];
		
		int num = Read4(buf);
		System.out.println("The final num is: " + num);
	}
	public static int Read4(char[] buf) throws Exception {
		/*
		 * @param buf	Destination buffer 
		 * @param n 	Number of characters to read 
		 * @return 		The number of actual characters read
		
		int index = 0, r;
		try {
			while ((r = reader.read()) != -1) {
				System.out.print(" " + r);
				if (index > 3) {
					index = 0;
				} 
				buf[index++] = (char) r;
			}
		} catch (Exception ex) {
			System.out.println("File exception!");
			return -1;
		}
		for (int k = index; k < buf.length; k++)
			buf[k] = '\u0000';
		return index;
		/*
		int r, index = 0;
		try {
			File file = new File("textfile1.txt");
			
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in);
			
			while ((r = reader.read()) != -1) {
				if (index > 3) {
					index = 0;
				} 
				buf[index++] = (char) r;
			}
			//System.out.println("Index is: " + index + " buf is: ");
			// clean up the rest of array if the final set of characters are less than 4
			for (int k = index; k < buf.length; k++)
				buf[k] = '\u0000';
			
			//for (char c: buf)
			//	System.out.print(c + " ");	
			
		} catch (Exception ex) {
			System.out.println("File exception!");
			return -1;
		}
		return index;
		*/
		/*
		char[] res = new char[10];
		char[] ret = new char[4];
		int index = 0;
		for (int i = 0; i < res.length; i++) {
			if (index < 4) {
				ret[index++] = buf[i];
			}
		}
		return index;
		
	}
	public static int Read(char[] buf, int n) {
		
		return 0;
	}
}
*/