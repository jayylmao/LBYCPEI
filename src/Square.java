public class Square {
    private int side = 10;
    int GetArea() {
        return side * side;
    }

    int GetPerimeter() {
        return 4 * side;
    }

    public static void main(String[] args) {
        Square sq = new Square();

        System.out.println("area of the square is: " + sq.GetArea());
        System.out.println("perimeter of the square is: " + sq.GetPerimeter());
        System.out.println(sq.side);
    }
}