package com.liberate.automation.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/***
 * Class that handles report generation
 * 
 * 
 *
 */
public class ReportGenerator {

	/***
	 * Method to create screenshot document.
	 * 
	 * @param FileName
	 *            The Filename with which the doc should be saved without extension.
	 *            The screenshots with same Filename will be added to the document
	 */
	public static void generateReport(String FileName) {
		XWPFDocument doc = new XWPFDocument();

		XWPFParagraph title = doc.createParagraph();
		XWPFRun run = title.createRun();

		FileInputStream is;
		try {
			// Read all the files from the folder
			File folder = new File("Screenshots//");
			File[] listOfFiles = folder.listFiles();
			ArrayList<String> ScreenShotFiles = new ArrayList<>();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					if (listOfFiles[i].getName().contains(FileName))
						ScreenShotFiles.add("Screenshots//" + listOfFiles[i].getName());
				}
			}

			for (int i = 0; i < ScreenShotFiles.size(); i++) {
				is = new FileInputStream(ScreenShotFiles.get(i));
				run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, ScreenShotFiles.get(i), Units.toEMU(533),
						Units.toEMU(300)); // 800*800 pixels
				run.addBreak();
				is.close();
			}

			FileOutputStream fos = new FileOutputStream("Screenshots//" + FileName + ".docx");
			doc.write(fos);
			fos.close();
			doc.close();

			for (int i = 0; i < ScreenShotFiles.size(); i++) {
				Files.deleteIfExists(Paths.get(ScreenShotFiles.get(i)));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		run.addBreak();
	}

}
