/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Package1;

/**
 * @author Sumitra
 *
 */
public interface PackageDao {
	
	List<Package1> readFromFile();
	void writeToDatabase(List<Package1> list);

}
