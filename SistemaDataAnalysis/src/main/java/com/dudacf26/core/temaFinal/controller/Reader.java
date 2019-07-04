package com.dudacf26.core.temaFinal.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
	 private File[] files;
	    private List<String> fileData;

	    public Reader() {
	        findFiles();
	        readAllFiles();
	    }

	    private boolean findFiles() {
	        File currentDirFile = new File(".");
	        String path = currentDirFile.getAbsolutePath();
	        fileData = new ArrayList<String>();
	        File f = new File(path + "\\data\\in\\");
	        files = f.listFiles(new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	                return name.endsWith(".dat");
	            }
	        });
	        return files.length > 0;
	    }

	    private void readAllFiles() {
	        for (File file : files) {
	            FileInputStream fis;
	            try {
	                fis = new FileInputStream(file);
	                byte[] data = new byte[(int) file.length()];
	                if (data.length > 0) {
	                    fis.read(data);
	                    fileData.add(new String(data, "UTF-8"));
	                }
	                fis.close();

	            } catch (FileNotFoundException ex) {
	                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
	            } catch (IOException ex) {
	                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }

	    public List<String> getFileData() {
	        return fileData;
	    }
}
