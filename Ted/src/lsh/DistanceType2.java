package lsh;

public class DistanceType2 {

	double distance;
	
	boolean[] vector;
	
	int id_property;
	
	public void DistanceType(){
		
	}
	
	public void setDistance(double distance)
	{
		this.distance = distance;
	}
	
	public double getDistance()
	{
		return this.distance;
	}
	
	public void setVector(boolean[] vector)
	{
		this.vector = vector;
	}
	
	public boolean[] getVector()
	{
		return this.vector;
	}
	
	public void setId(int id_property)
	{
		this.id_property = id_property;
	}
	
	public int getId()
	{
		return this.id_property;
	}

}
