import java.util.Scanner;
 
public class Jaffar {
   
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Bitte geben Sie IhreKörpergröße in cm an : ");
 
        double koerpergroeße = sc.nextInt();
 
        double bighight = 190;
        double mediumhight =189 ;
        double mediumhight2 =160;
 
        if(koerpergroeße>=bighight){
            System.out.println("Sie sind mit " + koerpergroeße + "cm sehr groß.");
        }else if (koerpergroeße<=mediumhight &&  koerpergroeße>=mediumhight2){
            System.out.println("Mit der Körpergröße von "+ koerpergroeße + "cm haben Sie Durchschnittsgröße!");
 
        }else if (koerpergroeße<mediumhight2){
            System.out.println("Sie sind mit " +  koerpergroeße + "cm sehr klein");
        }else {
            System.out.println("Bist du dumm?");
        }
    }
}