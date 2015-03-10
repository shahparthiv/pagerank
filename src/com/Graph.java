package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph {
	private Map<String, Node> nodes;
	private static int length ;

	private Graph() {
		nodes = new HashMap<String, Node>();
	}

	public static Graph createGraph(File file,int forStartingPageRank) {
		Graph graph = new Graph();
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String firstLine = reader.readLine();
			float length=Float.parseFloat(firstLine.split(" ")[0]);
			setLength((int)(length));
			Float initialPageRank = null;
			DecimalFormat df = new DecimalFormat("#.000000");
			
			switch (forStartingPageRank) {
			case 0:
				initialPageRank=Float.parseFloat(df.format(0));
				break;
			case 1:
				initialPageRank=Float.parseFloat(df.format(1));
				break;
			case -1:
				initialPageRank=Float.parseFloat(df.format(1/length));
				break;
			case -2:
				initialPageRank=Float.parseFloat(df.format(1/Math.sqrt(length)));
				break;
			default:
				break;
			}
			String edge;
			int i = 0;
			while ((edge = reader.readLine()) != null) {
					String[] nodePair = edge.split(" ");
					String srcDesc = nodePair[0];
					String destDesc = nodePair[1];
					Node srcNode = graph.getNode(srcDesc);
					if (srcNode == null) {
						srcNode = new Node(srcDesc);
						srcNode.setOutLink(destDesc);
						srcNode.setOldPageRank(initialPageRank);
						graph.nodes.put(srcDesc, srcNode);
					} else {
						srcNode.setOutLink(destDesc);
					}
					Node destNode = graph.getNode(destDesc);
					if (destNode == null) {
						destNode = new Node(destDesc);
						destNode.setInLink(srcDesc);
						destNode.setOldPageRank(initialPageRank);
						graph.nodes.put(destDesc, destNode);
					} else {
						destNode.setInLink(srcDesc);
					}
				}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return graph;
	}

	public Map<String, Node> getNodes() {
		return nodes;
	}

	public Node getNode(String nodeDesc) {
		return nodes.get(nodeDesc);
	}
	public void display(int forItration)
	{
		TreeMap<String, Node> treeMap = new TreeMap<String, Node>(nodes);
		Iterator<String> i = treeMap.keySet().iterator();
		int j =1;
		float sum = 0f;
		DecimalFormat df1 = new DecimalFormat("#.000000");
		//df.setMaximumFractionDigits(6);
		int p;
		if(forItration== 0){
			p=999;
		}else{
			p=forItration;
		}
		float temp = nodes.get(i.next()).getOldPageRank();
		System.out.print("Base\t : 0"+" :");
		for(Map.Entry<String,Node> entry : treeMap.entrySet()) {
			String key = entry.getKey();
			Node node = nodes.get(key);
			System.out.print("P["+node.getNodeDesc()+"] = "+df1.format(temp) +" ");
		}
		System.out.println();
		while(j<=p){
			if(j<=9){
				System.out.print("Iter\t : 0"+j+" :");
			}else{
				System.out.print("Iter\t : "+j+" :");
			}
			for(Map.Entry<String,Node> entry : treeMap.entrySet()) {
				String key = entry.getKey();
				sum =0f;
				Node node = nodes.get(key);
					//System.out.println("Inlinks : "+node.getInLinks());
				List<String> inLinkNodes = node.getInLinks();
				for (String inLinkNode : inLinkNodes) {
					Node tempNode = nodes.get(inLinkNode);
					sum=sum+(tempNode.getOldPageRank()/tempNode.getOutLinks().size());
				}
				float newPageRank = 0.0375f+0.85f*(sum);
				node.setNewPageRank(Float.parseFloat(df1.format(newPageRank)));
				System.out.print("P["+node.getNodeDesc()+"] = "+df1.format(newPageRank) +" ");
			}
			System.out.println();
			j++;
			int m=0;
			for(Map.Entry<String,Node> entry : treeMap.entrySet()) {
				String key = entry.getKey();
				sum =0f;
				Node node = nodes.get(key);
				if(node.getOldPageRank()-node.getNewPageRank()<0.0001){
					m++;
				}
				node.setOldPageRank(node.getNewPageRank());
			}
			if(m==getLength() && forItration == 0){
				break;
			}
		}
	}
	/**
	 * @return the length
	 */
	public static int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public static void setLength(int length) {
		Graph.length = length;
	}
}
