public class Main {

    public static void main(String[] args) {
        EvaluateStringExpression expression = new EvaluateStringExpression();
        String strExpression = "( 3 + ( 2 * 5 ) / 3 )";
        System.out.println(strExpression);
        System.out.println(expression.evaluate(strExpression));
    }
}
