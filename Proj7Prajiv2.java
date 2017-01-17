import java.io.*;
import java.util.*;

public class Proj7Prajiv2
{ static int size=10;
  static Airport [] air;
  static Filess files;
 public static void main (String[] args)
 {
  
   Scanner sc = new Scanner ( System.in );
   
   Proj7Prajiv2 airportData = new Proj7Prajiv2();
   
   
   
   files= new Filess(-1);
 
   
   air = new Airport[size];
   air[0]=null;
   
   for(int i=1;i<size;i++)
     air[i]= new Airport(i);
   
   airportData.processCommandLoop (sc,1);
  System.out.println ("Goodbye");
   
   
 
 
 
 }
   
   
  public void processCommandLoop (Scanner sc,int t)
  {
   // loop until all integers are read from the file
   while (sc.hasNext())
   {
     String command = sc.next();
     System.out.println ("*" + command + "*");
     
     if (command.equals("q") == true)
       System.exit(1);
     
     else if (command.equals("?") == true)
       showCommands();
     
     else if (command.equals("t") == true)
       doTravel(sc);
     
     else if (command.equals("r") == true)
       doResize(sc);

     else if (command.equals("i") == true)
       doInsert(sc);

     else if (command.equals("d") == true)
       doDelete(sc);

     else if (command.equals("l") == true)
       doList(sc);

     else if (command.equals("f") == true)
       doFile(sc);

     else if (command.equals("#") == true)
       ;
     
     else
       System.out.println ("Command is not known: " + command);
     
     if(t==1)
     sc.nextLine();

  }

 }
 
 public void showCommands()
 {
   System.out.println ("The commands for this project are:");
   System.out.println ("  q ");
   System.out.println ("  ? ");
   System.out.println ("  # ");
   System.out.println ("  t <int1> <int2> ");
   System.out.println ("  r <int> ");
   System.out.println ("  i <int1> <int2> ");
   System.out.println ("  d <int1> <int2> ");
   System.out.println ("  l ");
   System.out.println ("  f <filename> ");
 }
 
 public void doTravel(Scanner sc)
 {
   int val1 = 0;
   int val2 = 0;
   
   if ( sc.hasNextInt() == true )
     val1 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if ( sc.hasNextInt() == true )
     val2 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   System.out.println ("Performing the Travel Command from " + val1 +
                       " to " + val2);
   
   depthFirstSearchHelper (val1,val2);
 }   
 
 
public void depthFirstSearchHelper (int x, int y)
{
for(int i=1;i<size;i++)
{ 
if(air[i].head!=null)
 air[i].head.visit='N';
} 
  if (dfs(x,y) == true)
 System.out.println ("You can get from airport " + x + " to airport " + y + " in one or more flights");
 else
 System.out.println ("You cannot get from airport " + x + " to airport " + y + " in one or more flights");
}



 
 public boolean dfs (int a, int b)
{
   
 for(Node tem=air[a].head; tem!=null;) 
 {int c=tem.data;
 if (c == b)
 return true;
 if ((air[c].head!=null)&& (air[c].head.visit=='N' ))
 {
  air[c].head.visit='Y';
 if ( dfs(c,b) == true )
 {
   return true;
 }
 }
 if(tem.next!=null)
     tem=tem.next;
     else 
     break;  
 }
 return false;
}
 
  
 
 public void doResize(Scanner sc)
 {
   int val1 = 0;
   
   if ( sc.hasNextInt() == true )
     val1 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
    System.out.println ("Performing the Resize Command with " + val1 );
    for(int i=1;i<size;i++)
      air[i]=null;
    size= val1+1;
    air = new Airport[size];
    
    air[0]=null;
   
   for(int i=1;i<size;i++)
     air[i]= new Airport(i);
 
 }
 
 public void doInsert(Scanner sc)
 {
int a=sc.nextInt();
int b=sc.nextInt();
Node temp;
if(air[a].head==null)
{
  air[a].head=air[a].createconnection(b);
  System.out.println(air[a].head.data);
}
 else
 {temp=air[a].head;
   while(temp.next!=null)
   temp=temp.next;      
   temp.next=air[a].createconnection(b);
   
   
  
 }

}
 
 public void doDelete(Scanner sc)
{
  int a=sc.nextInt();
  int b=sc.nextInt();
  Node temp;
  temp = air[a].head;
  while(temp!=null)
{
  
    System.out.println(temp.data);
  if(temp.data==b)
  {air[a].head=air[a].head.next;
  break;
  } 
    if(temp.next.data==b)
    {   
      if(temp.next.next!=null)
      temp.next = temp.next.next;   
        else
      temp.next=null;
        break;
    }
     
     
     if(temp.next!=null)
     temp=temp.next;
     else
     break;  
}   

 }
 public void doList(Scanner sc)
 {
   Node temp;
  //int a=1;
   
   
   for(int a=1;a<size;a++)
  if(air[a].head!=null)
  {temp = air[a].head;
  System.out.println("From airport "+a+" one can go the following airports in one flight"); 
 while(temp!=null)
 { System.out.println(temp.data); 
 
   if(temp.next!=null)
     temp=temp.next;
     else
     break; 
 } 
   
 }
 System.out.println();
 
 }
 
 
 
 
 
 
 

 public void doFile(Scanner sc)
 {   Node temp; 
   String fname = null;
   int val2 = 0;
   int flag=0;
   
   if ( sc.hasNext() == true )
     fname = sc.next();
   else
   {
     System.out.println ("Filename expected");
     return;
   }
   
   System.out.println ("Performing the File command with file: " + fname);
  
   
   
   
   Proj7Prajiv2 ai = new Proj7Prajiv2();
    File f = new File (fname);
   Scanner sc1 = null;
   
   try
   {
     sc1 = new Scanner (f);
   }
   catch (FileNotFoundException fnfe)
   {
     System.out.println ("File did not exist");
     return;
   }

if(files.head!=null)   
{Node temp2=files.head;
 while(temp2!=null)
 {
 
   
   if(temp2.name.equals(fname))
   flag=1;
   
 if(temp2.next!=null)
 temp2=temp2.next;
 else
  break;
 }
 
   
}  
   
   
   
   
   if(files.head==null)
{
  files.head=files.createconnection1(fname);
  System.out.println(files.head.data);
}
 else
 {if(flag==0)
   { temp=files.head;
   while(temp.next!=null)
   temp=temp.next;      
   temp.next=files.createconnection1(fname);
 }
 
 }
   
 
 
 
 
 
 
 
 
   if(flag==0)
   {while (sc1.hasNextLine())
   {Scanner sc2 = new Scanner (sc1.nextLine());
   ai.processCommandLoop (sc2,0);    
   }
   }
   
   flag=0;
   
   
   // next steps:  (print an error message and return if any step fails)
   //  1. open the file 
   //  2. verify the file name is not currently in use
   //  3. create a new instance of Scanner 
   //  4. recursively call processCommandLoop() with this new instance of Scanner as the parameter
   //  5. close the file when processCommandLoop() returns
 }
 
 
}
 