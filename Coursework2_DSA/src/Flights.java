/**
 * Program for Data Structures and Algorithms Coursework 2.
 * Uses a graph to represent airports and the flights between 
 * them. This code answers parts A and B.
 * @author Ronan Smith
 * @date (completed) 24/11/2015.	
 */
import java.util.Scanner;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


public class Flights 
{
	private Scanner input;
	
	/**
	 * Main method. Creates a new 'Flights' object and 
	 * calls the buildGraph() method.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Flights f = new Flights();
		f.buildGraph();
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
	      
		 System.out.println("Please enter the start airport <Remember to capitalize the first letter and type \n the "
	      		 +"airport as it is displayed above, i.e type Hong-Kong, not HongKong \n or Hong Kong>: "); 
	     String startAirport = input.nextLine();
	     System.out.println("Please enter the destination airport: ");
	     String destination = input.nextLine();
	 
	      try
	      {
	    	  DijkstraShortestPath<String, DefaultWeightedEdge> dsp = new DijkstraShortestPath<String, DefaultWeightedEdge>(g, startAirport, destination, 1000000.00);
	     
	//	      int totalPathPrice = dsp.getPathEdgeList().size();
		      
		      System.out.println("The cheapest journey from " + startAirport + " to " + destination
		    		  + " is: ");
		      System.out.println(dsp.getPathEdgeList());
		      
		      System.out.println("and the cost of this journey is £" + dsp.getPathLength());
	      }
	      catch (NullPointerException e)
	      {
	    	  System.err.println("There is no possible journey between " 
	    			  	+ startAirport + " and " + destination + ".");
	      }
	 
	 }
	
}
