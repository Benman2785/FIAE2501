public class Uhrzeit {
    public static void main(String[] args) throws InterruptedException {

        for (int hh = 0; hh <= 23; hh++) {
            for (int mm = 0; mm <= 59; mm++) {
                for (int ss = 0; ss <= 59; ss+=5) {
                    System.out.printf("%20d:%02d:%02d" ,hh,mm,ss);
                    System.out.println("");
                    Thread.sleep(5);
                    if (hh == 2 & mm == 00 & ss == 00) {
                        // System.out.println("ALARM!");
                        alarm();
                        break;
                    }
                }                 
            }
        }
    }
static void alarm() {
    System.err.println("ALARM!");
}
}
