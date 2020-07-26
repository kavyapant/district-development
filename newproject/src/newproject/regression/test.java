/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newproject.regression;

/**
 *
 * @author MAHE
 */
import java.io.IOException;
import matrix.Matrix;
import matrix.MatrixMathematics;
import matrix.NoSquareException;
public class test 
{
    private Matrix X;
	final private Matrix Y;
	final private boolean bias;
        public  test(final Matrix x, final Matrix y) {
		this(x,y,true);
	}
	
	public test(final Matrix x, final Matrix y, final boolean bias) {
		super();
		this.X = x;
		this.Y = y;
		this.bias = bias;
	}
        public Matrix calculate() throws NoSquareException {
		if (bias)
			this.X = X.insertColumnWithValue1();
		checkDiemnsion();
		final Matrix Xtr = MatrixMathematics.transpose(X); //X'
		final Matrix XXtr = MatrixMathematics.multiply(Xtr,X); //XX'
		final Matrix inverse_of_XXtr = MatrixMathematics.inverse(XXtr); //(XX')^-1
		if (inverse_of_XXtr == null) {
			System.out.println("Matrix X'X does not have any inverse. So MLR failed to create the model for these data.");
			return null;
		}
		final Matrix XtrY = MatrixMathematics.multiply(Xtr,Y); //X'Y
		return MatrixMathematics.multiply(inverse_of_XXtr,XtrY); //(XX')^-1 X'Y
	}

	/**
	 * Preconditions checks
	 */
	void checkDiemnsion() {
		if (X == null) 
			throw new NullPointerException("X matrix cannot be null.");
		if (Y == null) 
			throw new NullPointerException("Y matrix cannot be null.");
		
		if (X.getNcols() > X.getNrows()) {
			throw new IllegalArgumentException("The number of columns in X matrix (descriptors) cannot be more than the number of rows");
		}
		if (X.getNrows() != Y.getNrows()) {
			throw new IllegalArgumentException("The number of rows in X matrix should be the same as the number of rows in Y matrix. ");
		}
	}
              public static void main(String args[]) throws NoSquareException, IOException
        {
            
               Matrix X = new Matrix(new double[][]
            {
                
            
                {4,0,1},
                {7,1,1},
                {6,1,0},
                {2,0,0},
                {3,0,1}
            }
            );
            Matrix Y = new Matrix(new double[][]
            {
                {27},
                {29},
                {23},
                {20},
                {21}
            }
            );
           test ml = new test(X, Y);
           int k=0;
           Matrix b=ml.calculate();
           //int a[]=new int[100];
           double o[][]=new double[b.getNrows()][b.getNcols()];
           o=b.getValues();
           
           double a[]=new double[100];
           for(int i=0;i<b.getNrows();i++)
            {
           //     for(int j=0;j<beta.getNcols();j++)
             //   {
                    a[k++]=o[i][0];
            
               // }
            }
            for(int i=0;i<k;i++)
                System.out.println(a[i]);
}
}
