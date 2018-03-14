
import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class MyTests {

	@Rule
	 public ExpectedException exception = ExpectedException.none();
	@Rule
	 public TemporaryFolder folder = new TemporaryFolder();

	 @Test
	 public void throwsFileNotFoundException() throws IOException {
	    exception.expect(FileNotFoundException.class);
	    MaxProcesses tester = new MaxProcesses();
	    tester.findMaxProcess("test.txt");
	 }

	 @Test
	 public void testEmptyLogFile() throws IOException {
		 File createdFile = folder.newFile("myfile.txt");
		 List<String> list = new ArrayList<String>();
		 MaxProcesses tester = new MaxProcesses();
		 Output op = tester.findMaxProcess(createdFile.getAbsolutePath());
		 assertNotNull(op);
		 assertTrue(op.list.equals(list));
		 assertEquals(0, op.count);
	 }


	 @Test
	 public void testLogFile1() throws IOException {
		 File createdFile1 = File.createTempFile("process", ".log", new File("/Users/admin/"));
		 BufferedWriter bw = new BufferedWriter(new FileWriter(createdFile1));
		 bw.write("2018-03-07 11:16:24,476  Process_Started 1211 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:25,477 Process_Started 1210 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:26,478 Process_Started 1212 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:27,479 Process_End 1211 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:28,480 Process_Started 1213 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:29,481 Process_Started 1214 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:30,482 Process_End 1210 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:31,483 Process_End 1212 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:32,484 Process_End 1213 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:33,485 Process_End 1214 no cores found");
		 bw.close();
		 List<String> list = new ArrayList<String>();
		 MaxProcesses tester = new MaxProcesses();
		 Output op = tester.findMaxProcess(createdFile1.getAbsolutePath());
		 assertNotNull(op);
		 list.add("2018-03-07 11:16:29");
		 assertTrue(op.list.equals(list));
		 assertEquals(4, op.count);
		 createdFile1.deleteOnExit();
	 }

	 @Test
	 public void testLogFileWithBlankLine() throws IOException {
		 File createdFile1 = File.createTempFile("process", ".log", new File("/Users/admin/"));
		 BufferedWriter bw = new BufferedWriter(new FileWriter(createdFile1));
		 bw.write("2018-03-07 11:16:24,476  Process_Started 1211 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:25,477 Process_Started 1210 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:26,478 Process_Started 1212 system state is okay");
		 bw.newLine();
		 bw.newLine();
		 bw.write("2018-03-07 11:16:27,479 Process_End 1211 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:28,480 Process_Started 1213 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:29,481 Process_Started 1214 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:30,482 Process_End 1210 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:31,483 Process_End 1212 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:32,484 Process_End 1213 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:33,485 Process_End 1214 no cores found");
		 bw.close();
		 List<String> list = new ArrayList<String>();
		 MaxProcesses tester = new MaxProcesses();
		 Output op = tester.findMaxProcess(createdFile1.getAbsolutePath());
		 assertNotNull(op);
		 list.add("2018-03-07 11:16:29");
		 assertTrue(op.list.equals(list));
		 assertEquals(4, op.count);
		 createdFile1.deleteOnExit();
	 }


	 @Test
	 public void testLogFileWithMultipleMaxProcess() throws IOException {
		 File createdFile1 = File.createTempFile("process", ".log", new File("/Users/admin/"));
		 BufferedWriter bw = new BufferedWriter(new FileWriter(createdFile1));
		 bw.write("2018-03-07 11:16:24,476  Process_Started 1211 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:25,477 Process_Started 1210 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:26,478 Process_Started 1212 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:27,479 Process_End 1211 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:28,480 Process_Started 1213 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:29,481 Process_Started 1214 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:30,482 Process_End 1210 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:31,483 Process_End 1212 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:32,484 Process_End 1213 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:33,485 Process_End 1214 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:24,476  Process_Started 1211 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:25,477 Process_Started 1210 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:26,478 Process_Started 1212 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:27,479 Process_End 1211 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:28,480 Process_Started 1213 system state is okay");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:29,481 Process_Started 1214 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:30,482 Process_End 1210 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:31,483 Process_End 1212 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:32,484 Process_End 1213 no cores found");
		 bw.newLine();
		 bw.write("2018-03-07 11:16:33,485 Process_End 1214 no cores found");
		 bw.close();
		 List<String> list = new ArrayList<String>();
		 MaxProcesses tester = new MaxProcesses();
		 Output op = tester.findMaxProcess(createdFile1.getAbsolutePath());
		 assertNotNull(op);
		 list.add("2018-03-07 11:16:29");
		 list.add("2018-03-07 11:16:29");
		 assertTrue(op.list.equals(list));
		 assertEquals(4, op.count);
		 createdFile1.deleteOnExit();
	 }

}
