package Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookWord {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(
					"/Users/Shivam/Downloads/TheCatcherText.txt"));
			List<String[]> line = new ArrayList<String[]>();
			while ((sCurrentLine = br.readLine()) != null) {
				String[] arr = sCurrentLine.split("\\s+");
				line.add(arr);
				// System.out.println(sCurrentLine);
			}

			Map<String, Integer> check = new HashMap<String, Integer>();
			for (int i = 0; i < line.size(); i++) {
				int amount = 0;
				for (int j = 0; j < line.get(i).length; j++) {
					if (!check.containsKey(line.get(i)[j])) {
						check.put(line.get(i)[j], 0);
					}
				}
			}

			for (int i = 0; i < line.size(); i++) {
				for (int j = 0; j < line.get(i).length; j++) {
					System.out.println(line.get(i)[j] + ": "
							+ check.get(line.get(i)[j]));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
/*
 * if (sCurrentLine.contains(" ")) { sCurrentLine.replace(" ", "!"); }
 */