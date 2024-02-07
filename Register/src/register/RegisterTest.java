package register;

import javax.swing.JOptionPane;

public class RegisterTest {
    public static void main(String[] arge) {
        boolean loop=true;
        String data;
        Register std1=new Register("652021069","Boy");
        while(loop==true){
            data=JOptionPane.showInputDialog(null, "-----MENU-----"
                    +"\n1)Login "
                    +"\n2)Add"
                    +"\n3)withdraw"
                    +"\n4)showData"
                    +"\n5)Logout"
                    +"\n6)Exit");
            switch(data) {
                case "1":{
                    std1.Login();
                    break;
                }
                case "2":{
                    std1.Add();
                    break;
                }    
                case "3":{
                    std1.withdraw();
                    break;
                }
                case "4":{
                    std1.showData();
                    break;
                }
                case "5":{ 
                    //std1.Logout();
                    break;
                }
                case "6":{ 
                    //std1.Exit();
                    loop=false;
                    break;
                }
                default:{
                    break;
                }
            }         
        }
    }
}