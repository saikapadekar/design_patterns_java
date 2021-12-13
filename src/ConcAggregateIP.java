import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcAggregateIP implements AggregateIP{
	private String dataFile;
	
	
	public ConcAggregateIP(String ipfile) {
		this.dataFile = ipfile;
	}

	@Override
	public Iterator createIterator() throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(this.dataFile));
		br.readLine();
		return new ConcIterator(br);
	}

}
