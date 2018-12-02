/*
 * The MIT License
 *
 * Copyright 2015 Thibault Debatty.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package lsh;

import lsh.LSHSuperBit;
import lsh.DistanceType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thibault Debatty
 */
public class LSHSuperBitExample {

    /**
     * @param args the command line arguments
     */
    public static int[] reccomendation(int id_user) {
    	
    	int count = 35201;
        
        // R^n
        int n = 1593;
        double[][] vectors = new double[count][];
        for (int i = 0; i < count; i++) {
            vectors[i] = new double[n];}
        int []id = new int[count]; 
        int []id_property = new int[n];
        String csvFile1 = "C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/review/table_output2.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
       int i=0;
       int j;
       int []temp = new int[3];

        try {

            br = new BufferedReader(new FileReader(csvFile1));
            line = br.readLine();
            String[] data2 = line.split(cvsSplitBy);
            for(j=0;j<n;j++) id_property[j] = Integer.parseInt(data2[j]);
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                id[i] = Integer.parseInt(data[0]);
                for(j=1;j<n;j++)	vectors[i][j] = Double.parseDouble(data[j]);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
            
            
            int stages = 5;
            int buckets = 20;
                 
            //ArrayList<ArrayList<double[]>> listoflist = new ArrayList<ArrayList<double[]>>(buckets);
            ArrayList<double[]>[] listoflist = (ArrayList<double[]>[])new ArrayList[buckets];
            for(i=0;i<buckets;i++)
            {
            	listoflist[i] = new ArrayList<double[]>();
            }

            try {
            LSHSuperBit lsh = new LSHSuperBit(stages, buckets, n);
            
            // Compute a SuperBit signature, a LSH hash and insert vectors to Hashtable(listioflist)
            for (int ii = 0; ii < count; ii++) {
                double[] vector = vectors[ii];
                int[] hash = lsh.hash(vector);
              
                listoflist[hash[0]].add(vector);
               // System.out.print(id[ii]);
                //System.out.print("  ");
                //System.out.print(hash[0]);
               // System.out.print("\n");
            }
            
            
        
            
            int index = findVector(id,id_user);
            double[] vector = vectors[index];
            int[] hash = lsh.hash(vector); 
            DistanceType[] d = calculate_distances(listoflist[hash[0]],vector);
           
            DistanceType[] d1 = new DistanceType[20*1593];
            for(i=0;i<20*1593;i++)	d1[i] = new DistanceType();
            i=0;
            int counter=0, counter2=0;
            double[] v;
            while(counter != 20)
            {
            	//take distances that are not equal to 0
            	//distance equal to 0 means either the vector belongs to the same user or the vector belongs to user with the same reviews
            	if(d[i].getDistance() != 0) 
            	{
            		//System.out.println(d[i].getDistance());
            		v = d[i].getVector();
            		for(j=0;j<1593;j++)
            		{
            			if(v[j] != 0) {System.out.print(v[j]);System.out.print(" ");}
            			d1[counter2].setDistance(v[j]);
            			d1[counter2].setId(id_property[j]);
            			counter2++;
            		}
            		System.out.println("");
            		counter++;
            	}
            	i++;
            }
            quickSort(d1,0,20*1593-1);
            i=20*1593-1;
            counter=0;
            
            while(counter < 3)
            {
            	counter2=0;
            	for(j=0;j<counter;j++)
            	{
            		if(temp[j] != d1[i].getId()) counter2++;
            	}
            	if(counter2 == counter)
            	{
            		System.out.print("---");System.out.println(d1[i].getDistance());System.out.print("  ");System.out.println(d1[i].getId());
            		temp[counter] = d1[i].getId();
            		counter++;
            	}
            	i--;
            }
            
            System.out.println("\n");
           /*for(i=20*1593-21;i<20*1593;i++) 
           {
        	   System.out.print("---");System.out.println(d1[i].getDistance());System.out.print("  ");System.out.println(d1[i].getId());}
           */
        } catch (Exception ex) {
            Logger.getLogger(LSHSuperBitExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
    public  static DistanceType[] calculate_distances(ArrayList<double[]> bucket, double[] vector)
    {
    	DistanceType[] distances = new DistanceType[bucket.size()];
    	int i,j,count=0;
    	for(i=0;i<bucket.size();i++) distances[i] = new DistanceType();
    	double distance=0;
    	
    	for(i=0;i<bucket.size();i++)
    	{
    		double[] temp = bucket.get(i);
    		distance = 0;
    		for(j=0;j<1593;j++)
    		{
    			distance += (temp[j] - vector[j])*(temp[j] - vector[j]);
    		}
    		distance = Math.sqrt(distance);
    		distances[i].setDistance(distance);
    		distances[i].setVector(temp);
    	}
    	
    	quickSort(distances,0,bucket.size()-1);
    	return distances;
    }
    
    public static int findVector(int[] table,int id)
    {
    	double[] vector;
    	int i;
    	for(i=0;i<35201;i++)
    	{
    		if(table[i] == id) break;
    	}
    	return i;
    }
    
    public static int partition(DistanceType[] arr, int left, int right)
    {
          int i = left, j = right;
          DistanceType tmp;
          double pivot = arr[(left + right) / 2].getDistance();
         
          while (i <= j) {
                while (arr[i].getDistance() < pivot)
                      i++;
                while (arr[j].getDistance() > pivot)
                      j--;
                if (i <= j) {
                      tmp = arr[i];
                      arr[i]=arr[j];
                      arr[j]=tmp;
                      i++;
                      j--;
                }
          };
         
          return i;
    }
     
    public static void quickSort(DistanceType[] arr, int left, int right) {
          int index = partition(arr, left, right);
          if (left < index - 1)
                quickSort(arr, left, index - 1);
          if (index < right)
                quickSort(arr, index, right);
    }
}
