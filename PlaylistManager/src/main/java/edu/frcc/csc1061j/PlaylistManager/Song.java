package edu.frcc.csc1061j.PlaylistManager;

public class Song
{
	private String title;
	private String artist;
	private Song(String title, String artist)
	{
		this.title = title;
		this.artist = artist;
	}
	
	@Override
	public String toString()
	{
		return "Song [title=" + title + ", artist=" + artist + "]";
	}
}
