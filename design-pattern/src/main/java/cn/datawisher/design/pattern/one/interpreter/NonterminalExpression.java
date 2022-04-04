package cn.datawisher.design.pattern.one.interpreter;

/**
 * @author h407644
 * @date 2022-04-04
 */
public class NonterminalExpression implements Expression {
    private Expression left;
    private Expression right;

    public NonterminalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void interpret(Context ctx) {

    }
}
