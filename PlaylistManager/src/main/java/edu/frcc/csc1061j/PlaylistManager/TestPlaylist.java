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
		System.out.println("Select Options:\n1. Load Playlist 2. Save Playlist\n3. Add Song "
				+ "     4. Play \n5. Shuffle       6. Reverse\n7. Remove Song   8. Song Count \n9. Exit");

		int userInput = scnr.nextInt();
		scnr.nextLine();
		while(userInput != 9)
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
				playlistM.remove(scnr);
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
			
			System.out.println("Select Options:\n1. Load Playlist \n2. Save Playlist\n3. Add Song "
					+ "\n4. Play \n5. Shuffle \n6. Reverse\n7. Remove Song \n8. Exit");
			userInput = scnr.nextInt();
			scnr.nextLine();
		}
		scnr.close();
	}

}
