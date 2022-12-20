package second;
import java.util.Hashtable;
import java.util.Scanner;
public class HashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		
		Hashtable<Character,String> map = new Hashtable<Character,String>();
	    
		map.put('A',"Apple");
		map.put('B',"Banana");
		map.put('C',"Carrot");
		map.put('D',"DragonFruit");
		System.out.println(map.get('C'));
	}

}
