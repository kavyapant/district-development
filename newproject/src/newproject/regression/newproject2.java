/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newproject.regression;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

/**
 *
 * @author MAHE
 */
public class newproject2 {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MAHE
 */

//package reader;


   public  String inputFile;
    public   ArrayList<Double> netarea2=new ArrayList<>(644);
    public   ArrayList<Double> arr=new ArrayList<>(9660);
    public    ArrayList<Double> arr2=new ArrayList<>(9660);
   public    double a[][];
   public    double a2[][];
    public   double corx[]=new double[644];
     public  double cory[]=new double[644];
   public     double netarea[]=new double[644];
       int k1;
    public   double Density_Population[]=new double [644];
       int k2;
    public   double sc[]=new double [644];
    int k3;
     public  double st[]=new double [644];
     int k4;
     public  double urban[]=new double [644];
    int k5;
     public  double education_level[]=new double [644];
    int k6;
    public   double overall_literacy[]=new double [644];
    int k7;
    public   double female_literacy[]=new double [644];
    int k8;
    public   double sex_ratio[]=new double [644];
    int k9;
    public   double total_no_of_schools[]=new double [644];
    int k10;
   public    double imr[]=new double [644];
    int k11;
   public    double life_expectancy[]=new double [644];
    int k12;
    public   double villages[]=new double [644];
    int k13;
    public   double persons[]=new double [644];
    int k14;
   public    double males[]=new double [644];
    int k15;
   public    double females[]=new double [644];
    int k16;
   public    int flag[]=new int[17];
   public    newproject2(int r,int c,int r2,int c2)
     {
      k1=k2=k3=k4=k5=k6=k7=k8=k9=k10=k11=k12=k13=k14=k15=k16=0;
      for(int i=0;i<17;i++)
          flag[i]=0;
       a=new double[r][c];
         a2=new double[r2][c2];
         
      
     }  
    /*
    newproject2(int r,int c,int r2,int c2)
     {
         a=new double[r][c];
         a2=new double[r2][c2];
     }
    */
    public void setInputFile(String inputFile)
    {
        this.inputFile = inputFile;
    }
    public void display(double a[])
    {
        for(int i=0;i<644;i++)
            System.out.print(a[i]+" ");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
    }

    public void read() throws IOException,NullPointerException
    {
        File inputWorkbook = new File(inputFile);
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
                        String s=cell.getContents();
                      //  System.out.println("     s="+s);
                       // if(s.equals(""))
                         //   flag[0]=1;
                        if(s.equals("Net irrigated area(Hectares)"))
                        {
                            flag[1]=1;
                           // System.out.println("s="+s);
                            //System.out.println(flag[1]);
                        }
                            
                            
                        if(s.equals("Density Population(persons per sq.km.)"))
                            flag[2]=1;
                        if(s.equals("Percentage SC Population"))
                            flag[3]=1;
                        if(s.equals("Percentage ST Population"))
                            flag[4]=1;
                        if(s.equals("Percentage Urban Population"))
                            flag[5]=1;
                        if(s.equals("Education level"))
                            flag[6]=1;
                        if(s.equals("Overall Literacy"))
                            flag[7]=1;
                        if(s.equals("Female Literacy"))
                            flag[8]=1;
                        if(s.equals("Sex ratio"))
                            flag[9]=1;
                        if(s.equals("Total Number of Schools"))
                            flag[10]=1;
                        if(s.equals("IMR(Infant Mortality Rate)"))
                        {
                            flag[11]=1;
                            //System.out.println("s="+s);
                            //System.out.println(flag[11]);
                        }
                         if(s.equals("Life expectancy at    Birth "))
                          flag[12]=1;
                        if(s.equals("Number of Villages"))
                            flag[13]=1;
                        if(s.equals("Persons"))
                            flag[14]=1;
                        if(s.equals("Males"))
                            flag[15]=1;
                        if(s.equals("Females"))
                            flag[16]=1;
                       // System.out.print("j="+j+"  i="+i+"    "+"s="+s+"  ");
                        
                       //for(int x=0;x<17;x++)
                        //{
                        //System.out.print(" "+flag[x]+" ");
                        //}
                    
                        
                    }
                /*
                    if(type==CellType.NUMBER_FORMULA)
                    {
                        double n=Double.parseDouble(cell.getContents());
                        System.out.println("********************************************************"+n);
                    }*/
                    if (type == CellType.NUMBER || type==CellType.NUMBER_FORMULA) {
                      ////  System.out.println("I got a number "
                          //    +cell.getContents());
                        double n=Double.parseDouble(cell.getContents());
                        //System.out.println("n=="+n);
                        if(flag[1]==1)
                        {
                         netarea[k1++]=n;
                         netarea2.add(n);
                        }
                         if(flag[2]==1)
                         Density_Population[k2++]=n;
                         
                          if(flag[3]==1)
                         sc[k3++]=n;
                          
                           if(flag[4]==1)
                         st[k4++]=n;
                           
                            if(flag[5]==1)
                         urban[k5++]=n;
                            
                         if(flag[6]==1)
                         education_level[k6++]=n;
                             
                         if(flag[7]==1)
                         overall_literacy[k7++]=n;
                              
                         if(flag[8]==1)
                         female_literacy[k8++]=n;
                               
                         if(flag[9]==1)
                         sex_ratio[k9++]=n;
                                
                         if(flag[10]==1)
                         total_no_of_schools[k10++]=n;
                        
                         if(flag[11]==1)
                         imr[k11++]=n;
                         
                          if(flag[12]==1)
                         life_expectancy[k12++]=n;
                          
                          if(flag[13]==1)
                         villages[k13++]=n;
                          
                           if(flag[14]==1)
                         persons[k14++]=n;
                           
                            if(flag[15]==1)
                         males[k15++]=n;
                            
                             if(flag[16]==1)
                         females[k16++]=n;
                             
                    }

                }
                
                for(int i=0;i<17;i++)
          flag[i]=0;
            }

        }
     catch (BiffException e) 
         {
            e.printStackTrace();
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        /*
        System.out.println(netarea2);
        display(netarea);
        display(Density_Population);
        display(sc);
        display(st);
        display(urban);
        display(education_level);
        display(overall_literacy);
        display(female_literacy);
        display(sex_ratio);
        display(total_no_of_schools);
        display(imr);
        display(life_expectancy);
        display(villages);
        display(persons);
        display(males);
        display(females);
        */
    }
        public void addd(String s)
        {
         switch(s)
        {
            case "Net irrigated area(Hectares)":
                for(int i=0;i<643;i++)
                    arr.add(netarea[i]);
                arr.add(-9999.0);
                break; 
                //Net irrigated area(Hectares) 
                
                case "Density Population(persons per sq.km.)":
                for(int i=0;i<643;i++)
                    arr.add(Density_Population[i]);
                arr.add(-9999.0);
                break;
                
                
                case "Percentage SC Population":
                for(int i=0;i<643;i++)
                    arr.add(sc[i]);
                arr.add(-9999.0);
                break;
                
                
                case "Percentage ST Population":
                for(int i=0;i<643;i++)
                    arr.add(st[i]);
                arr.add(-9999.0);
                break;
                
                
                case "Percentage Urban Population":
                for(int i=0;i<643;i++)
                    arr.add(urban[i]);
                arr.add(-9999.0);
                break;
                
                
                
                case "Education level":
                for(int i=0;i<643;i++)
                    arr.add(education_level[i]);
                arr.add(-9999.0);
                break;
                
                
                case "Overall Literacy":
                for(int i=0;i<643;i++)
                    arr.add(overall_literacy[i]);
                arr.add(-9999.0);
                break;
                
                
                case "Female Literacy":
                for(int i=0;i<643;i++)
                    arr.add(female_literacy[i]);
                arr.add(-9999.0);
                break;
                
                
                
                 case "Sex ratio":
                for(int i=0;i<643;i++)
                    arr.add(sex_ratio[i]);
                arr.add(-9999.0);
                break;
                
                
                
                 case "Total Number of Schools":
                for(int i=0;i<643;i++)
                    arr.add(total_no_of_schools[i]);
                arr.add(-9999.0);
                break;
                
                
                
                
                 case "IMR(Infant Mortality Rate)":
                for(int i=0;i<643;i++)
                    arr.add(imr[i]);
                arr.add(-9999.0);
                break;
                
                
                
                 case "Life expectancy at    Birth ":
                for(int i=0;i<643;i++)
                    arr.add(life_expectancy[i]);
                arr.add(-9999.0);
                break;
                
                
                
                 case "Number of Villages":
                for(int i=0;i<643;i++)
                    arr.add(villages[i]);
                arr.add(-9999.0);
                break;
                
                
                 case "Persons":
                for(int i=0;i<643;i++)
                    arr.add(persons[i]);
                arr.add(-9999.0);
                break;
                
                
                 case "Males":
                for(int i=0;i<643;i++)
                    arr.add(males[i]);
                arr.add(-9999.0);
                break;
                
                 case "Females":
                for(int i=0;i<643;i++)
                    arr.add(females[i]);
                arr.add(-9999.0);
                break;
                
                
                
                
        }
        
    }
        int rr=0,jj=0;
        public double cor(String s,String s2)
                
        {
            switch(s)
        {
            case "Net irrigated area(Hectares)":
                for(int i=0;i<643;i++)
                    corx[rr]=netarea[i];
               // arr2.add(-9999.0);
                break; 
                
                
                case "Density Population(persons per sq.km.)":
                for(int i=0;i<643;i++)
                  corx[rr]=  Density_Population[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Percentage SC Population":
                for(int i=0;i<643;i++)
                   corx[rr]= sc[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Percentage ST Population":
                for(int i=0;i<643;i++)
                   corx[rr]=st[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Percentage Urban Population":
                for(int i=0;i<643;i++)
                   corx[rr]=urban[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                case "Education level":
                for(int i=0;i<643;i++)
                   corx[rr]= education_level[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Overall Literacy":
                for(int i=0;i<643;i++)
                    corx[rr]=overall_literacy[i];
              //  arr2.add(-9999.0);
                break;
                
                
                case "Female Literacy":
                for(int i=0;i<643;i++)
                   corx[rr]=female_literacy[i];
              //  arr2.add(-9999.0);
                break;
                
                
                
                 case "Sex ratio":
                for(int i=0;i<643;i++)
                    corx[rr]=sex_ratio[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                 case "Total Number of Schools":
                for(int i=0;i<643;i++)
                    corx[rr]=total_no_of_schools[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                
                 case "IMR(Infant Mortality Rate)":
                for(int i=0;i<643;i++)
                    corx[rr]=imr[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                 case "Life expectancy at    Birth ":
                for(int i=0;i<643;i++)
                   corx[rr]=life_expectancy[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                 case "Number of Villages":
                for(int i=0;i<643;i++)
                    corx[rr]=villages[i];
               // arr2.add(-9999.0);
                break;
                
                
                 case "Persons":
                for(int i=0;i<643;i++)
                    corx[rr]=persons[i];
               // arr2.add(-9999.0);
                break;
                
                
                 case "Males":
                for(int i=0;i<643;i++)
                    corx[rr]=males[i];
               // arr2.add(-9999.0);
                break;
                
                 case "Females":
                for(int i=0;i<643;i++)
                    corx[rr]=females[i];
                //arr2.add(-9999.0);
                break;
//                for(int i=0;i<644;i++)
                //    System.out.println(corx[i]);
                
              // return ; 
                
                
        }
            
            
            
            switch(s2)
            {
               // switch(s)
        //{
            case "Net irrigated area(Hectares)":
                for(int i=0;i<643;i++)
                    cory[jj]=netarea[i];
               // arr2.add(-9999.0);
                break; 
                
                
                case "Density Population(persons per sq.km.)":
                for(int i=0;i<643;i++)
                  cory[jj]=  Density_Population[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Percentage SC Population":
                for(int i=0;i<643;i++)
                   cory[jj]= sc[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Percentage ST Population":
                for(int i=0;i<643;i++)
                   cory[jj]=st[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Percentage Urban Population":
                for(int i=0;i<643;i++)
                   cory[jj]=urban[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                case "Education level":
                for(int i=0;i<643;i++)
                   cory[jj]= education_level[i];
               // arr2.add(-9999.0);
                break;
                
                
                case "Overall Literacy":
                for(int i=0;i<643;i++)
                    cory[jj]=overall_literacy[i];
              //  arr2.add(-9999.0);
                break;
                
                
                case "Female Literacy":
                for(int i=0;i<643;i++)
                   cory[jj]=female_literacy[i];
              //  arr2.add(-9999.0);
                break;
                
                
                
                 case "Sex ratio":
                for(int i=0;i<643;i++)
                    cory[jj]=sex_ratio[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                 case "Total Number of Schools":
                for(int i=0;i<643;i++)
                    cory[jj]=total_no_of_schools[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                
                 case "IMR(Infant Mortality Rate)":
                for(int i=0;i<643;i++)
                    cory[jj]=imr[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                 case "Life expectancy at    Birth ":
                for(int i=0;i<643;i++)
                   cory[jj]=life_expectancy[i];
               // arr2.add(-9999.0);
                break;
                
                
                
                 case "Number of Villages":
                for(int i=0;i<643;i++)
                    cory[jj]=villages[i];
               // arr2.add(-9999.0);
                break;
                
                
                 case "Persons":
                for(int i=0;i<643;i++)
                    cory[jj]=persons[i];
               // arr2.add(-9999.0);
                break;
                
                
                 case "Males":
                for(int i=0;i<643;i++)
                    cory[jj]=males[i];
               // arr2.add(-9999.0);
                break;
                
                 case "Females":
                for(int i=0;i<643;i++)
                    cory[jj]=females[i];
                //arr2.add-9999.0);
                break;
                
              // return ; 
                
                
            }
            PearsonsCorrelation p=new PearsonsCorrelation();
            for(int i=0;i<644;i++)
                    System.out.print(corx[i]+" ");
            for(int i=0;i<644;i++)
                    System.out.print(cory[i]+" ");
            double e=p.correlation(corx, cory);
            return e;
        }
         public void addd2(String s)
        {
         switch(s)
        {
            case "Net irrigated area(Hectares)":
                for(int i=0;i<643;i++)
                    arr2.add(netarea[i]);
                arr2.add(-9999.0);
                break; 
                
                
                case "Density Population(persons per sq.km.)":
                for(int i=0;i<643;i++)
                    arr2.add(Density_Population[i]);
                arr2.add(-9999.0);
                break;
                
                
                case "Percentage SC Population":
                for(int i=0;i<643;i++)
                    arr2.add(sc[i]);
                arr2.add(-9999.0);
                break;
                
                
                case "Percentage ST Population":
                for(int i=0;i<643;i++)
                    arr2.add(st[i]);
                arr2.add(-9999.0);
                break;
                
                
                case "Percentage Urban Population":
                for(int i=0;i<643;i++)
                    arr2.add(urban[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                case "Education level":
                for(int i=0;i<643;i++)
                    arr2.add(education_level[i]);
                arr2.add(-9999.0);
                break;
                
                
                case "Overall Literacy":
                for(int i=0;i<643;i++)
                    arr2.add(overall_literacy[i]);
                arr2.add(-9999.0);
                break;
                
                
                case "Female Literacy":
                for(int i=0;i<643;i++)
                    arr2.add(female_literacy[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                 case "Sex ratio":
                for(int i=0;i<643;i++)
                    arr2.add(sex_ratio[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                 case "Total Number of Schools":
                for(int i=0;i<643;i++)
                    arr2.add(total_no_of_schools[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                
                 case "imr":
                for(int i=0;i<643;i++)
                    arr2.add(imr[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                 case "Life expectancy at    Birth ":
                for(int i=0;i<643;i++)
                    arr2.add(life_expectancy[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                 case "Number of Villages":
                for(int i=0;i<643;i++)
                    arr2.add(villages[i]);
                arr2.add(-9999.0);
                break;
                
                
                 case "Persons":
                for(int i=0;i<643;i++)
                    arr2.add(persons[i]);
                arr2.add(-9999.0);
                break;
                
                
                 case "Males":
                for(int i=0;i<643;i++)
                    arr2.add(males[i]);
                arr2.add(-9999.0);
                break;
                
                 case "Females":
                for(int i=0;i<643;i++)
                    arr2.add(females[i]);
                arr2.add(-9999.0);
                break;
                
                
                
                
        }
        }
        
        public double[][] convertarrto2d()
        {
            double a[][]=new double[644][15];
            int r=0;int c=0;
            for(int i=0;i<643;i++)
            {
              if(arr.get(i)!=-9999.0)
              {
                a[r][c]=arr.get(i);
                r++;
              }
              else
              {
                  c++;
              }
             
            }
            return a;
        }
    
    
    

    public static void main(String[] args) throws IOException
    {
        newproject2 test = new newproject2(644,1,644,1);
        test.setInputFile("E:\\districts2.xls");
        test.read();
        
        test.addd("IMR(Infant Mortality Rate)");
         System.out.println(test.arr);
         /*
       // test.addd2("Overall Literacy");
        //System.out.println(test.arr);
        //System.out.println("arr2==="+test.arr2);
        
            int r=0;int c=0;
            
            for(int i=0;i<test.arr.size();i++)
            {
              if(test.arr.get(i)!=-9999.0)
              {
                   System.out.println("i="+i+" ");
                test.a[r][c]=test.arr.get(i);
                 System.out.println(test.a[r][c]+"  hdhdhd");
                r++;
              }
              else
              {
                    System.out.println("i="+i+" ");
                  c++;
                  r=0;
              }
             
            }
            
              System.out.println("gng");
                System.out.println("gng");
        for(int i=0;i<644;i++)
        {
            for(int j=0;j<c;j++)
        {
            System.out.println("i="+i+" "+"j="+j+" "+test.a[i][j]+" ");
        }
            System.out.println();
        }
        */
      
       // int r2=0;int c2=0;
        /*
            for(int i=0;i<test.arr2.size();i++)
            {
              if(test.arr2.get(i)!=-9999.0)
              {
                test.a2[r2][c2]=test.arr2.get(i);
                r2++;
                  System.out.println("r2="+r2+" "+"gng2");
              }
              else
              {
                  c2++;
              }
             
            }

        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
        {
            System.out.println("a2i="+i+" "+"j="+j+" "+test.a2[i][j]+" ");
        }
            System.out.println();
        }
        
       */ 
        
    }

}

