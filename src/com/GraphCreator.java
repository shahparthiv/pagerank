package com;

import java.io.File;
import java.text.DecimalFormat;

public class GraphCreator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int forItration =-9;
		int forStartingPageRank=-9;
		String fileName = null;
		
		if(args.length!=3){
			System.out.println("Please pass Three argument ...");
			System.exit(0);
		}
		try{
			forItration = Integer.parseInt(args[0]);
			forStartingPageRank = Integer.parseInt(args[1]);
			fileName = args[2];
		}catch(NumberFormatException nfe){
			System.out.println("Invalid Arguments ...");
			System.exit(0);
		}
		System.out.println("Creating Graph..");
		
		Graph graph = Graph.createGraph(new File(fileName),forStartingPageRank);//"nodes.txt"
		System.out.println("Graph created.");
		graph.display(forItration);
		//System.out.println(graph.getNodes());
	}

}
