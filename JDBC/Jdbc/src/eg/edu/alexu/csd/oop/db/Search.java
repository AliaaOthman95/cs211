package eg.edu.alexu.csd.oop.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Search {
	public boolean findFile(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                return true;
            }
        }
        return false;
    }
	
	boolean searchFolder (String databaseName,String databeasePath){
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
	        @Override
	        public boolean accept(Path file) throws IOException {
	            return (Files.isDirectory(file));
	        }
	    };

	    Path dir = FileSystems.getDefault().getPath(databeasePath);
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
	            filter)) {
	        for (Path path : stream) {
	        	
	            if(path.getFileName().toString().equals(databaseName)){            	
	            	return true;
	            	
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
		return false;
		
	}

}