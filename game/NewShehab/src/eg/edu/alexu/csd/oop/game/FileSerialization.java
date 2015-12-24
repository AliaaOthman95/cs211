  package eg.edu.alexu.csd.oop.game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileSerialization {

	public void serialize(SnapShot snapShot) {
		try {
			 
			// write object to file
			FileOutputStream fos = new FileOutputStream("game.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(snapShot);

			System.out.println("saved");

			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public SnapShot deserialize() {
		SnapShot shot = null;
		try {
			// read object from file
			FileInputStream fis = new FileInputStream("game.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			shot = (SnapShot) ois.readObject();

			ois.close();
			System.out.println("loaded");
		 System.out.println(shot.getControl().size()+"++++");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return shot;
	}

}