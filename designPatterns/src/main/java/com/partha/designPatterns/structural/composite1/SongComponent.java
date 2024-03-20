package com.partha.designPatterns.structural.composite1;

public class SongComponent {
	
	public void add(SongComponent newSongComponent){
		throw new UnsupportedOperationException();
	}
	
	public void remove(SongComponent newSongComponent){
		throw new UnsupportedOperationException();
	}
	
	public SongComponent getComponent(int componentIndex){
		throw new UnsupportedOperationException();
	}

	public String getSongName(){
		throw new UnsupportedOperationException();
	}

	public String getBandName(){
		throw new UnsupportedOperationException();
	}
	
	public int getReleasedYear(){
		throw new UnsupportedOperationException();
	}
	
	public void displaySongInfo(){
		throw new UnsupportedOperationException();
	}

	/**
	 * note that this has default implementation for all methods and its not an abstract class.
	 * while some methods are overriden by the Song class
	 * while some methods are overriden by the SongGroup class
	 * while method like displaySongInfo is being overriden by both Song and SongGroup class
	 */


}
