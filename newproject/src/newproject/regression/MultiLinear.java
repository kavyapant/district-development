package newproject.regression;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import matrix.IllegalDimensionException;
import matrix.Matrix;
import matrix.MatrixMathematics;
import matrix.NoSquareException;
import newproject.Newproject;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
//import linearregression.Linearregression;


public class MultiLinear {

	private Matrix X;
	final private Matrix Y;
	final private boolean bias;
        // private String inputFile;
	
	public MultiLinear(final Matrix x, final Matrix y) {
		this(x,y,true);
	}
	
	public MultiLinear(final Matrix x, final Matrix y, final boolean bias) {
		super();
		this.X = x;
		this.Y = y;
		this.bias = bias;
	}
	/**
	 * beta a matrix which gives the coefficients of a multi-linear regression equation Y = sum_of(beta_i * x_i) 
	 * beta = Inverse_of(X_transpose * X) * X_transpose * Y
	 * @return
	 * @throws NoSquareException
	 */
	public Matrix calculate() throws NoSquareException {
            
		if (bias)
                {
                    System.out.println("bias"+bias);
                
			this.X = X.insertColumnWithValue1();
                }
                
		checkDiemnsion();
               
		final Matrix Xtr = MatrixMathematics.transpose(X); //X'
                
                   double ooo[][]=new double[Xtr.getNrows()][Xtr.getNcols()];
                System.out.println("transpose matrix===");
                ooo=Xtr.getValues();
            for(int i=0;i<Xtr.getNrows();i++)
        {
            for(int j=0;j<Xtr.getNcols();j++)
        {
            System.out.print(ooo[i][j]+" ");
        }
          System.out.println();   
        }
		final Matrix XXtr = MatrixMathematics.multiply(Xtr,X); //XX'
                System.out.println("x'x=====");
               // System.out.println("multiply done");
                 double oo[][]=new double[XXtr.getNrows()][XXtr.getNcols()];
            oo=XXtr.getValues();
            for(int i=0;i<XXtr.getNrows();i++)
        {
            for(int j=0;j<XXtr.getNcols();j++)
        {
            System.out.print(oo[i][j]+" ");
        }
          System.out.println();   
        }

                
                
		final Matrix inverse_of_XXtr = MatrixMathematics.inverse(XXtr); //(XX')^-1
		System.out.println("inverse done");
                if (inverse_of_XXtr == null) {
                    System.out.println("came to if");
			System.out.println("Matrix X'X does not have any inverse. So MLR failed to create the model for these data.");
			return null;
		}
                System.out.println("came to end");
		final Matrix XtrY = MatrixMathematics.multiply(Xtr,Y); //X'Y
		return MatrixMathematics.multiply(inverse_of_XXtr,XtrY); //(XX')^-1 X'Y
	}

	/**
	 * Preconditions checks
	 */
	void checkDiemnsion() 
        {
            
            
		if (X == null) 
			throw new NullPointerException("X matrix cannot be null.");
		if (Y == null) 
			throw new NullPointerException("Y matrix cannot be null.");
		
		if (X.getNcols() > X.getNrows()) {
			throw new IllegalArgumentException("The number of columns in X matrix (descriptors) cannot be more than the number of rows");
		}
		if (X.getNrows() != Y.getNrows()) {
			throw new IllegalArgumentException("The number of rows in X matrix should be the same as the number of rows in Y matrix. ");
		}System.out.println("checked");
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        public double getVariance(Matrix X,Matrix Y,Matrix beta) throws IllegalDimensionException, NoSquareException {
if (beta == null) 
{
calculate();
}
final Matrix Ytr = MatrixMathematics.transpose(Y); //Y'
final Matrix YtrY = MatrixMathematics.multiply(Ytr, Y);
final Matrix Xtr = MatrixMathematics.transpose(X); //X'
final Matrix btr = MatrixMathematics.transpose(beta);
final Matrix btrXtr = MatrixMathematics.multiply(btr, Xtr);
final Matrix btrXY = MatrixMathematics.multiply(btrXtr, Y);
double v = YtrY.getValueAt(0, 0) - btrXY.getValueAt(0, 0);

return v;
}

public double getResiduals(Matrix Y) { 
final Matrix Ytr = MatrixMathematics.transpose(Y); //Y'
final Matrix YtrY = MatrixMathematics.multiply(Ytr, Y);
return YtrY.getValueAt(0, 0);
}

        
         public static void main(String args[]) throws NoSquareException, IOException, IllegalDimensionException, BiffException
        {
            newproject2 x=new newproject2(644,7,644,1);
                        

           x.setInputFile("E:\\districts2.xls");
        x.read();
        //x.addd("Net irrigated area(Hectares)");
       // x.addd("")
       
       //x.addd("Overall Literacy");
       
       x.addd("Density Population(persons per sq.km.)");
      x.addd("Percentage Urban Population");
      x.addd("Education level");
      x.addd("Female Literacy");     
      x.addd("infant");
      x.addd("Life expectancy at    Birth ");
        x.addd("Number of Villages");
          
       
       // x.addd("infant");
        
      //x.addd("Sex ratio");
        
      //x.addd2("Overall Literacy");
       // x.addd("infant");
      // x.addd("Total Number of Schools");
      // x.addd("Density Population(persons per sq.km.)");
       //x.addd("infant");
       x.addd2("Overall Literacy");
        //  */
        //double a1=x.cor("Net irrigated area(Hectares)", "Net irrigated area(Hectares)");
        //double a2=x.cor("Overall Literacy", "Net irrigated area(Hectares)");
        //double a3=x.cor("Total Number of Schools", "Sex ratio");
        
        System.out.println(x.arr);
        
        System.out.println("                           "+x.arr2);
        
        int r=0;int c=0;
             //System.out.println("one-d array size="+x.arr.size()+  "y size="+x.arr2.size());
             /*
             File inputWorkbook = new File(x.inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

            for (int j = 0; j < sheet.getColumns(); j++) 
            {
                for (int i = 0; i < sheet.getRows(); i++) 
                {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) 
                    {
                       
                         //System.out.println("I got a label     "
                           //     + cell.getContents());//+ cell.getContents());
                        String s=cell.getContents();}
                        if (type == CellType.NUMBER) {
                      ////  System.out.println("I got a number "
                          //    +cell.getContents());
                        double n=Double.parseDouble(cell.getContents());
*/
             
            for(int i=0;i<x.arr.size();i++)
            {
                     
              if(x.arr.get(i)!=-9999.0)
              {
                     //System.out.println("   for j="+j);
                x.a[r][c]=x.arr.get(i);
              //  System.out.println("%%%%%%arrrrrayyyylist"+x.arr.get(i));
             //  System.out.println("%%%%%%%for r="+(r+1)+"   "+x.a[r][c]);
                r++;
              }
              else
              {
                 //System.out.println("******"+x.arr.size()+"   "+i+"*******"+c+"     ^^^^^^^^^^^^^))))))))))))))))))))"+x.a[r][c]+"888888     "+x.arr.get(i));
                  c++;
                  r=0;
              }
             
            }
            //System.out.println("r="+r+"     "+c);
            /*
            int t=0;
            for(int i=0;i<r;i++)
            {
                  for(int j=0;j<c;j++)
                  {
                      if(x.a[i][j]!=x.arr.get(t))
                      {
                      //   System.out.println("array list value="+x.arr.get(t)+"array list t value= " +t);
                    //  System.out.println("array value="+x.a[i][j]+"  array indices i and j"+i+"  "+j);
                       System.out.println();
                       System.out.println();
                       System.out.println();
                       System.out.println();
                       System.out.println();
                      }
                  else
                  {
                      
                      System.out.println("i="+i+"  j="+j+" t="+t);
                          
                          }
                  t++;
                  }
                          }
            
            for(int i=0;i<x.arr.size();i++)
            {
                System.out.println((t+1)+"  value="+x.arr.get(i));
                t++;
                if(t==642)
                    t=0;
            }
            */
            //*/
            /*
            System.out.println("X matrix===");
        for(int i=0;i<r;i++)
        {
            //System.out.println("for i="+i);
            for(int j=0;j<c;j++)
        {
            // System.out.println("for j="+j);
            System.out.print(x.a[i][j]+" ");
        }
            System.out.println();
        }
        
        
        */
        
        
        
            int r2=0;int c2=0;
            
            for(int i=0;i<x.arr2.size();i++)
            {
              if(x.arr2.get(i)!=-9999.0)
              {
                x.a2[r2][c2]=x.arr2.get(i);
                r2++;
                
                //  System.out.println("r2="+r2+" "+"gng2");
              }
              else
              {
                  c2++;
              }
             
            }
            /*
            System.out.println("Y matrix===");
        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
        {
            System.out.print(x.a2[i][j]+" ");
        }
            System.out.println();
        }
        */
               Matrix X = new Matrix(x.a);
            Matrix Y = new Matrix(x.a2);
            double oo[][]=new double[X.getNrows()][X.getNcols()];
            MultiLinear ml = new MultiLinear(X, Y);
               double ooo[][]=new double[X.getNrows()][X.getNcols()];
               /*
               System.out.println("original matrix===");
                ooo=X.getValues();
            for(int i=0;i<X.getNrows();i++)
        {
            for(int j=0;j<X.getNcols();j++)
        {
            System.out.print(ooo[i][j]+" ");
        }
          System.out.println();   
        }/*
            double aa[]=new double[X.getNrows()];
             oo=X.getValues();
            int k=0,m=0;
            for(int i=0;i<X.getNrows();i++)
            {
           //     for(int j=0;j<beta.getNcols();j++)
             //   {
                    aa[m++]=oo[i][0];
            
               // }
            }
           //  for(int i=0;i<m;i++)
               // System.out.println(aa[i]+" x matrix");
*/
            int k=0,m=0;
             System.out.println("calculating");
            Matrix beta = ml.calculate();
            
          //  beta.(beta);
            double o[][]=new double[beta.getNrows()][beta.getNcols()];
          
         
          o=beta.getValues();
           double a[]=new double[beta.getNrows()];
             
           //double a[]=new double[X.getNrows()];
           
            for(int i=0;i<beta.getNrows();i++)
            {
           //     for(int j=0;j<beta.getNcols();j++)
             //   {
                    a[k++]=o[i][0];
            
               // }
            }
            double b;
            System.out.println("beta");
            for(int i=0;i<k;i++)
            {
                
                System.out.println(a[i]);
            }
            b=a[0];
            for(int i=0;i<644;i++)
                    System.out.print(x.corx[i]+" ");
            for(int i=0;i<644;i++)
                    System.out.print(x.cory[i]+" ");
            //System.out.println(a1);
            //System.out.println(a2);
           // System.out.println(a3);
          //  double er[][]=new double(
               //     {b}
                //    ); 
                double w[][]=new double[1][1];
                w[0][0]=a[0];
            Matrix bb=new Matrix(w);
          
          // double v=ml.getVariance(X, Y, bb);
            //double residuals=ml.getResiduals(Y);
            
             //double ssr= ml.getVariance();
//double residuals = ml.getResiduals();
            //double re2 = 1.0 - v/residuals;
           // System.out.println("r2="+re2+"variance="+v+ "resi="+residuals);
            //StdOut.println(beta);
           // PearsonsCorrelation p=new PearsonsCorrelation();
            
        }}
	

	

