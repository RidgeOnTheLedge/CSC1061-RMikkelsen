/*
 * Copyright (C) 2026 Ridge Mikkelsen
 * 
 * Permissions BLAH, BLAH
 */
import java.util.Arrays;

/**
 * Methods to convert temperature from one system to another.
 * 
 * @author Ridge Mikkelsen
 * @author Some Dude
 */
public class TempConverter
{
	public final double FREEZING_TEMP_CEL = 0;
	public final double FREEZING_TEMP_FAH = 32;
	/**
	 * Converts a temp from fahrenheit to celsius
	 * @param temp in fah
	 * @return temp in cel
	 */
	public static double ConvertFahToCel(double input)
	{	
		return ((input - 32) * (5.0/9.0));
	}
	
	/**
	 * Convert temp from Cel to Fah
	 * @param temp in cel
	 * @return temp in fah
	 */
	public static double ConvertCelToFah(double input)
	{	
		return input * (9.0/5.0) + 32;
	}
}

