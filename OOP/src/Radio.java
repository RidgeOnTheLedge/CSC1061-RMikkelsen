
public class Radio
{
	private static final int MAX_VOLUMNE = 10;
	private int volume;
	private boolean hasAntena;

	
	public int getVolume()
	{
		return volume;
	}
	public void setVolume(int volume)
	{
		if(volume > MAX_VOLUMNE)
		{
			this.volume = MAX_VOLUMNE;
		}
		else 
		{
			this.volume = volume;
		}	
	}
	public boolean isHasAntena()
	{
		return hasAntena;
	}
	public void setHasAntena(boolean hasAntena)
	{
		this.hasAntena = hasAntena;
	}

	
	
}
