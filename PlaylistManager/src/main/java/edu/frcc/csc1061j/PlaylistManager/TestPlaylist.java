package edu.frcc.csc1061j.PlaylistManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestPlaylist
{

	public static void main(String[] args)
	{
		Song song1 = new Song("Song", "Artist");
		Song song2 = new Song("Yellow", "Blue");
		Song song3 = new Song("Song", "Singer");
		Song song4 = new Song("Title", "Artist");

		PlayListManager playlistM = new PlayListManager(song1);

		playlistM.add(song2);
		playlistM.add(song3);
		playlistM.add(song4);

		playlistM.play();
		playlistM.shuffle();
		playlistM.play();
		playlistM.getPlaylist().reverse();
		playlistM.play();
		System.out.println();
		System.out.print(playlistM.toString());

		System.out.println(playlistM.getPlaylist().count());
		System.out.println(playlistM.getPlaylist().size());

		try
		{
			playlistM.savePlaylist();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{
			playlistM.loadSong();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		playlistM.play();
	}
}
