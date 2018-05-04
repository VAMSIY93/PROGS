import java.io.*;
import java.util.*;

class WildCardMatching {
	public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int i=0, j=0;

        if(plen==1 && p.charAt(0)=='*')
        	return true;

        while(i<slen && j<plen) {
        	System.out.println("i:"+i+"  j:"+j);
        	if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
        		i++;
        		j++;
        	} else if(p.charAt(j)=='*') {
        		j++;
        		if(j<plen) {
        			while(j<plen && p.charAt(j)=='*')
        				j++;

        			if(j==plen)
        				return true;

        			while(i<slen && (p.charAt(j)!=s.charAt(i) || ((i+1)<slen && p.charAt(j)==s.charAt(i+1)))) {
        				i++;

        				System.out.println("--i:"+i+"  j:"+j);
        				if(i<slen && p.charAt(j)==s.charAt(i) && (j+1)<plen && (i+1)<slen && p.charAt(j+1)!='?' && p.charAt(j+1)!=s.charAt(i+1))
        					i++;
        			}
        		} else {
        			return true;
        		}
        	} else {
        		return false;
        	}
        }

        if(i==slen && j==plen)
        	return true;
        else
        	return false;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		WildCardMatching wcm = new WildCardMatching();
		System.out.println("Enter the strings: ");
		String s = sc.next();
		String p = sc.next();

		System.out.println("Result: " + wcm.isMatch(s, p));
	}
}