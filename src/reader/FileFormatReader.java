package reader;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileFormatReader {
	void open() throws FileNotFoundException;
	void readLineByLine() throws IOException;
	void close() throws IOException;
}
