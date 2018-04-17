import java.io.*;
import java.util.*;

public class SimplePath
{
    public String simplifyPath(String path) 
    {
        int len = path.length();
        String res="";
        for(int i=len-1;i>=0;i--)
        {
        	if(i==(len-1) && path.charAt(i)=='/')
        	{}
        	else if(path.charAt(i)=='/' && (i+1)<len && path.charAt(i+1)=='/')
        	{}
        	else if(path.charAt(i)=='.' && (i+1)<len && path.charAt(i+1)=='/')
	        	break;
	        else
	        	res=""+path.charAt(i)+res;
        }
        return res;
    }
}