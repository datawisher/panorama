package com.datawisher.bee.voice.ui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

public abstract class AbstractController {
    public abstract void prepareAndOpenFrame();

    protected void registerAction(AbstractButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    protected void registerAction(JCheckBox checkBox, ChangeListener listener) {
        checkBox.addChangeListener(listener);
    }

    protected void registerAction(JComponent component, KeyListener listener) {
        component.addKeyListener(listener);
    }

    protected void registerAction(JTextField textField, DocumentListener listener) {
        textField.getDocument().addDocumentListener(listener);
    }

    protected void registerAction(JComponent component, TreeSelectionListener listener) {
        if (component instanceof JTree) {
            JTree jTree = (JTree) component;
            jTree.addTreeSelectionListener(listener);
        }
    }

    protected void registerAction(JComponent component, ListSelectionListener listener) {
        if (component instanceof JList) {
            JList jList = (JList) component;
            jList.addListSelectionListener(listener);
        }
    }

    protected void registerAction(TableModel component, TableModelListener listener) {
        component.addTableModelListener(listener);
    }

    protected void registerAction(JComboBox component, ItemListener listener) {
        component.addItemListener(listener);
    }

    protected void registerAction(Window window, WindowListener listener) {
        window.addWindowListener(listener);
    }
}
