/**
 * Program for Data Structures and Algorithms Coursework 2.
 * Class to create a new ExtraInfo object.
 * Once given the flight 'path' it creates a new 
 * instance with extra information e.g flightNo.
 * @author Ronan Smith
 * @date 24/11/15
 */

public class ExtraInfo 
{
	private String flight;
	private String flightNumber;
	private double arrivalTime;
	private double departureTime;
	private double duration;
	
	/** 
	 * Constructor to take the flight value.
	 * @param flt
	 */
	public ExtraInfo(String flt)
	{
		this.flight 		=  flt;
		addInfo(flt);
	}
	
	/**
	 * Second constructor creates a new ExtraInfo object
	 * with all the extra details included.
	 * @param f
	 * @param fN
	 * @param dT
	 * @param aT
	 * @param d
	 */
	public ExtraInfo(String f, String fN, double dT, double aT, double d )
	{
		this.flight 		=  f;
		this.departureTime 	=  dT;
		this.arrivalTime 	=  aT;
		this.flightNumber 	=  fN;
		this.duration		=  d;
	}
	
	/**
	 * Accessor methods to provide access to each private field.
	 */
	public String getFlight()
	{
		return flight;
	}
	public double getArrivalTime()
	{
		return arrivalTime;
	}
	public String getFlightNo()
	{
		return flightNumber;
	}
	public double getDepatureTime()
	{
		return departureTime;
	}
	public double getDuration()
	{
		return duration;
	}

	/**
	 * Add in the extra information such as flight number,
	 * departure and arrival times, and flight duration. These 
	 * values are assumed to be the same whichever direction you 
	 * travel in for the purpose of this method. 
	 * @return
	 */
	public void addInfo(String flight)
	{
//		DecimalFormat dF = new DecimalFormat("#.00");
		
		if( flight.equals("(Edinburgh : Heathrow)") || flight.equals("(Heathrow : Edinburgh)"))
		{
			flightNumber 			=  "BA 024";
			departureTime 			=  7.00;
			arrivalTime 			=  7.45;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else if ( flight.equals("(Heathrow : Amsterdam)") || flight.equals("(Amsterdam : Heathrow)" ))
		{
			flightNumber 			=  "BA 026";
			departureTime 			=  9.00;
			arrivalTime 			=  10.45;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else if ( flight.equals("(Heathrow : Boston)") || flight.equals("(Boston : Heathrow)"))
		{
			flightNumber 			=  "BA 226";
			departureTime 			=  9.15;
			arrivalTime 			=  16.35;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);			
		}
		else if ( flight.equals("(Boston : Chicago)") || flight.equals("(Chicago : Boston)"))
		{
			flightNumber 			=  "BA 125";
			departureTime 			=  12.15;
			arrivalTime 			=  16.35;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else if (flight.equals("(Boston : Montreal)") || flight.equals("(Montreal : Boston)"))
		{
			flightNumber 			=  "BA 124";
			departureTime 			=  18.15;
			arrivalTime 			=  22.15;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
			
		}
		else if (flight.equals("(Montreal : Toronto)") || flight.equals("(Toronto : Montreal)"))
		{
			flightNumber 			=  "BA 123";
			departureTime 			=  19.15;
			arrivalTime 			=  21.35;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else if (flight.equals("(Edinburgh : Chicago)") || flight.equals("(Chicago : Edinburgh)"))
		{
			flightNumber 			=  "BA 227";
			departureTime 			=  10.00;
			arrivalTime 			=  19.35;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else if (flight.equals("(New Delhi : Shanghai)") || flight.equals("(Shanghai : New Delhi)"))
		{
			flightNumber 			=  "BA 447";
			departureTime 			=  12.15;
			arrivalTime 			=  20.35;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else if (flight.equals("(Shanghai : Hong-Kong)") || flight.equals("(Hong-Kong : Shanghai)"))
		{
			flightNumber 			=  "BA 448";
			departureTime 			=  21.00;
			arrivalTime 			=  24.00;
			duration 				=  arrivalTime - departureTime;
			
			createInfo(flightNumber, departureTime, arrivalTime, duration);
		}
		else
		{
			System.err.println("There has been an error");
		}
	}
	
	/**
	 * Call constructor with new values for each piece of the 
	 * extra information. 
	 * @param flightNo
	 * @param departureTime
	 * @param arrivalTime
	 * @param flightTime
	 * @return e
	 */
	private ExtraInfo createInfo(String flightNo, double departureTime, double arrivalTime, double flightTime )
	{	
		ExtraInfo e = new ExtraInfo(flight, flightNo, 
				departureTime,arrivalTime, duration);
		return e;
	}
	

}
