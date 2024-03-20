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

	@Override
	public String getSongName() {		return songName;	}

	@Override
	public String getBandName() {		return bandName;	}

	@Override
	public int getReleasedYear() {		return releasedYear;	}

	@Override
	public void displaySongInfo(){
		System.out.println(getSongName()+" was recorded by "+getBandName()+" in the year"+getReleasedYear());
	}

}

