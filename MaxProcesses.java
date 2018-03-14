
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class MaxProcesses {

 // Function to read the file.
	public static FileReader fileReader(String path) throws FileNotFoundException {
		FileReader reader = null;
		try {
			reader = new FileReader(path);
			return reader;
		} catch (FileNotFoundException e) {
			throw e;
		}
	}

//Function to find maximum processes.
	public Output findMaxProcess(String path) throws IOException {
		try {
			FileReader reader =  MaxProcesses.fileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader, 8*1024);
			List<String> datetime = new ArrayList<String>();
			long count = 0, currMax = 0;
			String line=null;
			//long temp = System.nanoTime(); -------------------Used this and line number 54 to check Time required for execution using different buffer sizes.

			while((line = bufferedReader.readLine()) != null) {
				//Continue if a line is blank in between logs.
				if(line.length() == 0)
					continue;

				String kept = line.substring(0,line.indexOf(","));
				String left = line.substring(line.indexOf(",")+1,line.length());

        		if(!left.contains("Process_End")) {
        			count++;
        			if(count > currMax) {
        				currMax = count;
        				datetime.clear();
        				datetime.add(kept);
        			}
        			else if(count == currMax) {
        				datetime.add(kept);
        			}
        		}
        		else {
        			count--;
        		}
	        }
			reader.close();
			bufferedReader.close();
			//System.out.println(System.nanoTime()-temp);
			return new Output(datetime, currMax);
		} catch (Exception e) {
			throw e;
		}

	}


	public static void main(String args[]) throws IOException{
		MaxProcesses mp = new MaxProcesses();
		Output op = mp.findMaxProcess(args[0]);
		System.out.println(op.list);
		System.out.println(op.count);
	}
}
