
import newproject.regression.newproject2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAHE
 */
public class determinant {
    
    public int determinant1(int a[][], int n)
    {
	int det = 0, sign = 1, p = 0, q = 0;

	if(n==1){
		det = a[0][0];
	}
	else{
		int b[][] = new int[n-1][n-1];
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
       
    }
}
