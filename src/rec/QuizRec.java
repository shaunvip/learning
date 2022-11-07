package rec;

public class QuizRec {
    public static void main(String[] args) {

    }
    static {
        System.out.println( fun(4,3));
    }

    private static int fun(int x, int y) {
        if (x==0) return y;
        return fun(x-1,x+y);
    }
}
