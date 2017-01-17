class Airport
{
  
  public Node head;
 
  
  public Airport(int a)
  {
   
    head = null ;
  
  }
  
  
   
  public Node createconnection(int b)
 {  
    
 Node n= new Node(b);
  return n;
 }
  
  
  public Node createconnection1(String name)
 {  
    
 Node n= new Node(name);
  return n;
 }
  
  
} 