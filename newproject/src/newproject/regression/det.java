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
public class det 
{
    
     public double determinant1(double a[][], int n)
    {
	double det = 0, sign = 1;
        int p = 0, q = 0;

	if(n==1){
		det = a[0][0];
	}
	else{
		double b[][] = new double[n-1][n-1];
		for(int x = 0 ; x < n ; x++){
			p=0;q=0;
			for(int i = 1;i < n; i++){
				for(int j = 0; j < n;j++){
					if(j != x){
						b[p][q++] = a[i][j];
						if(q % (n-1) == 0){
							p++;
							q=0;
						}
					}
				}
			}
			det = det + a[0][x] *
                              determinant1(b, n-1) *
                              sign;
			sign = -sign;
		}
	}
	return det;
}
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
        double f;
        f=x1.determinant1(a,c);
        System.out.println(f);
    }
    
    
}
