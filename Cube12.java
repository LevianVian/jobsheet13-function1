public class Cube12 {

    public static double calculateArea(double sideLength) {
        double area = 6 * sideLength * sideLength;
        return area;
    }

    public static double calculateVolume(double sideLength) {
        double volume = sideLength * sideLength * sideLength;
        return volume;
    }

    public static void main(String[] args) {
        double side = 5.0; 
        double areaResult = calculateArea(side);
        System.out.println("The side length of the cube is: " + side);
        System.out.println("The surface area is: " + areaResult);
        double volumeResult = calculateVolume(side);
        System.out.println("The volume is: " + volumeResult);
    }
}
