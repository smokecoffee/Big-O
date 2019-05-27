package community.ilovejava;

public class GFG {
    static int getAvg(int x, int y) {
        return (x & y) + ((x ^ y) >> 1);

    }

    public static void main(String[] args) {
        int x = 10, y = 21;
        System.out.println(getAvg(x, y));

    }

}
