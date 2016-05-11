import java.util.*;
public class TestClass 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		Matrix m = new Matrix(createMatrix(s));
		System.out.println("Starting matrix:");
		System.out.println(m.toString());
		while(true)
		{
			System.out.print("Command: ");
			String command = s.next();
			command.trim().toLowerCase();
			if(command.contains("change")) 
			{
				m.setMat(createMatrix(s));
				System.out.println("New matrix:");
				System.out.println(m.toString());
			}
			if(command.contains("print")) System.out.println(m.toString());
			if(command.contains("element"))
			{
				System.out.print("Element row: ");
				int a = s.nextInt();
				System.out.print("Element column: ");
				int b = s.nextInt();
				System.out.println(m.element(a, b));
			}
			if(command.contains("switch"))
			{
				System.out.println("R1 <-> R2");
				System.out.print("R1: ");
				int a = s.nextInt();
				System.out.print("R2: ");
				int b = s.nextInt();
				m.rowSwitch(a, b);
				System.out.println("New matrix:");
				System.out.println(m.toString());
			}
			if(command.contains("multiply"))
			{
				System.out.print("Row: ");
				int row = s.nextInt();
				System.out.print("Scalar: ");
				double scalar = s.nextDouble();
				m.scaleRow(row, scalar);
				System.out.println("New matrix:");
				System.out.println(m.toString());
			}
			if(command.contains("add"))
			{
				System.out.println("R1 + kR2 -> R1");
				System.out.print("R1: ");
				int row1 = s.nextInt();
				System.out.print("k: ");
				double scalar = s.nextDouble();
				System.out.print("R2: ");
				int row2 = s.nextInt();
				m.addRowMultiple(row1, row2, scalar);
				System.out.println("New matrix:");
				System.out.println(m.toString());
			}
			if(command.contains("lead"))
			{
				System.out.print("Row: ");
				int row = s.nextInt();
				System.out.println(m.hasLeadOne(row));
			}
			if(command.contains("zero"))
			{
				System.out.print("Row: ");
				int row = s.nextInt();
				System.out.println(m.isZeroRow(row));
			}
			if(command.contains("is") && command.contains("rref"))
			{
				System.out.println(m.isRref());
			}
			if(command.contains("rref"))
			{
				m.rref();
				System.out.println("New matrix:");
				System.out.println(m.toString());
			}
			if(command.equals("exit") || command.equals("close"))
			{
				break;
			}
		}
		s.close();		
	}
	
	public static double[][] createMatrix(Scanner s)
	{
		System.out.print("Rows: ");
		int rows = s.nextInt();
		System.out.print("Columns: ");
		int cols = s.nextInt();
		double[][] b = new double[rows][cols];
		for (int i = 0; i < rows; i++)
		{
			double a[] = new double[cols];
			System.out.print("Row " + (i + 1) + ": ");
			for(int j = 0; j < a.length; j++)
			{
				a[j] = s.nextDouble();
			}
			b[i] = a;
		}
		return b;
	}

}
