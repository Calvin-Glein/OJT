import java.util.Date;

public class Scorecard {

	private int id;
	private Date date;
	private String fullname;
	private String team;
	private int totalTickets;
	private double cwtE2E;
	private double cwtDisputed;
	private int missedTickets;
	private int fyr;
	private int controllableMiss;
	private double callRegistration;
	private double csat;
	private double qa;
	private int externalEscalation;

	public Scorecard(int id, Date date, String fullname, String team, int totalTickets, double cwtE2E,
			double cwtDisputed, int missedTickets, int fyr, int controllableMiss, double callRegistration, double csat,
			double qa, int externalEscalation) {
		super();
		this.id = id;
		this.date = date;
		this.fullname = fullname;
		this.team = team;
		this.totalTickets = totalTickets;
		this.cwtE2E = cwtE2E;
		this.cwtDisputed = cwtDisputed;
		this.missedTickets = missedTickets;
		this.fyr = fyr;
		this.controllableMiss = controllableMiss;
		this.callRegistration = callRegistration;
		this.csat = csat;
		this.qa = qa;
		this.externalEscalation = externalEscalation;
	}

	public Scorecard() {
		// TODO Auto-generated constructor stub
	}

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}

	public double getCwtE2E() {
		return cwtE2E;
	}

	public void setCwtE2E(double cwtE2E) {
		this.cwtE2E = cwtE2E;
	}

	public double getCwtDisputed() {
		return cwtDisputed;
	}

	public void setCwtDisputed(double cwtDisputed) {
		this.cwtDisputed = cwtDisputed;
	}

	public int getMissedTickets() {
		return missedTickets;
	}

	public void setMissedTickets(int missedTickets) {
		this.missedTickets = missedTickets;
	}

	public int getFyr() {
		return fyr;
	}

	public void setFyr(int fyr) {
		this.fyr = fyr;
	}

	public int getControllableMiss() {
		return controllableMiss;
	}

	public void setControllableMiss(int controllableMiss) {
		this.controllableMiss = controllableMiss;
	}

	public double getCallRegistration() {
		return callRegistration;
	}

	public void setCallRegistration(double callRegistration) {
		this.callRegistration = callRegistration;
	}

	public double getCsat() {
		return csat;
	}

	public void setCsat(double csat) {
		this.csat = csat;
	}

	public double getQa() {
		return qa;
	}

	public void setQa(double qa) {
		this.qa = qa;
	}

	public int getExternalEscalation() {
		return externalEscalation;
	}

	public void setExternalEscalation(int externalEscalation) {
		this.externalEscalation = externalEscalation;
	}

	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
