package application;

import org.mindrot.jbcrypt.BCrypt;

import com.jfoenix.controls.JFXTextField;

import javafx.scene.Scene;

public class HashTask implements Runnable{
	private Scene scene;
	private JFXTextField tString;
	private  JFXTextField tHash;
	public HashTask(Scene scene) {
		this.scene = scene;
		tString = (JFXTextField) scene.lookup("#tString");
		tHash = (JFXTextField) scene.lookup("#tHash");
	}


	@Override
	public void run() {
		synchronized (scene) {
//				bHash.setDisable(true);
				String text = tString.getText();
				if(!text.equals(null) && !text.equals("")) {
					String salt = BCrypt.gensalt(12);
					String hashedString = BCrypt.hashpw(text, salt);
					tHash.setText(hashedString);
				}else
					tHash.setText("");
//				bHash.setDisable(false);
		}
//		try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
}
