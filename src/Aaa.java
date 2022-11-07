public class Aaa implements  Demo{
    public static void main(String[] args) {
        Aaa aaa= new Aaa();
        aaa.show();

        System.out.println();
    }

    @Override
    public void show() {
        System.out.println("Hey");
    }
}

