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


}
