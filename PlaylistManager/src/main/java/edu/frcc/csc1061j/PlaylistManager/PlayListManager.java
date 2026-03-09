package edu.frcc.csc1061j.PlaylistManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PlayListManager
{
	private MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>(); 
	private int songCount;
	

	public PlayListManager()
	{
		
	}
	
	public PlayListManager(Song song)
	{
		playlist.add(song);
		songCount++;
	}
	
	/**
	 *  Uses Fisher-Yates shuffle to shuffle the playlist
	 */
	public void shuffle()
	{
		Random rand = new Random();
		Song song1;
		Song song2;
	
		for(int i = playlist.size() - 1; i > 0; i--)
		{
			int num = rand.nextInt(i + 1);
			
			song1 = playlist.get(i);
			song2 = playlist.get(num);
			
			playlist.set(i, song2);
			playlist.set(num, song1);
		}
	}
	public void add(Song song)
	{
		playlist.add(song);
		songCount++;
	}
	
	public void remove(Song song)
	{
		playlist.remove(song);
		songCount--;
	}

	public MyDoubleLinkedList<Song> getPlaylist()
	{
		return playlist;
	}

	private void setPlaylist(MyDoubleLinkedList<Song> playlist)
	{
		this.playlist = playlist;
	}

	public int getSongCount()
	{
		return songCount;
	}

	public void setSongCount(int songCount)
	{
		this.songCount = songCount;
	}
	
	public void savePlaylist() throws IOException
	{
		System.out.println("Enter Playlist name: ");
		Scanner scnr = new Scanner(System.in);
		String name = scnr.next();
		File file = new File(name);
		
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		FileOutputStream fileOut = new FileOutputStream(file.getName(), false);
		PrintWriter printer = new PrintWriter(fileOut);
		printer.print(toString());
		printer.println();
		printer.flush();
	}
	
	public MyDoubleLinkedList<Song> loadSong() throws FileNotFoundException
	{
		Scanner scnr = new Scanner(System.in);
		String fileName = scnr.next();
		File file = new File(fileName);
		if(!file.exists())
		{
			throw new FileNotFoundException("File does not Exist");
		}
		
		Scanner reader = new Scanner(file);
		String line;
		if(reader.hasNext())
		{
			line = reader.next();
		}
		else
		{
			return null;
		}
		
		String[] tokens = line.split(",");
		for(int i = 0; i < tokens.length - 1; i++)
		{
			Song song = new Song(tokens[i], tokens[i + 1]);
		}
		
		return playlist;
	}
	
	/**
	 *  Prints play list in this format: "Title by Artist" 
	 */
	public void play()
	{
		Song song = null;
	
		for(int i = 0; i < playlist.size() - 1; i++)
		{
			song = playlist.get(i);
			System.out.print(song.getTitle() + " by " + song.getArtist() + ", ");
		}
		// print the last song and artist with out a comma
		System.out.print(song.getTitle() + " by " + song.getArtist());
		
		System.out.println();
	}
	
	/**
	 * Uses string builder to format it for file reader
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Song song : playlist)
		{
			sb.append(song.getTitle());
			sb.append(",");
			sb.append(song.getArtist());
			sb.append(",");
		}
		return sb.toString();
	}
}
