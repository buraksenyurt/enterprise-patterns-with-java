public class Lesson06Printf {
    public static void run(){
        // printf samples

        String myHero = "Can Claude Van Dam";
        char firstLetter = myHero.charAt(0);
        int age = 50;
        double height = 185.50;
        boolean onActiveMission = true;
        double salary = 999999.55;
        int luckyNumber = 1000050001;
        int myId = 23;

        System.out.printf("I am `%s`\n", myHero); // string
        System.out.printf("You can call me %c\n",firstLetter); // karakter
        System.out.printf("I am %d years old\n.",age); // tam sayı
        System.out.printf("I am %.2f\n",height); // ondalık kısımda 2 hane
        System.out.printf("My mission status is %b\n",onActiveMission); // boolean
        System.out.printf("My salary is %f\n",salary); // tam float
        System.out.printf("My salary is %,.2f\n",salary); // ondalık kısım iki hane. 1,000.00 formatında
        System.out.printf("My lucky number is %,d\n",luckyNumber); // virgüllü yazdırma
        System.out.printf("My ID number is %05d\n",myId); // padding
        System.out.printf("My ID number is %-10dve\n",myId); // negatif değer verip sola dayalı padding (Burada 10 hane)
    }
}
