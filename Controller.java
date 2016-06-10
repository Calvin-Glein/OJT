import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private DBConnect db = new DBConnect();
	private GUI gui;
	private Scorecard scorecard;

	public Controller(GUI gui, Scorecard scorecard) {
		this.gui = gui;
		this.scorecard = scorecard;
		this.gui.addManualListener(new GUIListenerManual());
		this.gui.addAutomaticEmployeeListener(new GUIListenerEmployee());
		this.gui.addAutomaticCSATListener(new GUIListenerCSAT());
		this.gui.addAutomaticScorecardListener(new GUIListenerScorecard());
	}

	class GUIListenerManual implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			db.addScore(new Scorecard(gui.getEmployeeID(), gui.getMonth(), gui.getYear(), gui.getFullname(),
					gui.getTeam(), gui.getTotalTickets(), gui.getE2E(), gui.getDisputed(), gui.getMissedTickets(),
					gui.getFYR(), gui.getControllableMis(), gui.getCallRegistration(), gui.getCSAT(), gui.getQA(),
					gui.getExternalEscalation()));
		}

	}

	class GUIListenerEmployee implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FileSelector fileSelector = new FileSelector();
			fileSelector.employeeCSV();
			
			
		}

	}
	
	class GUIListenerCSAT implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FileSelector fileSelector = new FileSelector();
			fileSelector.csatCSV();
		}

	}
	
	class GUIListenerScorecard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FileSelector fileSelector = new FileSelector();
			fileSelector.scorecardCSV();
			
		}

	}
	
	


}
