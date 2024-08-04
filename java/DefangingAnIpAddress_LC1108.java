/*
	https://leetcode.com/problems/defanging-an-ip-address/
	1108. Defanging an IP Address

	Given a valid (IPv4) IP address, return a defanged version of that IP address.

	A defanged IP address replaces every period "." with "[.]".

	Example 1:
		Input: address = "1.1.1.1"
		Output: "1[.]1[.]1[.]1"

	Example 2:
		Input: address = "255.100.50.0"
		Output: "255[.]100[.]50[.]0"
	 
	Constraints:
		The given address is a valid IPv4 address.
		
	Related topic:
		String
*/		

public class DefangingAnIpAddress_LC1108 {
	public String defangIPaddr(String address) {
        String ans = address.replaceAll("\\.","[.]");
		return ans;
    }
	public static void main(String[] args) {
		DefangingAnIpAddress_LC1108 dip = new DefangingAnIpAddress_LC1108();
		
		String input1 = "1.1.1.1";
		String input2 = "255.100.50.0";
		
		System.out.println(input1 + " after defaning: " + dip.defangIPaddr(input1));
		System.out.println(input2 + " after defaning: " + dip.defangIPaddr(input2));
	}
}