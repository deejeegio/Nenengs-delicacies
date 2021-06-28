
public class Prices {
	
	public final double Puto = 5.00;
	public final double Kutsinta = 4.00;
	public final double bananaCake = 100.00;
	public final double Suman = 10.00;
	public final double carrotCake = 10.00;
	public final double Macaroons = 4.00;
	public final double chocoCake = 300.00;
	
	public double puto ()
	{
		return Puto;
	}
	
	public double kutsinta ()
	{
		return Kutsinta;
	}
	
	public double bCake ()
	{
		return bananaCake;
	}
	
	public double suman ()
	{
		return Suman;
	}
	
	public double cCake ()
	{
		return carrotCake;
	}
	
	public double macaroons ()
	{
		return Macaroons;
	}
	
	public double choCake ()
	{
		return chocoCake;
	}
	
	
	public double putoAdd (Double amt) 
	{
		return Puto * amt;
	}
	
	public double kutsintaAdd(Double amt)
	{	
		return Kutsinta * amt;
	}
	
	public double bcakeAdd(Double amt)
	{
		return bananaCake * amt;
	}
	
	public double sumanAdd(Double amt)
	{	
		return Suman * amt;
	}
	
	public double carCakeAdd (Double amt)
	{
		return carrotCake * amt;
	}
	
	public double cCakeAdd(Double amt)
	{
		return chocoCake * amt;
	}
	
	public double macaroonsAdd(Double amt)
	{
		return Macaroons * amt;
	}
	
}
