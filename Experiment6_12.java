import java.util.Scanner;

public class Experiment6_12 {

    static int calculateArea(int l, int w){
        int area = l * w;
        return area;
    }

    static int calculateVolume(int l, int w, int h){
        int volume = l * w * h;
        return volume;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int p, l, t, L, vol;
        System.out.println("Input length: ");
        p = input.nextInt();
        System.out.println("Input width: ");
        l = input.nextInt();
        System.out.println("Input height: ");
        t = input.nextInt();

        L = p*l;
        System.out.println("Area of the rectangle = " + L);
        vol = p*l*t;
        System.out.println("Volume of the rectangular = " + vol);

    }
}
