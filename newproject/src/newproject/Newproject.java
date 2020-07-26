/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newproject;

/**
 *
 * @author MAHE
 */

//package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import jxl.*;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Newproject {

    private String inputFile;
    ArrayList<Double> netarea2=new ArrayList<>(644);
    ArrayList<Double> arr=new ArrayList<>(9660);
     double netarea[]=new double[644];
     int k1;
    double Density_Population[]=new double [644];
    int k2;
    double sc[]=new double [644];
    int k3;
    double st[]=new double [644];
     int k4;
    double urban[]=new double [644];
    int k5;
    double education_level[]=new double [644];
    int k6;
    double overall_literacy[]=new double [644];
    int k7;
    double female_literacy[]=new double [644];
    int k8;
    double sex_ratio[]=new double [644];
    int k9;
    double total_no_of_schools[]=new double [644];
    int k10;
    double imr[]=new double [644];
    int k11;
    double life_expectancy[]=new double [644];
    int k12;
    double villages[]=new double [644];
    int k13;
    double persons[]=new double [644];
    int k14;
    double males[]=new double [644];
    int k15;
    double females[]=new double [644];
    int k16;
    int flag[]=new int[17];
    Newproject()
     {
      k1=k2=k3=k4=k5=k6=k7=k8=k9=k10=k11=k12=k13=k14=k15=k16=0;
      for(int i=0;i<17;i++)
          flag[i]=0;
     }                                                                             
    
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
                        if(s.equals("infant"))
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
                

                    if (type == CellType.NUMBER) {
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
                
                
                
                
                 case "infant":
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
        
        public double[][] convertarrto2d()
        {
            double a[][]=new double[644][15];
            int r=0;int c=0;
            for(int i=0;i<arr.size();i++)
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
        Newproject test = new Newproject();
        test.setInputFile("E:\\districts2.xls");
        test.read();
        test.addd("Females");
        System.out.println(test.arr);
        
        double a[][]=new double[644][15];
            int r=0;int c=0;
            for(int i=0;i<test.arr.size();i++)
            {
              if(test.arr.get(i)!=-9999.0)
              {
                a[r][c]=test.arr.get(i);
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
        
    }

}
