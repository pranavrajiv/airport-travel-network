class Node
{
  public int data;
  public Node next;
  public char visit;
  public String name; 
public Node(int b)
{  
this.data = b;
this.visit = 'N';
next=null;
} 

public Node(String na)
{  
this.name = new String(na);
next=null;
} 



}
