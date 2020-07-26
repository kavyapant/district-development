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
public class det2 
{
    static int count=1;
    double m[][];
public double determinant(double A[][],int N)
{


double det=0;
double res;
//System.out.println("a[0][0]="+A[0][0]);

if(N == 1)
res = A[0][0];

else if (N == 2)
{
res = A[0][0]*A[1][1] - A[1][0]*A[0][1];
}

else
{
res=0;
for(int j1=0;j1<N;j1++)
{
m = new double[N-1][];
 for(int k=0;k<(N-1);k++)
   m[k] = new double[N-1];
for(int i=1;i<N;i++)
{
int j2=0;
for(int j=0;j<N;j++)
{
  if(j == j1)
   continue;
  m[i-1][j2] = A[i][j];
  j2++;
}
}
//int count=0;
//System.out.println("count="+count++);
 res += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinant(m,N-1);


}
}


return res;

}
/*
public static void main(String args[])
    {
        newproject2 x=new newproject2();
        det x1=new det();
        x.addd("Females");
        double a[][]=new double[644][15];
            int r=0;int c=0;
            for(int i=0;i<x.arr.size();i++)
            {
              if(x.arr.get(i)!=-9999.0)
              {
                a[r][c]=x.arr.get(i);
                r++;
              }
              else
              {
                  c++;
              }
             
            }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
        {
            System.out.println("i="+i+" "+"j="+j+" "+a[i][j]+" ");
        }
            System.out.println();
        }
        double xx[][]=new double[r][c];
        double y;
        det2 f=new det2();
       y= f.determinant(a, c);
       System.out.println(y);
}
*/
}
