//Vasiliki Katogianni A.M. 4696 Zoi Kouvaka A.M. 4706 Athanasios Katsilieris A.M. 3247
import java.util.Random;
class generateData1
{
	
	public static void main(String[] args) {
		Random rand=new Random();
		double x1;
		double x2;
		double x3;
		double x4;
		double x5;
		double x6;
		double x7;
		double x8;
		double x9;
		double x10;
		double x11;
		double x12;
		double x13;
		double x14;
		double x15;
		double x16;
		double x17;
		double x18;
		double x19;
		double x20;
		for(int i=0;i<150;i++) //[0.8,1.2]x[0.8,1.2]
		{
			x1=rand.nextDouble()*(0.4)+0.8;
			x2=rand.nextDouble()*(0.4)+0.8;	
			System.out.println(""+x1+","+x2+","); 
		}
		for(int i=0;i<150;i++) // [0,0.5]x[0,0.5]
		{
			x3=rand.nextDouble()*(0.5);
			x4=rand.nextDouble()*(0.5);
			System.out.println(""+x3+","+x4+","); 
		}
		for(int i=0;i<150;i++) // [0,0.5] x [1.5,2]
		{
			x5=rand.nextDouble()*(0.5);
			x6=rand.nextDouble()*(0.5)+1.5;	
			System.out.println(""+x5+","+x6+","); 
		}
		for(int i=0;i<150;i++) // [1.5,2]x[0,0.5]
		{
			x7=rand.nextDouble()*(0.5)+1.5;	
			x8=rand.nextDouble()*(0.5);
			System.out.println(""+x7+","+x8+","); 
		}
		for(int i=0;i<150;i++) // [1.5,2] x [1.5,2]
		{
			x9=rand.nextDouble()*(0.5)+1.5;	
			x10=rand.nextDouble()*(0.5)+1.5;
			System.out.println(""+x9+","+x10+","); 
		}
		for(int i=0;i<75;i++) //[0.8, 1.2]x[0,0.4]
		{
			x11=rand.nextDouble()*(0.4)+0.8;	
			x12=rand.nextDouble()*(0.4);
			System.out.println(""+x11+","+x12+","); 
		}
		for(int i=0;i<75;i++) // [0.8, 1.2] x [1.6,2]
		{
			x13=rand.nextDouble()*(0.4)+0.8;	
			x14=rand.nextDouble()*(0.4)+1.6;
			System.out.println(""+x13+","+x14+","); 
		}
		for(int i=0;i<75;i++) // [0.3,0.7]x[0.8,1.2]
		{
			x15=rand.nextDouble()*(0.4)+0.3;	
			x16=rand.nextDouble()*(0.4)+0.8;
			System.out.println(""+x15+","+x16+","); 
		}
		for(int i=0;i<75;i++) // [1.3,1.7] x [0.8,1.2]
		{
			x17=rand.nextDouble()*(0.4)+1.3;	
			x18=rand.nextDouble()*(0.4)+0.8;
			System.out.println(""+x17+","+x18+","); 
		}
		for(int i=0;i<150;i++) //[0,2]x[0,2]
		{
			x19=rand.nextDouble()*(2.0);	
			x20=rand.nextDouble()*(2.0);
			System.out.println(""+x19+","+x20+","); 
		}
	}
}