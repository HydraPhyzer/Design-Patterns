import java.util.Stack;

// Abstract Expression interface
interface Expression {
    int interpret();
}

// Terminal Expression
class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

// Non-terminal Expression
abstract class Operator implements Expression {
    protected Expression left;
    protected Expression right;

    public Operator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

// Concrete Operators
class Add extends Operator {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Subtract extends Operator {
    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class Multiply extends Operator {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

class Divide extends Operator {
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    public int interpret() {
        return left.interpret() / right.interpret();
    }
}

// Context
class PostfixExpression {
    private Stack<Expression> stack;

    public PostfixExpression() {
        stack = new Stack<>();
    }

    public void parse(String expression) {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(createExpression(token, left, right));
            } else {
                stack.push(new Number(Integer.parseInt(token)));
            }
        }
    }

    public int evaluate() {
        return stack.pop().interpret();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private Operator createExpression(String token, Expression left, Expression right) {
        switch (token) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Subtract(left, right);
            case "*":
                return new Multiply(left, right);
            case "/":
                return new Divide(left, right);
            default:
                throw new IllegalArgumentException("Invalid operator: " + token);
        }
    }
}

// Client code
public class InterpreterDP {
    public static void main(String[] args) {
        String postfixExpression = "4 5 + 3 * 2 /"; // evaluates to 6

        PostfixExpression expression = new PostfixExpression();
        expression.parse(postfixExpression);

        int result = expression.evaluate();
        System.out.println(postfixExpression + " = " + result);
    }
}