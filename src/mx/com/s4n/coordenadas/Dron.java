package mx.com.s4n.coordenadas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import mx.com.s4n.file.FileUtil;

/**
 * A dron
 * @author alvazquez
 *
 */
public class Dron {
	
	public static final Integer NUM_DELIVERIES = 3;
	public static final String  REPORT_HADER = "== Reporte de entregas ==";
	
	/**
	 * File In Name
	 */
	private String fileInName;
	
	/**
	 * Set of deliveries instructions
	 */
	private List<String> deliveriesInstrucions;
	
	
	/**
	 * Create a Dron
	 * @param deliveriesInstrucions deliveries instructions
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Dron(String fileInName) throws FileNotFoundException, IOException {
		super();
		this.fileInName = fileInName;
		this.deliveriesInstrucions = FileUtil.readFile(this.fileInName);
		
	}



	/**
	 * Go to all deliveries
	 * @return
	 * @throws Exception
	 */
	public void goDeliveries () throws Exception {
		DronPosition step = DronPosition.stepCero(); //The first position (0,0,N)
		
		if (deliveriesInstrucions != null && deliveriesInstrucions.size() > 0) {
			if (deliveriesInstrucions.size() <= NUM_DELIVERIES) {
				String[] results = new String[deliveriesInstrucions.size() + 1];
				results[0] = REPORT_HADER;
				int i = 1;
				for (String deliveryInstrucion : deliveriesInstrucions) {
					
					DronDelivery dronDelivery = new DronDelivery(step, deliveryInstrucion);
					step = dronDelivery.delivery();
					results[i] = step.toString();
					i++;
				}
				FileUtil.printResults(fileInName, results);
				
			} else {
				throw new Exception ("The limit of deliveries is " + NUM_DELIVERIES + " by dron");
			}
		} else {
			throw new Exception ("The file doesn't have instructions");
		}
	}

}
