import java.io.IOException;
import java.util.List;

public interface Iterator {
	public List<String> nextOrder() throws IOException;
}
