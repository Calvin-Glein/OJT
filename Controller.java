import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private DBConnect db = new DBConnect();
	private GUI gui;
	public Controller(GUI gui, Scorecard scorecard) {
		this.gui = gui;
		this.gui.addManualListener(new GUIListenerManual());
		this.gui.addAutomaticEmployeeListener(new GUIListenerEmployee());
		this.gui.addAutomaticCSATListener(new GUIListenerCSAT());
		this.gui.addAutomaticScorecardListener(new GUIListenerScorecard());
		this.gui.addAutomaticQAListener(new GUIListenerQA());
		this.gui.addAutomaticEscalationListener(new GUIListenerEscalation());
		this.gui.addAutomaticSync(new GUIListenerSync());
		this.gui.addViewScorecardListener(new GUIListenerViewScorecard());
	}

	class GUIListenerManual implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// for wrong inputs/sentinel value
			if (gui.getTotalTickets() == -1) {
				System.out.println("wrong total tickets");
			} else if (gui.getE2E() == -1) {
				System.out.println("wrong e2e");

			} else if (gui.getDisputed() == -1) {
				System.out.println("wrong disputed");

			} else if (gui.getMissedTickets() == -1) {
				System.out.println("wrong missed tickets");

			} else if (gui.getFYR() == -1) {
				System.out.println("wrong fyr");

			} else if (gui.getControllableMis() == -1) {
				System.out.println("wrong controllble mis");

			} else if (gui.getCallRegistration() == -1) {
				System.out.println("wrong registration");

			} else if (gui.getCSAT() == -1) {
				System.out.println("wrong csat");

			} else if (gui.getQA() == -1) {
				System.out.println("wrong qa");

			} else if (gui.getExternalEscalation() == -1) {
				System.out.println("wrong escalation");

			} else {

				db.addScore(new Scorecard(gui.getEmployeeID(), gui.getDate(), gui.getFullname(), gui.getTeam(),
						gui.getTotalTickets(), gui.getE2E(), gui.getDisputed(), gui.getMissedTickets(), gui.getFYR(),
						gui.getControllableMis(), gui.getCallRegistration(), gui.getCSAT(), gui.getQA(),
						gui.getExternalEscalation()));
			}

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

	class GUIListenerQA implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FileSelector fileSelector = new FileSelector();
			fileSelector.qaCSV();

		}

	}

	class GUIListenerEscalation implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FileSelector fileSelector = new FileSelector();
			fileSelector.escalationCSV();

		}

	}

	class GUIListenerSync implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FileSelector fileSelector = new FileSelector();
			fileSelector.sync();

		}

	}
	
	class GUIListenerViewScorecard implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GUIScorecard guiScorecard = new GUIScorecard();
		}

	}

}
