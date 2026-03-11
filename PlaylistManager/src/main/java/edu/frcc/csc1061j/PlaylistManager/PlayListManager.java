package edu.frcc.csc1061j.PlaylistManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PlayListManager
{
	private MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>();

	public PlayListManager()
	{

	}

	public PlayListManager(Song song)
	{
		playlist.add(song);
	}

	/**
	 * Uses Fisher-Yates shuffle to shuffle the playlist
	 */
	public void shuffle()
	{
		Random rand = new Random();
		Song song1;
		Song song2;

		for (int i = playlist.size() - 1; i > 0; i--)
		{
			int num = rand.nextInt(i + 1);

			song1 = playlist.get(i);
			song2 = playlist.get(num);

			playlist.set(i, song2);
			playlist.set(num, song1);
		}
	}

	public void add(Scanner scnr)
	{
		System.out.println("Enter Artist Name:");
		String artist = scnr.nextLine();
		System.out.println("Enter Song Title: ");
		String title = scnr.nextLine();
		Song song = new Song(title, artist);

		playlist.add(song);
	}

	public void remove(Scanner scnr)
	{
		if(playlist.isEmpty())
		{
			System.out.println("There are no Songs to Remove");
			return;
		}
		
		play();
		System.out.println("Enter Song Number to Remove: ");
		int userInput = scnr.nextInt() - 1;
		if(userInput < 0 || userInput > playlist.size())
		{
			System.out.println("Invalid Song Number");
			return;
		}
		playlist.remove(userInput);
	}

	public MyDoubleLinkedList<Song> getPlaylist()
	{
		return playlist;
	}

	public void savePlaylist(Scanner scnr)
	{
		System.out.println("Enter File Name: ");
		String name = scnr.next();

		try (FileOutputStream fileOut = new FileOutputStream(name, false))
		{
			PrintWriter printer = new PrintWriter(fileOut);
			printer.print(toString());
			printer.flush();
		} catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (IOException e1)
		{
			System.out.println(e1.getMessage());
			System.exit(-1);
		}
	}

	public MyDoubleLinkedList<Song> loadPlaylist(Scanner scnr)
	{
		System.out.println("Enter File Name: ");
		String fileName = scnr.next();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			playlist.clear();
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.trim().isEmpty())
				{
					continue;
				}

				String[] tokens = line.split(",");
				Song song = new Song(tokens[0], tokens[1]);
				playlist.add(song);
			}

			return playlist;
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		}

		return null;
	}

	/**
	 * Prints play list in this format: "Title by Artist"
	 */
	public void play()
	{
		for (int i = 0; i < playlist.size(); i++)
		{
			Song song = playlist.get(i);
		
			if(i == playlist.size() - 1)
			{
				System.out.print((i + 1) + ". " + song.getTitle() + " by " + song.getArtist());
			}
			else
			{
				System.out.print((i + 1) + ". " + song.getTitle() + " by " + song.getArtist() + ", ");
			}
		}

		System.out.println();
	}

	/**
	 * Uses string builder to format it for file reader
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (Song song : playlist)
		{
			sb.append(song.getTitle());
			sb.append(",");
			sb.append(song.getArtist());
			sb.append("\n");
		}
		return sb.toString();
	}
}
