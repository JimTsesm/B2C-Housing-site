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


import lsh.LSHMinHash;
import lsh.DistanceType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thibault Debatty
 */
public class LSHMinHashExample {

    /**
     * @param args the command line arguments
     */
	/*public static void main(String[] args){
    	
		//createAndSerialize();
		//System.out.println("all created");
		//int [] t = reccomendation(333);
		int i;
		int t[] = findUserVector(1893);
		for(i=0;i<15;i++) System.out.print(t[i]);
		System.out.println("");
		t[0] = 1;
		t[1] = 1;
		writeUserVector(1893,t);
		int t1[] = findUserVector(1893);
		for(i=0;i<15;i++) System.out.print(t1[i]);
    }*/
	
	public static int[] reccomendation(int user_id)
	{
		int count = 35201;
        
        // R^n
        int n = 1593;
        boolean[][] vectors = null;
        int []id = null; 
        int []id_property = null;
       int i=0;
       int j;
       int []temp = new int[3];
       ArrayList<boolean[]>[] listoflist = null;
        try {    

        //read serialized data
       FileInputStream fin = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/listoflist.ser");
       ObjectInputStream ois= new ObjectInputStream(fin);
       listoflist = (ArrayList<boolean[]>[]) ois.readObject();
       FileInputStream fin1 = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_user.ser");
       ObjectInputStream ois1= new ObjectInputStream(fin1);
       id = (int[]) ois1.readObject();
       FileInputStream fin2 = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_property.ser");
       ObjectInputStream ois2= new ObjectInputStream(fin2);
       id_property = (int[]) ois2.readObject();
       FileInputStream fin3 = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/vectors.ser");
       ObjectInputStream ois3= new ObjectInputStream(fin3);
       vectors = (boolean[][]) ois3.readObject();
       ois.close();
       ois1.close();
       ois2.close();
       ois3.close();
   
       int stages = 5;
       int buckets = 20;
       LSHMinHash lsh = new LSHMinHash(stages, buckets, n);

       	int index = findVector(id,user_id);
            boolean[] vector = vectors[index];
            int[] hash = lsh.hash(vector); 
            DistanceType2[] d = calculate_distances(listoflist[hash[0]],vector);
           
            i=0;
            int counter=0;
            DistanceType2 tt=null;
            boolean[] v;
            while(d[i].getDistance() == 0.0)	{tt = d[i];i++;}
            tt = d[i];
           // System.out.println(d[i].getDistance());         
           
            
            	for(i=0;i<1593;i++)
            	{
            		if(!vector[i] && tt.getVector()[i])	
            		{
            			
            			temp[counter] = id_property[i];
            			counter++;
            		}
            		if(counter == 3) break;
            	}

        } catch (Exception ex) {
            Logger.getLogger(LSHSuperBitExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //for(i=0;i<15;i++) System.out.print(listoflist[0].get(0)[i]);
        return temp;
	}
	
	public static void createAndSerialize()
	{
		int count = 35201;
        // R^n
        int n = 1593;
        boolean[][] vectors = new boolean[count][];
        for (int i = 0; i < count; i++) {
            vectors[i] = new boolean[n];}
        int []id = new int[count]; 
        int []id_property = new int[n];
        String csvFile1 = "C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/table_click.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
       int i=0;
       int j;       
        try {

            br = new BufferedReader(new FileReader(csvFile1));
            line = br.readLine();
            String[] data2 = line.split(cvsSplitBy);
            for(j=0;j<n;j++) id_property[j] = Integer.parseInt(data2[j+1]);
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                id[i] = Integer.parseInt(data[0]);
                for(j=0;j<n;j++)	
                {
                	if(Integer.parseInt(data[j+1]) == 1) vectors[i][j] = true;
                	else vectors[i][j] = false;
                	 
                }
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
            ArrayList<boolean[]>[] listoflist2 = (ArrayList<boolean[]>[])new ArrayList[buckets];
            for(i=0;i<buckets;i++)
            {
            	listoflist2[i] = new ArrayList<boolean[]>();
            }

            try {
            LSHMinHash lsh = new LSHMinHash(stages, buckets, n);
            
            // Compute a SuperBit signature, a LSH hash and insert vectors to Hashtable(listioflist)
            for (int ii = 0; ii < count; ii++) {
            	boolean[] vector = vectors[ii];
                int[] hash = lsh.hash(vector);
              
                listoflist2[hash[0]].add(vector);
               // System.out.print(id[ii]);
                //System.out.print("  ");
                //System.out.print(hash[0]);
               // System.out.print("\n");
            }
            
            //serialize data
            FileOutputStream fout = new FileOutputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/listoflist.ser");
            FileOutputStream fout1 = new FileOutputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_user.ser");
            FileOutputStream fout2 = new FileOutputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_property.ser");
            FileOutputStream fout3 = new FileOutputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/vectors.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            ObjectOutputStream oos1 = new ObjectOutputStream(fout1);
            ObjectOutputStream oos2 = new ObjectOutputStream(fout2);
            ObjectOutputStream oos3 = new ObjectOutputStream(fout3);
            oos.writeObject(listoflist2);
            oos1.writeObject(id);
            oos2.writeObject(id_property);
            oos3.writeObject(vectors);
            oos.close();
            oos1.close();
            oos2.close();
            oos3.close();
            } catch (Exception ex) {
                Logger.getLogger(LSHSuperBitExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            //for(i=0;i<15;i++) System.out.print(listoflist2[0].get(0)[i]);
           //System.out.println("");
	}
    
    public static int[] findUserVector(int idUser)
    {
    	int count = 35201, index = 0;
        int n = 1593;
    	boolean [][]vectors = null;
    	int []id = null;
    	int []v = new int[n];
    	int i,j;
    	try{
    	//read serialized data
        FileInputStream fin = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/vectors.ser");
        ObjectInputStream ois= new ObjectInputStream(fin);
        vectors = (boolean[][]) ois.readObject();
        FileInputStream fin1 = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_user.ser");
        ObjectInputStream ois1= new ObjectInputStream(fin1);
        id = (int[]) ois1.readObject();
        
        for(i=0;i<n;i++)
        	if(id[i] == idUser)
        	{
        		index = i;
        		break;
        	}
        for(i=0;i<n;i++)
        {
        	if(vectors[index][i]) v[i] = 1;
        	else v[i] = 0;
        }
        
        
	} catch (Exception ex) {
		Logger.getLogger(LSHSuperBitExample.class.getName()).log(Level.SEVERE, null, ex);
	}
    return v;
}
    
    public static int[] getPropertyIds()
    {
        int n = 1593;
    	int []id = null;
    	try{
    	//read serialized data
        FileInputStream fin1 = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_property.ser");
        ObjectInputStream ois1= new ObjectInputStream(fin1);
        id = (int[]) ois1.readObject();     
        
	} catch (Exception ex) {
		Logger.getLogger(LSHSuperBitExample.class.getName()).log(Level.SEVERE, null, ex);
	}
    return id;
}
    
    public static void writeUserVector(int idUser, int []vector)
    {
    	int count = 35201, index = 0;
        int n = 1593;
    	boolean [][]vectors = null;
    	int []id = null;
    	int []v = new int[n];
    	int i,j;
    	try{
    	//read serialized data
        FileInputStream fin = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/vectors.ser");
        ObjectInputStream ois= new ObjectInputStream(fin);
        vectors = (boolean[][]) ois.readObject();
        FileInputStream fin1 = new FileInputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/id_user.ser");
        ObjectInputStream ois1= new ObjectInputStream(fin1);
        id = (int[]) ois1.readObject();
        
        for(i=0;i<n;i++)
        	if(id[i] == idUser)
        	{
        		index = i;
        		break;
        	}
        for(i=0;i<n;i++)
        {
        	if(vector[i] == 1) vectors[index][i] = true;
        	else vectors[index][i] = false;
        }
        
        FileOutputStream fout = new FileOutputStream("C:/Users/turbox/Desktop/di/тед/Ergasies/lsh_data/click/vectors.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(vectors);
        oos.close();
        
	} catch (Exception ex) {
		Logger.getLogger(LSHSuperBitExample.class.getName()).log(Level.SEVERE, null, ex);
	}
}
    
    public  static DistanceType2[] calculate_distances(ArrayList<boolean[]> bucket, boolean[] vector)
    {
    	DistanceType2[] distances = new DistanceType2[bucket.size()];
    	int i,j,count=0;
    	for(i=0;i<bucket.size();i++) distances[i] = new DistanceType2();
    	double distance=0;
    	int val1,val2;
    	for(i=0;i<bucket.size();i++)
    	{
    		boolean[] temp = bucket.get(i);
    		distance = 0;
     		for(j=0;j<1593;j++)
    		{
     			if(temp[j])val1=1;
        		else val1=0;
        		if(vector[j]) val2=1;
        		else val2=0;
    			distance += (val1 - val2)*(val1 - val2);
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
    	int i;
    	for(i=0;i<35201;i++)
    	{
    		if(table[i] == id) break;
    	}
    	return i;
    }
    
    public static int partition(DistanceType2[] arr, int left, int right)
    {
          int i = left, j = right;
          DistanceType2 tmp;
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
     
    public static void quickSort(DistanceType2[] arr, int left, int right) {
          int index = partition(arr, left, right);
          if (left < index - 1)
                quickSort(arr, left, index - 1);
          if (index < right)
                quickSort(arr, index, right);
    }
}
