package com;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String nodeDesc;
	private List<String> inLinks;
	private List<String> outLinks;
	private float oldPageRank;
	private float newPageRank;
	
	public Node(String nodeDesc) {
		super();
		this.nodeDesc = nodeDesc;
		inLinks = new ArrayList<String>();
		outLinks = new ArrayList<String>();
	}
	public String getNodeDesc() {
		return nodeDesc;
	}
	public void setNodeDesc(String nodeDesc) {
		this.nodeDesc = nodeDesc;
	}
	public List<String> getInLinks() {
		return inLinks;
	}
	public void setInLinks(List<String> inLinks) {
		this.inLinks = inLinks;
	}
	public List<String> getOutLinks() {
		return outLinks;
	}
	public void setOutLinks(List<String> outLinks) {
		this.outLinks = outLinks;
	}
	public void setOutLink(String destDesc)
	{
		this.outLinks.add(destDesc);
	}
	public void setInLink(String srcDesc)
	{
		this.inLinks.add(srcDesc);
	}
	/**
	 * @return the oldPageRank
	 */
	public float getOldPageRank() {
		return oldPageRank;
	}
	/**
	 * @param oldPageRank the oldPageRank to set
	 */
	public void setOldPageRank(float oldPageRank) {
		this.oldPageRank = oldPageRank;
	}
	/**
	 * @return the newPageRank
	 */
	public float getNewPageRank() {
		return newPageRank;
	}
	/**
	 * @param newPageRank the newPageRank to set
	 */
	public void setNewPageRank(float newPageRank) {
		this.newPageRank = newPageRank;
	}
}
