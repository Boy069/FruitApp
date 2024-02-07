package ws01libcard069.java;

import javax.swing.JOptionPane;

public class Ws01LibCard069Java {
    String CardID="652021069";
    //String CardName;
    int Number;
    boolean status=false;
    
    void Login(){
        String input=JOptionPane.showInputDialog(null,"Please Login");
        if(input.equals(CardID)){ //กรณี login ถูกต้อง
            System.out.println("Login Successful");
            status=true;
        }else{                                                 //กรณี login ผิด
            System.out.println("Login Failed, Try Again !!!!");
        }
    }
    void Borrow(){
        if(status){  //เช็คว่า login แล้ว
            String input=JOptionPane.showInputDialog(null,"Input book number(1-5)");
            Number=Integer.parseInt(input);
            for(int i=0;i<Number;i++){
                String bookname=JOptionPane.showInputDialog(null,"Enter Book's Name #"+(i+1));
                book.add(bookname);
            }
        }else{  //กรณียังไม่ login
            System.out.println("----Please Login !!!!!-----");
        }
    }
    void Show(){
        System.out.println("----------------book name is/are---------------");
        for(int i=0;i<book.size();i++){
            System.out.println((i+1)+") "+book.get(i));
        }
    }
    
}
