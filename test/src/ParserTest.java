package src;

import entities.*;
import model.File;
import model.Parser;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by wookie on 6/12/16.
 */
public class ParserTest {

    @Test
    public void testParse() throws IOException {
        File f = mock(File.class);
        when(f.readFile()).thenReturn("asd.");

        Parser p = new Parser(f.readFile());
        p.parse();

        Composite expText = new Text();
        Composite paragraph = new Paragraph();
        Composite sentence = new Sentence();
        Word word = new Word(WordFactory.getId("asd"));
        sentence.addComponent(word);
        paragraph.addComponent(sentence);
        expText.addComponent(paragraph);

        assertEquals("Parse test", expText.getValue(), p.getText().getValue());
    }
}