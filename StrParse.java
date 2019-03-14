import java.util.ArrayList;
import java.util.List;



public class StrParse 
{
	public static String GetName(String s) 
	{
		
		// ******* Storing the Indexes of Space ********
		
		List<Integer> SpaceIndex = new ArrayList<Integer>();
        int index = s.indexOf(' ');
   
        while (index >= 0) 
        {
            SpaceIndex.add(index);
            index = s.indexOf(' ', index + 1);
        }
        
        // System.out.println(SpaceIndex);
        
        //******* Extracting Name **********
        
        String Name = s.substring(SpaceIndex.get(0)+1, SpaceIndex.get(1));
        //System.out.println(Name);
            
        return(Name);
	}
	
	
	public static Float GetCGPA(String s) 
	{
		
        // ******* Storing the Indexes of Space ********
        
		List<Integer> SpaceIndex = new ArrayList<Integer>();
        int index = s.indexOf(' ');
   
        while (index >= 0) 
        {
            SpaceIndex.add(index);
            index = s.indexOf(' ', index + 1);
        }
        
        // System.out.println(SpaceIndex);
        
        //******* Extracting CGPA**********
      
        String cgpa = s.substring(SpaceIndex.get(1)+1, SpaceIndex.get(2));
        Float CGPA = Float.parseFloat(cgpa);
        //System.out.println(CGPA);
          
        return(CGPA);
	}
	
	
	public static int GetToken(String s) 
	{
		
        // ******* Storing the Indexes of Space ********
        
		List<Integer> SpaceIndex = new ArrayList<Integer>();
        int index = s.indexOf(' ');
   
        while (index >= 0) 
        {
            SpaceIndex.add(index);
            index = s.indexOf(' ', index + 1);
        }
        
        // System.out.println(SpaceIndex);
        
        //******* Extracting Token **********
         
        String token = s.substring(SpaceIndex.get(2)+1, s.length());   
        int TOKEN = Integer.parseInt(token);
        //System.out.println(TOKEN);
        
        return(TOKEN);
	}


	
	
}
