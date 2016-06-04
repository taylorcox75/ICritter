package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Creates a model.KeywordCollection Set based off of the model.ICritter's interests
 */

import java.util.*;

public class KeywordCollection
{
	private Set<String> keywords; // Setting up a new set String

	public KeywordCollection()
	{
		keywords = new HashSet<String>(); // Initializes it as a HashSet
	}

	public Set<String> listKeywords()
	{

		return keywords; // Returns our Set of the keywords
	}

	public boolean addKeyword(String toAdd)
	{

		if (keywords.contains(toAdd)) // Checks to see if we already have a keyword in our life
		{
			return false; // Returns false if we do
		}

		keywords.add(toAdd); // Adds it to our keywordlist
		return true;
	}

	public boolean removeKeyword(String toAdd)
	{

		return keywords.remove(toAdd); // Calls HashSet API to find and remove the given String.

	}

	public double correlation(KeywordCollection other)
	{
		Set<String> currentKeywords = listKeywords(); // This is the current Critter's interests
		Set<String> otherKeywords = other.listKeywords(); // This is the passeed in Critter's interests
		Double toReturn = 0.0;
		
		if (otherKeywords.size() == 0 && currentKeywords.size() == 0) // If both arrays are empty, they can be friends
		{
			return 1; // Return 1 so MarineCritter can add the Animal
		}
		
		Set<String> intersection = new HashSet<String>(currentKeywords); // A new set to store intersections

		intersection.retainAll(otherKeywords); // Intersection retains all the similar Strings
		
		int divideBy = (currentKeywords.size() + otherKeywords.size() - intersection.size()); // Finds what we need to divide by
		toReturn = intersection.size() / (double) divideBy; // Does the division
		
		return toReturn; // Returns the number as a double
	}

}
