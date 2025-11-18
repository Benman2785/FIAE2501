import java.util.Random;
public class smiley {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print("<svg width='300' height='300' xmlns='http://www.w3.org/2000/svg'>");
 
        for (int x = 0; x < 290; x +=10) {
            for (int y = 0; y < 290; y +=10) {
                int r = random.nextInt(0,255);
                int g = random.nextInt(0,255);
                int b = random.nextInt(0,255);
                int r1 = random.nextInt(100,255);
                int g1 = random.nextInt(100,255);
                int b1 = random.nextInt(100,255);
                
                System.out.println("<rect x='"+x+"' y='"+y+"' width='10' height='10' fill='rgb("+r+","+b+","+g+")' stroke='black' stroke-width='1'/>");
                if (x > 50 && x < 230 && y > 150 && y < 200 || x > 190 && x < 240 && y > 140 && y < 190 || x > 40 && x < 90 && y > 140 && y < 190 || x > 70 && x < 120 && y > 70 && y < 140 ||x > 160 && x < 210 && y > 70 && y < 140) {
                    System.out.println("<rect x='"+x+"' y='"+y+"' width='10' height='10' fill='rgb("+r1+","+g1+","+b1+")' stroke='black' stroke-width='1'/>");
                }
                if (x > 60 && x < 220 && y > 160 && y < 190 || x > 200 && x < 230 && y > 150 && y < 180 || x > 50 && x < 80 && y > 150 && y < 180 || x > 80 && x < 110 && y > 80 && y < 130 ||x > 170 && x < 200 && y > 80 && y < 130) {
                    System.out.println("<rect x='"+x+"' y='"+y+"' width='10' height='10' fill='rgb(0,0,0)' stroke='black' stroke-width='1'/>");
                }    
            }
        }
        System.out.println("</svg>");
    }
}