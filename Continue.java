import java.util.*;

public class Continue {

    public static void main(String[] args) {
        String[] passagiere = {
            "mama", "papa", "mama", "papa", "baby", "papa", "mama", "papa",
            "mama", "papa", "mama", "baby", "mama", "papa", "mama", "papa",
            "mama", "baby", "mama", "papa", "baby", "papa", "mama", "papa",
            "mama", "papa", "mama", "papa", "mama", "papa", "mama", "papa",
            "baby", "kind", "baby", "kind", "baby", "kind", "baby", "kind",
            "baby", "kind", "baby", "kind", "baby", "kind", "baby", "kind",
            "mama", "papa", "mama", "papa", "mama", "papa", "mama", "papa"
        };

        int count = 0;
        
        for (String passagier : passagiere) {
            
            if (passagier.equals("baby")){
                break;
            }
            System.out.print("*");
            count++;
        }
        System.out.println(" " + count);
    }
}