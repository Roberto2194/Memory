package src.settings;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A cleaner solution over the clunky DocumentListener
 * provided by Java. We only need to implement the
 * insertUpdate method for our TextFields.
 */
@FunctionalInterface
public interface SimpleDocumentListener extends DocumentListener {
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {update(e);}

    @Override
    default void removeUpdate(DocumentEvent e) {}

    @Override
    default void changedUpdate(DocumentEvent e) {}

}
