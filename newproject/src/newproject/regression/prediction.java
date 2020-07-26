package newproject.regression;
import java.io.IOException;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAHE
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAHE
 */
import java.util.Arrays;
import matrix.Matrix;
import matrix.NoSquareException;
import newproject.regression.MultiLinear;
import newproject.regression.newproject2;
public class prediction 
{
  
   private final double thetaVector[];
   double pr[]=new double[644];
double res[]=new double[644];
double mean;
double ssr;
double sse;
    prediction(double[] thetaVector) 
    {
      //this.rt = new rt[];
      this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length);
      
      //pr[i]=0.0;
   }
    
   
    
   public double apply(Double[] featureVector) {
      // for computational reasons the first element has to be 1.0
      assert featureVector[0] == 1.0;

      // simple, sequential implementation
      double prediction = 0;
      for (int j = 0; j < thetaVector.length; j++) {
          System.out.print(" "+thetaVector[j]+"*x"+featureVector[j]+"     ");
         prediction += thetaVector[j] * featureVector[j];
      }
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      
      return prediction;
   }

   public double[] getThetas()
   {
      return Arrays.copyOf(thetaVector, thetaVector.length);
   }
   
   public void residuals(double a[])
   {
       for(int i=0;i<644;i++)
       res[i]=a[i]-pr[i];
       int sum=0;
       for(int i=0;i<644;i++)
       sum+=res[i];//=a[i]-pr[i];
       System.out.println(sum+"sss");
   }
   
   public double meancal(double a[])
   {
       double sum=0;
       for(int i=0;i<a.length;i++)
           sum=sum+a[i];
       mean=sum/a.length;
       return mean;
    }
   
   public void getssr()
   {
       ssr=0;
    for(int i=0;i<644;i++)
           ssr=ssr+Math.pow(pr[i]-mean,2);
    //return ssr;
   }
   
   public void getsse(double a[])
   {
       sse=0;
    for(int i=0;i<644;i++)
           sse=sse+(a[i]-pr[i]);
    //return void;
   }
   
   public static void main(String args[]) throws NoSquareException, IOException
   {
       newproject2 x=new newproject2(644,2,644,1);
       x.setInputFile("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\data.xls");
        x.read();
       
       x.addd("Net irrigated area(Hectares)");
        x.addd("Percentage SC Population");
       x.addd2("Percentage ST Population");
       int r=0,c=0;
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
            Matrix X = new Matrix(x.a);
            Matrix Y = new Matrix(x.a2);
            MultiLinear ml=new MultiLinear(X,Y);
             Matrix beta = ml.calculate();
             int k=0;
           double a[]=new double[beta.getNrows()];
           double o[][]=new double[beta.getNrows()][beta.getNcols()];
            o=beta.getValues();
           for(int i=0;i<beta.getNrows();i++)
           {
             a[k++]=o[i][0];//beta values
           System.out.println(a[i]+" ");
           }/*
           for(int i=0;i<a.length-1;i++)
           {
             a[i]=a[i+1];//dec size
           System.out.println(a[i]+" ");
           }*/
            
             
 double[] thetaVector = new double[3];
 for(int i=0;i<thetaVector.length;i++)
     thetaVector[i]=0;
 thetaVector=a;
prediction targetFunction = new prediction(thetaVector);

// create the feature vector function with x0=1 (for computational reasons) and x1=house-size
//for(int i=0;i<644;i++)

Double[] featureVector = new Double[3];
for(int i=0;i<featureVector.length;i++)
featureVector[i]=0.0;
featureVector[0]=1.0;
for(int i=0;i<644;i++)
{
featureVector[1]=x.netarea[i];
featureVector[2]=x.st[i];
double predictedPrice = targetFunction.apply(featureVector);
targetFunction.pr[i]=predictedPrice;
System.out.println((i+1)+"  observed val="+x.sc[i]+"     Predicted value="+predictedPrice);
//System.out.println(pr[i]);
}   
// make the prediction
//double predictedPrice = targetFunction.apply(featureVector);
//System.out.println(predictedPrice+"tt");
targetFunction.residuals(x.sc);
for(int i=0;i<644;i++)
{
System.out.println((i+1)+"  residual="+targetFunction.res[i]+"     Predicted value="+targetFunction.pr[i]);
}

targetFunction.getsse(x.sc);
targetFunction.getssr();
System.out.println("sse="+targetFunction.sse+"ssr="+targetFunction.ssr);
double r22=targetFunction.sse/(targetFunction.sse+targetFunction.ssr);
System.out.println("sse="+targetFunction.sse+"ssr="+targetFunction.ssr+"r2="+r22);
   }    
}

