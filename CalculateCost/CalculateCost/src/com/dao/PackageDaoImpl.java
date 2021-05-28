package com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.InvalidPackageException;
import com.model.Package1;
import com.util.ConnectionHandler;

public class PackageDaoImpl implements PackageDao{
	
	public List<Package1> readFromFile()
	{
		BufferedReader br=null;
		List<Package1>packages=new ArrayList<Package1>();
		try
		{
			br=new BufferedReader(new FileReader("./src/package.txt"));
			String strRec=null;
			//Reading the file line by line
			while((strRec=br.readLine())!=null)
			{
				System.out.println(strRec);
				//Splitting each line into fields on the basis
				//of ',' as the delimiter
				String[]pack=strRec.split(",");
				int len=pack[0].length();
				System.out.println(pack[0].substring(3,4));
				if(len==7 && pack[0].substring(3,4).equals("/"))
				{
					String packageId=pack[0];
					String sourcePlace=pack[1];
					String destinationPlace=pack[2];
					double basicFare=Double.parseDouble(pack[3]);
					int noOfDays=Integer.parseInt(pack[4]);
					double packageCost=0.0;
					if(noOfDays<=5)
				       packageCost=((basicFare*noOfDays)-0)+((basicFare*noOfDays)-0)*.15;
					else if(noOfDays<=8)
						packageCost=((basicFare*noOfDays)-(basicFare*noOfDays)*.03)+((basicFare*noOfDays)-.03)*.15;
					else if(noOfDays<=10)
						packageCost=((basicFare*noOfDays)-(basicFare*noOfDays)*.05)+((basicFare*noOfDays)-.05)*.15;
					else
						packageCost=((basicFare*noOfDays)-(basicFare*noOfDays)*.07)+((basicFare*noOfDays)-.07)*.15;
					//Creating an instance of the class 'Package1'
					Package1 p=new Package1(packageId,sourcePlace,destinationPlace,basicFare,noOfDays,packageCost);
					//Adding the 'Package1' object to the ArrayList 'packages'.
					packages.add(p);
				}
				else
					try
				     {
					    throw new InvalidPackageException("Invalid Package Id");
				     }
				catch(InvalidPackageException inv)
				{
					System.out.println(inv.getMessage());
				}
				
					
				
			}
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			try
			{
				
			}
			catch(Exception e) {}
				
		}
		return packages;
	}
	public void writeToDatabase(List<Package1> list)
	{
		PackageDao pd=new PackageDaoImpl();
		String insertString="insert into package values(?,?,?,?,?,?)";
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertString);
			for(Package1 p:list)
			{
				pstmt.setString(1, p.getPackageId());
				pstmt.setString(2, p.getSourcePlace());
				pstmt.setString(3, p.getDestinationPlace());
				pstmt.setDouble(4,p.getBasicFare());
				pstmt.setInt(5, p.getOnOfDays());
				pstmt.setDouble(6, p.getPackageCost());
				pstmt.executeUpdate();
			}
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				con.close();
			}
			catch(SQLException sql) {}
		}
		
	}

}
