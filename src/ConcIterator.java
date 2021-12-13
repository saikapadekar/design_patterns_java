import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class ConcIterator implements Iterator{

	private BufferedReader reader;
	
	public ConcIterator(BufferedReader reader) {
		this.reader = reader;
	}
	
	@Override
	public List<String> nextOrder() throws IOException {
		try {
			String line = reader.readLine();
			return Arrays.asList(line.split(","));
		} catch(NullPointerException e) {}
		return null;
	}

}
