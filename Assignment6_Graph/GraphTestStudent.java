package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * This is a test class for the Graph class
 * @author Anner Arevalo
 * @version 12/3/23
 */
class GraphTestStudent
{
	Graph graph;
	ArrayList<String> arr;
	Town a;
	Town b;
	Town c;
	Town d;
	Town e;
	@BeforeEach
	void setUp() throws Exception
	{
		graph = new Graph();
		arr = new ArrayList<>();
		a = new Town("A");
		b = new Town("B");
		c = new Town("C");
		d = new Town("D");
		e = new Town("E");
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addEdge(a, d, 1, "First St.");
		graph.addEdge(a, b, 6, "Second St.");
		graph.addEdge(d, b, 2, "Third St.");
		graph.addEdge(d, e, 1, "Fourth St.");
		graph.addEdge(e, b, 2, "Fifth St.");
		graph.addEdge(b, c, 5, "Sixth St.");
		graph.addEdge(e, c, 5, "Seventh St.");
	}

	@AfterEach
	void tearDown() throws Exception
	{
		graph = null;
		arr = null;
	}

	@Test
	void testGetTowns()
	{
		assertEquals(graph.getTowns(), this.graph.towns);
	}
	
	@Test
	void testGetRoads()
	{
		assertEquals(graph.getRoads(), this.graph.roads);
	}
	
	@Test
	void testGetEdge()
	{
		Road temp = new Road(a, d, 1, "First St.");
		assertEquals(graph.getEdge(a, d), temp);
		temp = new Road(a, b, 1, "First St.");
		assertEquals(graph.getEdge(a, b), temp);
		assertEquals(graph.getEdge(a, e), null);
		assertEquals(graph.getEdge(a, c), null);
	}
	
	@Test
	void testAddEdge()
	{
		assertEquals(graph.addEdge(a, d, 1, "First St."), null);
		Road temp = new Road(a, c, 10, "Eigth St.");
		assertEquals(graph.addEdge(a, c, 10, "Eigth St."), temp);
	}
	
	@Test
	void testAddVertex()
	{
		Town temp = new Town("Z");
		assertEquals(graph.addVertex(temp), true);
		temp = new Town("A");
		assertEquals(graph.addVertex(temp), false);
	}
	
	@Test
	void testContainsEdge()
	{
		assertEquals(graph.containsEdge(a, c), false);
		graph.addEdge(a, c, 10, "Eigth St.");
		assertEquals(graph.containsEdge(a, c), true);
		
	}
	
	@Test
	void testContainsVertex()
	{
		Town z = new Town("Z");
		assertEquals(graph.containsVertex(z), false);
		graph.addVertex(z);
		assertEquals(graph.containsVertex(z), true);
	}
	
	@Test
	void testRemoveEdge()
	{
		assertEquals(graph.removeEdge(a, c, 10, "Eigth St."), null);
		graph.addEdge(a, c, 10, "Eigth St.");
		Road temp = new Road(a, c, 10, "Eigth St.");
		assertEquals(graph.removeEdge(a, c, 10, "Eigth St."), temp);
		
	}
	
	@Test
	void testRemoveVertex()
	{
		Town temp = new Town("Z");
		assertEquals(graph.removeVertex(temp), false);
		assertEquals(graph.removeVertex(a), true);
	}
	
	@Test
	void testVertexSet()
	{
		fail("Not yet implemented");
	}

	@Test
	void testEdgeSet()
	{
		fail("Not yet implemented");
	}

	@Test
	void testEdgesOf()
	{
		fail("Not yet implemented");
	}

	@Test
	void testShortestPath()
	{
		fail("Not yet implemented");
	}

	@Test
	void testDijkstraShortestPath()
	{
		fail("Not yet implemented");
	}

	@Test
	void testPath()
	{
		fail("Not yet implemented");
	}
}
