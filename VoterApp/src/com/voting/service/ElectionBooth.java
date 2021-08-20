package com.voting.service;

import com.voting.exception.*;

public class ElectionBooth {

	String localities[] = { "ABC Nagar", "XYZ Nagar", "RK Nagar" };

	// if age is less than 18 throw exception
	boolean checkAge(int age) throws UnderAgeException {
		if (age <= 18) {
			throw new UnderAgeException("age is less than 18");
		}

		return true;
	}

	// check if the locality matches with the array
	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean isPresent = false;
		for (String l : localities) {
			if (l.equals(locality)) {

				isPresent = true;
			}
		}
		if (isPresent == true)

		{
			return true;
		} else {
			throw new LocalityNotFoundException("no match");
		}
	}

	// check if id is within 1000 - 9000
	boolean checkVoterId(int vid) throws NoVoterIDException {
		if (vid < 1000 || vid > 9000) {
			throw new NoVoterIDException("Id is not with in the given range");
		}
		return true;
	}

	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {
		try {
			checkAge(age);
		} catch (UnderAgeException e) {
			throw e;
		}
		try {
			checkLocality(locality);
		} catch (LocalityNotFoundException e1) {
			throw e1;

		}
		try {
			checkVoterId(vid);
		} catch (NoVoterIDException e) {
			throw e;

		}
		return true;

	}
}
