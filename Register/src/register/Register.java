package register;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Register {
    String stdId,stdName;
    String usrName="Boy";
    private final String usrPass="652021069";
    boolean status=false;
    ArrayList<String> subjectName =new ArrayList<>();
    int Number, position;
    File file;
    private boolean found;
    private String stdID;
    Register(String stdid, String stdname){  //constructor
        stdId=stdid;
        stdName=stdname;
    }
    public void Login(){
        String input=JOptionPane.showInputDialog
        (null,"Enter your username");
        if(input.equals(usrName)){
            input=JOptionPane.showInputDialog(null,"Enter password");
            if(input.equals(usrPass)){
                status=true;
                JOptionPane.showMessageDialog(null, "-/-/-/-/-welcome-/-/-/-/-");
            }else{
              JOptionPane.showMessageDialog(null, "incorrect password"); 
              Login();
            }
        }else{
            JOptionPane.showMessageDialog(null, "incorrect username");
            Login();
        }
    }
    public void Add(){
        if(status){
            String input=JOptionPane.showInputDialog
            (null,"Enter number of subject(1-7)");
            Number=Integer.parseInt(input);
            if(Number<=7){
                for(int i=0;i<Number;i++){
                    String subj=JOptionPane.showInputDialog
                    (null,"subject name #"+(i+1));
                    subjectName.add(subj);
                }
                SaveData();
            }else{//more than 7 subjects
                System.out.println("more than 7 subjects");
                Add();
            }  
        }else{
            System.out.println("Login Again");
            Login();
        }
    }
    public void SaveData(){
        file=new File("d:\\"+this.stdId+".txt");
        try(FileWriter writer=new FileWriter(file,false)){
            for(int i=0;i<subjectName.size();i++){
                writer.write(subjectName.get(i)+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void withdraw(){
        if(status){
            getClass();
            showData();
            String Rname=JOptionPane.showInputDialog(null,"please select the course you want to remove.");
            found=false;
            for(int i=0;i<subjectName.size();i++){
                if(Rname.equalsIgnoreCase(subjectName.get(i))){
                    found=true;
                    position=i;
                }
            }
            if(found){
                subjectName.remove(position);
                JOptionPane.showMessageDialog(null, Rname+" Alreaed removed");
                System.out.println(Rname+"  Already removed");
            }else{
                JOptionPane.showMessageDialog(null, Rname+" Failed to remove the course");
                System.out.println(Rname+"  Failed to remove the course");
            }
            SaveData();
            showData();
        }else{
            JOptionPane.showMessageDialog(null, "Login Again");
            Login();
        }
    }
    void showData(){
        System.out.println(stdName+"    Your course is as follows.");
        for(int i=0;i<subjectName.size();i++){
            System.out.println((i+1)+")"+subjectName.get(i));
        }
    }
    public void getData(){
        subjectName.clear();
        String st;
        file = new File("D:\\"+this.stdID+".txt");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((st=reader.readLine())!=null){
                subjectName.add(st);
            }
        }catch(IOException ex){
            ex.getMessage();
        }
    }
    
}
