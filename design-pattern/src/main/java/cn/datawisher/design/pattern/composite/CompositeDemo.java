package cn.datawisher.design.pattern.composite;

/**
 * @author h407644
 * @date 2022-01-28
 */
public class CompositeDemo {

    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        nodeA.add(nodeB);
        System.err.println(nodeA);
    }
}
