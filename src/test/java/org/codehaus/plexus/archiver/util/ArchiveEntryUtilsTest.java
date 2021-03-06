package org.codehaus.plexus.archiver.util;

import java.io.File;
import java.util.HashMap;

import org.codehaus.plexus.components.io.attributes.Java7FileAttributes;
import org.codehaus.plexus.logging.console.ConsoleLogger;

import junit.framework.TestCase;

public class ArchiveEntryUtilsTest extends TestCase {

	public void testChmodForFileWithDollarPLXCOMP164() throws Exception
	{

		File temp = File.createTempFile("A$A", "BB$");

		ArchiveEntryUtils.chmod( temp, 0770, new ConsoleLogger( org.codehaus.plexus.logging.Logger.LEVEL_DEBUG, "foo" ), false);

		Java7FileAttributes j7 = new Java7FileAttributes(temp, new HashMap<Integer, String>(), new HashMap<Integer, String>());

		assertTrue(j7.isGroupExecutable());
		assertTrue(j7.isGroupReadable());
		assertTrue(j7.isGroupWritable());

		assertFalse(j7.isWorldExecutable());
		assertFalse(j7.isWorldReadable());
		assertFalse(j7.isWorldWritable());

	}
}