package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverter_GFA_Test
{
	MorseCodeConverter convert;
	@Before
	public void setUp() throws Exception
	{
		convert = new MorseCodeConverter();
	}

	@After
	public void tearDown() throws Exception
	{
		convert = null;
	}

	@Test
	public void testConvertToEnglishString() {	
		String converter1 = convert.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}

}