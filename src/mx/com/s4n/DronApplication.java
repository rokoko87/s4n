package mx.com.s4n;

import java.util.ArrayList;
import java.util.List;

import mx.com.s4n.coordenadas.Dron;
import mx.com.s4n.file.FileUtil;

public class DronApplication {
	
	public static final Integer NUM_DRONES = 20;
	
	private List<String> dronFiles;
	
	public DronApplication() {
		dronFiles = new ArrayList<String>();
		dronFiles.add("in01.txt");
	}
	
	
	public void start () throws Exception {
		if (dronFiles != null && dronFiles.size() > 0) {
			for (String dronFile : dronFiles) {
				try {
					Dron dron = new Dron (dronFile);
					dron.goDeliveries();
				} catch (Exception e) {
					FileUtil.printResult(dronFile, e.getMessage());
				}
			}
		}
	}
	
	
	public static void main (String [] args) throws Exception {
		DronApplication dronApplication = new DronApplication();
		dronApplication.start();
		
		
	}
	

}
