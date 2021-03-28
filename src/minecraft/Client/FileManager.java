package Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.google.gson.Gson;

public class FileManager {
	
	private static Gson gson = new Gson();
	
	private static File ROOT_DIR = new File("Client");
	public static File MODS_DIR = new File(ROOT_DIR, "Mods");
	
	public static void init() {
		if(!ROOT_DIR.exists()) { ROOT_DIR.mkdirs(); }
		if(!MODS_DIR.exists()) { MODS_DIR.mkdirs(); }
	}
	
	public static Gson getGson() {
		return gson;
	}
	
	public static File getModsDirectory() {
		return MODS_DIR;
	}
	
	public static boolean writeJsonToFile(File file, Object obj) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream outPutStream = new FileOutputStream(file);
			outPutStream.write(gson.toJson(obj).getBytes());
			outPutStream.flush();
			outPutStream.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static <T extends Object> T readFromJson(File file, Class<T> c) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			StringBuilder builder = new StringBuilder();
			String line;
			
			while((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			
			return gson.fromJson(builder.toString(), c);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
