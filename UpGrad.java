import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UpGrad 
{

	public static void main(String[] args) 
	{
		//****** Declarations ******
		
		Scanner in = new Scanner(System.in);
		List<String> InStream = new ArrayList<String>();
		List<Character> CheckList = new ArrayList<Character>();
		
		
		// ******* Input Number *******
		//System.out.println("Input Number");
		//int num=12;
		int num = in.nextInt();
		//System.out.println(num);
		
		String buff = in.nextLine();
		//******* Input Stream ********
		for(int i=0;i<num;i++)
		{
			String s = in.nextLine();
			InStream.add(s);
	    }
		
		//****** Context Close ********
		in.close();
		
		// ******* Iterating Stream ********
		for(int i=0;i<InStream.size();i++)
		{
			if (InStream.get(i).startsWith("ENTER"))
			{
				CheckList.add('E');
			}
			else if (InStream.get(i).startsWith("SERVED"))
			{
				CheckList.add('S');
			}
			else
			{
				CheckList.add('I');
			}
		}
		//System.out.println(CheckList);
		
		//******** Writing Logic **********
		
		List<Float> tempCGPA = new ArrayList<Float>();
		List<String> tempName = new ArrayList<String>();
		List<Integer> tempToken = new ArrayList<Integer>();
		
		for(int i=0;i<InStream.size();i++)
		{
			if(CheckList.get(i)=='S')
			{
				for(int j=0;j<i;j++)
				{
					if(CheckList.get(j)=='E')
					{
						tempCGPA.add(StrParse.GetCGPA(InStream.get(j)));
						tempName.add(StrParse.GetName(InStream.get(j)));
						tempToken.add(StrParse.GetToken(InStream.get(j)));
					}
				}
				
				float maxCGPA = Collections.max(tempCGPA);
				int maxLoc;
				
				if(Collections.frequency(tempCGPA, maxCGPA)==1)
				{
					maxLoc = Collections.binarySearch(tempCGPA, maxCGPA)+1;
					int n=0;
					int b=0;
					
					for(char g:CheckList)
					{
						if(g=='E')
						{
							n++;
						}
						if(n==maxLoc)
							break;
						b++;
					}
					
					CheckList.set(b, 'D');
				}
	
				else 
				{
					List<String> newTempName = new ArrayList<String>();
					for(int q=0;q<tempCGPA.size();q++)
					{
						if(tempCGPA.get(q)==maxCGPA)
						{
							newTempName.add(tempName.get(q));
						}
					}
					String maxName=Collections.min(newTempName);
				
					if(Collections.frequency(newTempName, maxName)==1)
					{
						int v=0;
						int maxL=0;
						for(String ab : tempName)
						{
							if(ab.equals(maxName))
							{
								maxL = v;
							}
							v++;
						}
						maxL++;
				
						//System.out.println(maxL);
						int n=0;
						int b=0;
			
						for(char g:CheckList)
						{
							if(g=='E')
							{
								n++;
							}
							if(n==maxL)
								break;
							b++;
						}		
						CheckList.set(b, 'D');
					}
					
					else
					{
						List<Integer> newTempToken = new ArrayList<Integer>();
						
						for(int q=0;q<tempName.size();q++)
						{
							if(tempName.get(q).equals(maxName))
							{
								newTempToken.add(tempToken.get(q));
							}
						}
						
						int minToken=Collections.min(newTempToken);
						
						maxLoc = Collections.binarySearch(tempToken, minToken)+1;
						int n=0;
						int b=0;
					
						for(char g:CheckList)
						{
							if(g=='E')
							{
								n++;
							}
							if(n==maxLoc)
								break;
							b++;
						}
						
						CheckList.set(b, 'D');
					}
				}
				
			}
			tempName.clear();
			tempToken.clear();
			tempCGPA.clear();
		}
		//System.out.println(CheckList);
		//System.out.println(InStream);
		int x=0;
		for(char f:CheckList)
		{
			if(f=='E')
			{
				System.out.println(StrParse.GetName(InStream.get(x)));
			}
			x++;
		}
	
	}

}
