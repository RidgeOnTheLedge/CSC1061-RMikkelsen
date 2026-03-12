package edu.frcc.csc1061j.PlaylistManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestPlaylist
{
	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args)
	{
		PlayListManager playlistM = new PlayListManager();
		System.out.println("Play List Manager");
		System.out.println("Select Options by Entering a Number");
		String menuPrompt ="Select Options:\n1. Load Playlist 2. "
				+ "Save Playlist\n3. Add Song "
				+ "     4. Play \n5. Shuffle       "
				+ "6. Reverse\n7. Remove Song   8. Song Count "
				+ "\n9. Exit";
		
		int userInput = readInt(scnr, menuPrompt);
		while (userInput != 9)
		{
			// Each Case comes from userInput,
			// Could switch numbers with constants
			switch (userInput) {
			case 1:
			{	
				playlistM.loadPlaylist(scnr);
				break;
			}
			case 2:
			{
				playlistM.savePlaylist(scnr);
				break;
			}
			case 3:
			{
				playlistM.add(scnr);
				break;
			}
			case 4:
			{
				playlistM.play();
				break;
			}
			case 5:
			{
				playlistM.shuffle();
				break;
			}
			case 6:
			{
				playlistM.getPlaylist().reverse();
				break;
			}
			case 7:
			{
				remove(playlistM);
				break;
			}
			case 8:
			{
				System.out.println("Song Count: " + playlistM.getPlaylist().count());
				break;
			}
			default:
			{
				break;
			}
			}

			userInput = readInt(scnr, menuPrompt);
		}
		scnr.close();
	}

	
	/**
	 * Reads and makes sure user input is valid, if not it will
	 * continue to prompt the user.
	 * Note would be better if stored in a utility class.
	 * @param scnr
	 * @param prompt
	 * @return Valid userInput
	 */
	public static int readInt(Scanner scnr, String prompt)
	{
		while(true)
		{
			System.out.println(prompt);
			
			if(scnr.hasNextInt())
			{
				int value = scnr.nextInt();
				scnr.nextLine();
				return value;
			}
			
			System.out.println("Please enter a valid number");
			scnr.nextLine();
		}
	}
	
	private static void remove(PlayListManager playlistM)
	{
		if(playlistM.getPlaylist().isEmpty())
		{
			System.out.println("There are no Songs to Remove");
			return;
		}
		
		// Display songs that can be removed
		playlistM.play();
		System.out.println();
		int userInput = readInt(scnr, 
				"Enter Song Number to Remove: ") - 1;
		
		playlistM.remove(userInput);
	}
}
