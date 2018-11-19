package com.partha.designPatterns.structural.composite1;

public class Song extends SongComponent{
	
	String songName;
	String bandName;
	int releasedYear;
	
	public Song(String newSongName,String newBandName,int newYearReleased){
		songName=newSongName;
		bandName=newBandName;
		releasedYear=newYearReleased;
	}

	public String getSongName() {		return songName;	}
	public String getBandName() {		return bandName;	}
	public int getReleasedYear() {		return releasedYear;	}
	
	public void displaySongInfo(){
		System.out.println(getSongName()+" was recorded by "+getBandName()+" in the year"+getReleasedYear());
	}

}

