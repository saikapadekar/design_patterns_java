import java.io.FileNotFoundException;
import java.io.IOException;

public interface AggregateIP {

	public Iterator createIterator() throws FileNotFoundException, IOException;
}
