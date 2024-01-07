import org.example.StringBuilderUndo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBuilderUndoTest {
    StringBuilderUndo stringBuilderUndo;

    @Test
    void appendToEmpty(){
        stringBuilderUndo = new StringBuilderUndo(new StringBuilder());
        stringBuilderUndo.append("message");
        assertEquals("message", stringBuilderUndo.build());
    }

    @Test
    void appendToNonEmpty() {
        stringBuilderUndo = new StringBuilderUndo(new StringBuilder().append("message"));
        stringBuilderUndo.append(" hello");
        assertEquals("message hello", stringBuilderUndo.build());
    }

    @Test
    void appendAndDelete() {
        stringBuilderUndo = new StringBuilderUndo(new StringBuilder());
        stringBuilderUndo.append("message").delete(2, 3);
        assertEquals("mesage", stringBuilderUndo.build());
    }

    @Test
    void deleteAndUndoTest()  {
        stringBuilderUndo = new StringBuilderUndo(new StringBuilder().append("message"));
        stringBuilderUndo.delete(0, 1).undo();
        assertEquals("message", stringBuilderUndo.build());
    }

    @Test
    void undoAndUndoTest() {
        stringBuilderUndo = new StringBuilderUndo(new StringBuilder().append("message"));

        stringBuilderUndo.append("hel").delete(2, 3).append("lo");
        stringBuilderUndo.undo().undo().undo();

        assertEquals("message", stringBuilderUndo.build());
    }
}
