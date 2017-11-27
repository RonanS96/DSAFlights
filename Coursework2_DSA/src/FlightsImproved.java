/** 

 * Program for Data Structures and Algorithms Coursework 2.
 * Improved version of the Flight class which creates a graph 
 * to represent airports and flights and uses the ExtraInfo class 
 * to add extra information to the output of the program.
 * @author Ronan Smith
 * @date 24/11/15
 */


public class FlightsImproved
{
	private Scanner input;

	/** initialised to null, will be instantiated at a later stage */
	private Object firstPath 	= null;
	private Object secondPath 	= null;
	private Object thirdPath 	= null;
	private Object fourthPath 	= null;
	private Object fifthPath 	= null;
	
	public static void main(String[] args)
	{
		FlightsImproved fi = new FlightsImproved();
		fi.buildGraph();
	}

	/**	
	 * 	(Part A) Method used to create the graph with vertices 
	 *  to represent airports, edges to represent journeys
	 *  between, and weights to represent the price of the journey. 
	 */
	public void buildGraph()
	{
		// create a weighted and undirected JGraphT graph
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> g = 
				new SimpleDirectedWeightedGraph<String,DefaultWeightedEdge>(
						DefaultWeightedEdge.class);
		
		// airports							   	   /* codes */
		String edinburgh 		=  	"Edinburgh";	/* EDI */
		String heathrow 		=  	"Heathrow";		/* LHR */
		String amsterdam 		=  	"Amsterdam";	/* AMS */
		String boston 			=  	"Boston";		/* BOS */
		String chicago			=  	"Chicago";		/* ORD */
		String montreal 		=  	"Montreal";		/* MON */
		String toronto			=  	"Toronto";		/* TOR */
		String newDelhi			=  	"New Delhi";	/* DEL */
		String shanghai	 		=  	"Shanghai";		/* SHA */
		String hongKong			=  	"Hong-Kong";	/* HKO */
	
	
		// vertexes created to represent each airport.
	    g.addVertex(edinburgh);
	    g.addVertex(heathrow);
	    g.addVertex(amsterdam);
	    g.addVertex(boston);
	    g.addVertex(chicago);
	    g.addVertex(montreal);
	    g.addVertex(toronto);	      
	    g.addVertex(newDelhi);
	    g.addVertex(shanghai);
	    g.addVertex(hongKong);
	
	    // Forward journeys											//Backward journey
	    DefaultWeightedEdge e1 = g.addEdge(heathrow, edinburgh);	DefaultWeightedEdge e11 = g.addEdge(edinburgh, heathrow);				
			g.setEdgeWeight(e1, 110.0);									g.setEdgeWeight(e11, 110.0);
		DefaultWeightedEdge e2 = g.addEdge(heathrow, amsterdam);	DefaultWeightedEdge e12 = g.addEdge(amsterdam, heathrow);	
      		g.setEdgeWeight(e2, 100.0);									g.setEdgeWeight(e12, 100.0);
      	DefaultWeightedEdge e3 = g.addEdge(heathrow, boston);		DefaultWeightedEdge e13 = g.addEdge(boston, heathrow);	
      		g.setEdgeWeight(e3, 230.0);									g.setEdgeWeight(e13, 230.0);
      	DefaultWeightedEdge e4 = g.addEdge(boston, chicago);		DefaultWeightedEdge e14 = g.addEdge(chicago, boston);	
            g.setEdgeWeight(e4, 150.0);									g.setEdgeWeight(e14, 150.0);
        DefaultWeightedEdge e5 = g.addEdge(boston, montreal);		DefaultWeightedEdge e15 = g.addEdge(montreal, boston);        
      		g.setEdgeWeight(e5, 100.0);									g.setEdgeWeight(e15, 100.0);
        DefaultWeightedEdge e6 = g.addEdge(montreal, toronto);		DefaultWeightedEdge e16 = g.addEdge(toronto, montreal);
        	g.setEdgeWeight(e6, 90.0);									g.setEdgeWeight(e16, 90.0);
        DefaultWeightedEdge e7 = g.addEdge(edinburgh, chicago);		DefaultWeightedEdge e17 = g.addEdge(chicago, edinburgh);      
      		g.setEdgeWeight(e7, 560.0);									g.setEdgeWeight(e17, 560.0);
        DefaultWeightedEdge e8 = g.addEdge(newDelhi, shanghai);		DefaultWeightedEdge e18 = g.addEdge(shanghai, newDelhi);
      		g.setEdgeWeight(e8, 430.0);									g.setEdgeWeight(e18, 430.0);
        DefaultWeightedEdge e9 = g.addEdge(shanghai, hongKong);		DefaultWeightedEdge e19 = g.addEdge(hongKong, shanghai);
      		g.setEdgeWeight(e9, 230.0);									g.setEdgeWeight(e19, 230.0);
	
      	// array storing the values of all the vertices
	    String[] airports = new String[]{edinburgh, heathrow, amsterdam, boston,
		    	chicago, montreal, toronto, newDelhi, shanghai, hongKong};
	    shortestPath(airports, g);
	    
	}
	
	 /**
	  * Finds the shortest path between two airports provided 
	  * by the user, and prints out information to the terminal.
	  * @param airports
	  * @param g
	  */
	 private void shortestPath(String[] airports, SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> g ) 
	 {
		 input = new Scanner( System.in );
		 
		 System.out.println(g.toString());
		 System.out.println("----------------------------------------------------------");
		 System.out.println("The following airports are used:");
	      for(int i = 0; i < airports.length; i++)
	      {
	    	  System.out.println(airports[i]);
	      }
	      System.out.println("Please enter the start airport (Remember to capitalize the first letter and type \n the "
	      		 +"airport as it is displayed above, i.e type Hong-Kong, not HongKong \n or Hong Kong): "); 
	      String startAirport = input.nextLine();
	      System.out.println("Please enter the destination airport: ");
	      String destination = input.nextLine();
	 
	      try
	      {
	    	  DijkstraShortestPath<String, DefaultWeightedEdge> dsp = new DijkstraShortestPath<String, DefaultWeightedEdge>(g, startAirport, destination, 1000000.00);
	     
		      int noOfFlights = dsp.getPathEdgeList().size();
		      
		      System.out.println("The cheapest journey from " + startAirport + " to " + destination 
		    		  + "\n includes " + noOfFlights + " flight(s)"
		    		  + " and the total cost of this journey is �" + dsp.getPathLength() + "." );
		      
		      
		      System.out.println(dsp.getPathEdgeList().toString());
		      
		      /** 
		       * get each flight in the overall journey...
		       */
		      if(noOfFlights == 1)
		      {
		    	  firstPath 	=  dsp.getPathEdgeList().get(0);
		    	  ExtraInfo eI 	= new ExtraInfo(firstPath.toString());
		    	  System.out.println("FLIGHT: " + firstPath.toString() );
		    	  printInfo(eI);
		      }
		      else if(noOfFlights == 2 )
		      {
		    	  firstPath 	=  dsp.getPathEdgeList().get(0);
		    	  ExtraInfo eI 	= new ExtraInfo(firstPath.toString());
		    	  secondPath =  dsp.getPathEdgeList().get(1);
		    	  ExtraInfo eI2 	= new ExtraInfo(secondPath.toString());
		    	  
		    	  System.out.println("------------------------------------------------------------------------");
		    	  System.out.println("FLIGHT ONE: " + firstPath.toString());
		    	  printInfo(eI);
		    	  
			      System.out.println("------------------------------------------------------------------------");
			      
			      System.out.println("FLIGHT TWO:" + secondPath.toString());
		    	  printInfo(eI2);
			      
			      System.out.println("------------------------------------------------------------------------");
			      
		      }
		      else if(noOfFlights == 3)
		      {
		    	  firstPath 	=  dsp.getPathEdgeList().get(0);
		    	  ExtraInfo eI 	= new ExtraInfo(firstPath.toString());
		    	  secondPath 	=  dsp.getPathEdgeList().get(1);
		    	  ExtraInfo eI2 = new ExtraInfo(secondPath.toString());
		    	  thirdPath 	=  dsp.getPathEdgeList().get(2);
		    	  ExtraInfo eI3 = new ExtraInfo(thirdPath.toString());
		    	  
		    	  System.out.println("------------------------------------------------------------------------");
		    	  System.out.println("FLIGHT ONE:" + firstPath.toString());
		    	  printInfo(eI);
		    	  System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT TWO:" + secondPath.toString());
		    	  printInfo(eI2);
			      System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT THREE:" + thirdPath.toString());
		    	  printInfo(eI3);
			      System.out.println("------------------------------------------------------------------------");
		      }
		      else if(noOfFlights == 4)
		      {
		    	  firstPath 	=  dsp.getPathEdgeList().get(0);
		    	  ExtraInfo eI 	= new ExtraInfo(firstPath.toString());
		    	  secondPath 	=  dsp.getPathEdgeList().get(1);
		    	  ExtraInfo eI2 = new ExtraInfo(secondPath.toString());
		    	  thirdPath 	=  dsp.getPathEdgeList().get(2);
		    	  ExtraInfo eI3 = new ExtraInfo(thirdPath.toString());
		    	  fourthPath 	=  dsp.getPathEdgeList().get(3);
		    	  ExtraInfo eI4 = new ExtraInfo(fourthPath.toString());
		    	  
		    	  System.out.println("------------------------------------------------------------------------");
		    	  System.out.println("FLIGHT ONE: " + firstPath.toString());
		    	  printInfo(eI);
		    	  System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT TWO: " + secondPath.toString());
		    	  printInfo(eI2);
			      System.out.println("------------------------------------------------------------------------");
		    	  System.out.println("FLIGHT THREE: " );
		    	  printInfo(eI3);
			      System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT FOUR: " + thirdPath.toString());
		    	  printInfo(eI4);
			      System.out.println("------------------------------------------------------------------------");
		      }
		      else if(noOfFlights == 5)
		      {

		    	  firstPath 	=  dsp.getPathEdgeList().get(0);
		    	  ExtraInfo eI 	= new ExtraInfo(firstPath.toString());
		    	  secondPath 	=  dsp.getPathEdgeList().get(1);
		    	  ExtraInfo eI2 = new ExtraInfo(secondPath.toString());
		    	  thirdPath 	=  dsp.getPathEdgeList().get(2);
		    	  ExtraInfo eI3 = new ExtraInfo(thirdPath.toString());
		    	  fourthPath 	=  dsp.getPathEdgeList().get(3);
		    	  ExtraInfo eI4 = new ExtraInfo(fourthPath.toString());
		    	  fifthPath 	=  dsp.getPathEdgeList().get(4);
		    	  ExtraInfo eI5 = new ExtraInfo(fifthPath.toString());
		    	  
		    	  System.out.println("------------------------------------------------------------------------");
		    	  System.out.println("FLIGHT ONE: " + firstPath.toString() );
		    	  printInfo(eI);
			      System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT TWO: " + secondPath.toString());
		    	  printInfo(eI2);
			      System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT THREE: " + thirdPath.toString());
		    	  printInfo(eI3);
			      System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT FOUR: " + fourthPath.toString());
		    	  printInfo(eI4);
			      System.out.println("------------------------------------------------------------------------");
			      System.out.println("FLIGHT FIVE: " + fifthPath.toString());
		    	  printInfo(eI5);
			      System.out.println("------------------------------------------------------------------------");
		      }
	      
	      }
	      catch (NullPointerException e)
	      {
	    	  System.err.println("There is no possible journey between " 
	    			  	+ startAirport + " and " + destination + ".");
	      }
	      catch ( Exception e )
	      {
	    	  System.err.println("There has been a problem. Please make sure you have typed \n"
	    			  + "the input correctly and also make sure it has not been left blank. \n"
	    			  + "Also, there can not be a space at the end of your input.");
	      }
	 }

	 /**
	  * Prints additional information about the journey.
	  * @param info
	  */
	private void printInfo(ExtraInfo info) 
	{
		System.out.println("The flight number is: " + info.getFlightNo());
	    System.out.println("Departure Time(GMT): "  + info.getDepatureTime());
	    System.out.println("Arrival Time(GMT): " 	+ info.getArrivalTime());
	    double flightTime = info.getDuration();
	    System.out.println("Flight Duration: "      + round(flightTime,2) + " hours.");
		
	}

	/**
	 * Rounds a double to 2 d.p.
	 * Taken from http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) 
	{
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
}
