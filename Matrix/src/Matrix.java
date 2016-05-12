public class Matrix 
{
	private double[][] mat;
	
	public Matrix(double[][] a)
	{
		mat = a;
	}
	
	public String toString()
	{
		String s = "";
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[i].length; j++)
			{
				s += mat[i][j] + " ";
			}
			if (i < mat.length) s += "\n";
		}
		return s;
	}
	
	public double element(int a, int b)
	{
		return mat[a - 1][b - 1];
	}
	
	public double[][] rowSwitch (int row1, int row2)
	{
		double[] a = mat[row1 - 1];
		double[] b = mat[row2 - 1];
		double[][] newMat = mat;
		newMat[row1 - 1] = b;
		newMat[row2 - 1] = a;
		return newMat;
	}
	
	public void setMat(double[][] newMat)
	{
		mat = newMat;
	}
	
	public void scaleRow (int row, double scalar)
	{
		for (int i = 0; i < mat[row - 1].length; i++) mat[row - 1][i] = mat[row - 1][i] * scalar;
	}
	
	public void addRowMultiple (int row1, int row2, double scalar)
	{
		for (int i = 0; i < mat[row1 - 1].length; i++)
		{
			mat[row1 - 1][i] += mat[row2 - 1][i] * scalar;
		}
	}
	
	public boolean hasLeadOne(int row)
	{
		Boolean test1 = false;
		int leadOneIndex = 0;
		for(int i = 0; i < mat[row - 1].length; i++)
		{
			if (mat[row - 1][i] == 1)
			{
				test1 = true;
				break;
			}
			else leadOneIndex++;
		}
		if(!test1) return false;
		for(int i = 0; i < mat.length; i++)
		{
			if(i != row - 1 && mat[i][leadOneIndex] != 0) return false;
		}
		if (leadOneIndex == 0) return true;
		else for (int i = 0; i < leadOneIndex; i++)
		{
			if (mat[row - 1][i] != 0) return false;
		}
		return true;
	}
	
	public boolean isZeroRow(int row)
	{
		for (int i = 0; i < mat[row - 1].length; i++)
		{
			if (mat[row - 1][i] != 0) return false;
		}
		return true;
	}
	
	public boolean isRref()
	{
		for(int i = 1; i <= mat.length; i++)
		{
			if(!(isZeroRow(i) || hasLeadOne(i))) return false;
		}
		return true;
	}
	
	public int firstNonZero(int row)
	{
		int nonZeroIndex = 0;
		for (int i = 0; i < mat[row].length; i++)
		{
			if(mat[row][i] == 0) nonZeroIndex++;
			else break;
		}
		return nonZeroIndex;
	}
	
	public void rref()
	{
		for(int i = 0; i < mat.length; i++)
		{
			if (!(isZeroRow(i + 1) || hasLeadOne(i + 1)))
			{
				scaleRow(i + 1, 1.0 / mat[i][firstNonZero(i)]);
				for (int j = 0; j < mat.length; j++)
				{
					if (j != i) addRowMultiple(j + 1, i + 1, -mat[j][firstNonZero(i)]);
				}
			}
		}
	}
	
	public void matMult(Matrix m)
	{
		
	}
}
