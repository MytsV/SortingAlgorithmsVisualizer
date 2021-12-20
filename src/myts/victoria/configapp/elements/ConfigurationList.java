package myts.victoria.configapp.elements;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Collections;
import java.util.List;

public class ConfigurationList<T> extends JList<T> {

    private final DefaultListModel<T> model;

    public ConfigurationList() {
        model = new DefaultListModel<>();
        setModel(model);
    }

    public List<T> getList() {
        return Collections.list(model.elements());
    }

    public void add(Integer element) {
        model.addElement((T) element);
    }

    public void remove(T element) {
        model.removeElement(element);
    }

}

class ConfigurationListField extends JTextField {

    public ConfigurationListField(FieldModel model) {
        super(20);
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.setText(getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.setText(getText());
            }
        });
    }

}

class ConfigurationListButton extends JButton {

    public ConfigurationListButton(Runnable action) {
        super("Add");
        addActionListener((event) -> action.run());
    }

}

class ConfigurationListRemoveButton extends JButton {

    public ConfigurationListRemoveButton(Runnable action) {
        super("Remove");
        addActionListener((event) -> action.run());
    }

}

class FieldModel {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
