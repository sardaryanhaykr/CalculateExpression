public class Main {

    public static void main(String[] args) {
        String s = "3*4-8/2+9-35+6/8";

        System.out.println(s);
        Expression expression = new ValueExpreession(s);
        System.out.println(expression.calculate());
    }
}
