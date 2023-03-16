//Vasiliki Katogianni A.M. 4696 Zoi Kouvaka A.M. 4706 Athanasios Katsilieris A.M. 3247
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
class KMeans
{
	public int M=9; //number of centers
	public int NUMOFDATA=1200;
	private double[][] readData=new double[NUMOFDATA][2];//all our Data
	private double[][] centers=new double[M][2]; //coords of all centers
	private double[][][] teams=new double[M][1200][2]; //each element is a cluster
	private int[] teamElementsNum=new int[M];//num of examples participating in each cluster
    private double error;
	public KMeans(int M)
	{
		this.M=M;
		for(int i=0;i<M;i++)
		{
			teamElementsNum[i]=0;
		}
		this.error=0;
	}

	public void findError()
	{
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<teamElementsNum[i];j++)
			{
				error+=findEuclideanDistance(centers[i],teams[i][j]); 
			}
		}	
	} 

	public void loadData()
	{
		BufferedReader reader =null;
		try
		{
			reader = new BufferedReader(new FileReader("data1.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
		try
		{
			String line = reader.readLine();
			int counter=0;
			while (line != null) 
			{
				String[] split = line.split(",");
				double x = Double.parseDouble(split[0]);
				double y = Double.parseDouble(split[1]);
				readData[counter][0]=x;
				readData[counter][1]=y; 
				line = reader.readLine(); // read next line
				if(counter<1199)
				{
					counter++;
				}
			}
			reader.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
	}
	public void initializeCenters()
	{
		int chosenCenterPos=0;
		Random randReader=new Random();
		for(int i=0;i<M;i++)
		{
			chosenCenterPos=randReader.nextInt(1200);
			centers[i]=readData[chosenCenterPos]; 
		}
	}

	public double findEuclideanDistance(double[] center,double example[])
	{
		double x1Dis=(center[0]-example[0])*(center[0]-example[0]);
		double x2Dis=(center[1]-example[1])*(center[1]-example[1]);
		return Math.sqrt(x1Dis+x2Dis);
	}

	public void addToTeam(double example[])
	{
		double minDis=findEuclideanDistance(centers[0],example);
		int minPos=0;//the cluster it will be added to 
		double thisDis=0;
		for (int i=1;i<M;i++)
		{
			thisDis=findEuclideanDistance(centers[i],example);
			if (minDis>thisDis)
			{
				minDis=thisDis;
				minPos=i;
			}
		}
		teams[minPos][teamElementsNum[minPos]]=example;//put the example in the right cluster
		teamElementsNum[minPos]++; //this cluster has one more member now
	}

	public void findNewCenters()
	{
		double newX1=0;
		double newX2=0;
		double sum1=0;
		double sum2=0;
		for(int i=0;i<M;i++)
		{
			sum1=0;
			sum2=0;
			for(int j=0;j<teamElementsNum[i];j++)
			{
				sum1+=teams[i][j][0]; 
				sum2+=teams[i][j][1];
			}
			double[] newCenter=new double[2];
			if(teamElementsNum[i]!=0)
			{
				newX1=sum1/teamElementsNum[i]; //find the means x1 of the cluster participants
				newX2=sum2/teamElementsNum[i]; //find the means x2 of the cluster participants
				newCenter[0]=newX1;
				newCenter[1]=newX2;
			}
			else 
			{
				newCenter[0]=centers[i][0];
				newCenter[1]=centers[i][1];
			}
			centers[i]=newCenter;
		}
	}

	public double[][] getReadData()
	{
		return readData;
	}

	public double[][] getCenters()
	{
		return centers;
	}
    public double getError()
	{
		return error;
	}
	public int[] getTeamElementsNum()
	{
		return teamElementsNum;
	}

	public double[][][] getTeams()
	{
		return teams;
	}

	public static void main(String[] args) {
		
		int M=9;
		int NUMOFDATA=1200;
		int iter;
		double minerror = 999999999;
		double tmperr;
		double [][] minCenter = new double [M][2];
		KMeans finalKM=new KMeans(M);
		for(iter = 0;iter < 15;iter++){
			KMeans km=new KMeans(M);
			km.loadData();
			km.initializeCenters();
			double[][] oldCenters=new double[M][2];
			double[][] newCenters=new double[M][2];
			boolean centerIsTheSame=false;
			while(!centerIsTheSame)
			{
				centerIsTheSame=true;
				for(int i=0;i<M;i++)
				{
					km.getTeamElementsNum()[i]=0;
				}
				for(int i=0;i<NUMOFDATA;i++)
				{
					km.addToTeam(km.getReadData()[i]);
				}
				for(int i=0;i<M;i++)
				{
					oldCenters[i][0]=km.getCenters()[i][0];
					oldCenters[i][1]=km.getCenters()[i][1];
				}
				km.findNewCenters();
				newCenters=km.getCenters();
				for(int i=0;i<M;i++)
				{
					if(oldCenters[i][0]!=newCenters[i][0] || oldCenters[i][1]!=newCenters[i][1])
					{
						centerIsTheSame=false;
						break;
					}
				}
			}
			km.findError();
			tmperr = km.getError();
			if (tmperr < minerror){
				minerror = tmperr;
				minCenter = newCenters;
				finalKM=km;
			}
		}
		for(int i=0;i<M;i++)
		{
			System.out.println(finalKM.getCenters()[i][0]+","+finalKM.getCenters()[i][1]+","+"100");//100 is for centers
			for(int j=0;j<finalKM.getTeamElementsNum()[i];j++)
			{
				System.out.println(finalKM.getTeams()[i][j][0]+","+finalKM.getTeams()[i][j][1]+","+i); // i is for each team
			}
		}
		System.out.println("\n\n\nMinimum error is: "+ minerror);
	}
}