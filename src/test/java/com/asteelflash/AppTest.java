package com.asteelflash;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.junit.Test;

import com.asteelflash.ext.Response;
import com.asteelflash.ext.Vfs;

import java.io.File;
/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	/*
	@Test
	public void happyTest001() throws Exception {
		String host = "host";
		String user = "2000184036";
		String password = null;
		String remotePath = "/download/archive/123.xml";

		String localFilePath = "c:/happy/";
		String fileName = "123.xml";

		String keyPath = "c:/happy/Key.ppk";
		String passphrase = null;

		String connectionString = Vfs.createConnectionString(user, password, host, remotePath);
		Vfs vfs = new Vfs();
		FileSystemOptions fileSystemOptions = Vfs.getDefaultOptions(keyPath, passphrase);

		Response response = vfs.download(localFilePath, fileName, connectionString, fileSystemOptions,
				Selectors.SELECT_FILES);
		assertTrue(response.getResult());
	}

	@Test
	public void happyTest002() throws Exception {
		String host = "host";
		String user = "2000184036";
		String password = null;
		String remotePath = "/upload/123.xml";

		String keyPath = "c:/happy/Key.ppk";
		String passphrase = null;

		String connectionString = Vfs.createConnectionString(user, password, host, remotePath);
		Vfs vfs = new Vfs();
		FileSystemOptions fileSystemOptions = Vfs.getDefaultOptions(keyPath, passphrase);

		//Response response = vfs.download(localFilePath, fileName, connectionString, fileSystemOptions,Selectors.SELECT_FILES);
		List<File> fiList = new ArrayList<File>();
		File f1 = new File("C:/Happy/123.xml");
		fiList.add(f1);
		Response response = vfs.upload(connectionString, fiList, fileSystemOptions, Selectors.EXCLUDE_SELF);
		assertTrue(response.getResult());
	}
	*/

}
