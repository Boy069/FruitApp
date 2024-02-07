//Veerawat  Ainplot  652021069
package ws01LibCard069.Java;

import javax.swing.JOptionPane;

public class Java652021069 {
    String CardID="652021069";
    int Number;
    boolean status=false;
    private boolean found;
    private int position;
    
    void Login(){
        String input=JOptionPane.showInputDialog(null,"Please Login");
        if(input.equals(CardID)){ 
            System.out.println("Login Successful");
            status=true;
        }else{                              
            System.out.println("Login Failed, Try Again !!!!");
        }
    }
    void Borrow(){
        if(status){  
            String input=JOptionPane.showInputDialog(null,"Input book number(1-5) ");
            Number=Integer.parseInt(input);
            for(int i=0;i<Number;i++){
                String bookname=JOptionPane.showInputDialog(null,"Enter Book's Name #"+(i+1));
                Book.add(bookname);
            }
        }else{
            System.out.println("---Please Login !!!!----");
        }
    }
    void Show(){
        System.out.println("--------------book name is/are-------------");
        for(int i=0;i<Book.size();i++){
            System.out.println((i+1)+") "+Book.get(i));
        }
    }
    void Search(){
        String name = JOptionPane.showInputDialog(null, "search for book's name");
        for(int i=0;i<Book.size();i++ ){
            if(name.equalsIgnoreCase(Book.get(i))){
                found =true;
            }else{
        }
    }
        if(found){
            System.out.println("found book's name ="+name);
        }else{
            System.out.println("not found book's name "+name);
        }
    }
    void Return(){
        String Rname = JOptionPane.showInputDialog(null, "your return book name =");
        found=false;
        for(int i=0;i<Book.size();i++){
            if(Rname.equalsIgnoreCase(Book.get(i))){
                found=true;
                position=i;
            }
        }
        if(found){
            Book.remove(position);
            System.out.println(Rname +"returned");
        }else{
            System.out.println("can not return"+Rname);
        }
    }
   
}
