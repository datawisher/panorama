package cn.datawisher.design.pattern.flyweight.forest;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import cn.datawisher.design.pattern.flyweight.trees.Tree;
import cn.datawisher.design.pattern.flyweight.trees.TreeFactory;
import cn.datawisher.design.pattern.flyweight.trees.TreeType;

public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
