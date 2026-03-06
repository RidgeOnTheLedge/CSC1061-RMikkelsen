package edu.frcc.csc1061j.PlaylistManager;

public class PlayListManager
{
	private Song song;
	private MyDoubleLinkedList<Song> playlist; 
	
	public PlayListManager(Song song)
	{
		this.song = song;
		playlist.add(song);
	}
	
	public void addSong(Song song)
	{
		playlist.add(song);
	}
}
