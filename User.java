// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package weightloss;

import java.io.*;

public class User {
	private String name;
	private int age;
	private float weight;
	private float height;
	private String gender;
	private String fitnessLevel;
	private String password;

	public User(){
		name = "none";
		age = 0;
		weight = 0;
		height = 0;
		gender = "male";
		fitnessLevel = "Beginner";
		password = "1234";
	}
	/**
	 * Sets the user's name.
	 *
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the user's age.
	 *
	 * @param age the age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Sets the user's weight.
	 *
	 * @param weight the weight to set.
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * Sets the user's height.
	 *
	 * @param height the height to set.
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * Sets the user's gender.
	 *
	 * @param gender the gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Sets the user's fitness level.
	 *
	 * @param fitnessLevel the fitness level to set.
	 */
	public void setFitnessLevel(String fitnessLevel) {
		this.fitnessLevel = fitnessLevel;
	}

	/**
	 * Gets the user's name.
	 *
	 * @return the user's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the user's age.
	 *
	 * @return the user's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gets the user's weight.
	 *
	 * @return the user's weight.
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Gets the user's height.
	 *
	 * @return the user's height.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Gets the user's gender.
	 *
	 * @return the user's gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Gets the user's fitness level.
	 *
	 * @return the user's fitness level.
	 */
	public String getFitnessLevel() {
		return fitnessLevel;
	}

	/**
	 * Saves the user's information to a file.
	 *
	 * @param fileName the name of the file to save to.
	 * @throws IOException if an I/O error occurs.
	 */
	public void saveUserToFile(String fileName) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName,true))) {
			writer.print(name);
			writer.print(",");
			writer.print(age);writer.print(",");
			writer.print(weight);writer.print(",");
			writer.print(height);writer.print(",");
			writer.print(gender);writer.print(",");
			writer.print(fitnessLevel);writer.print(",");
			writer.println(password);
		}
	}

	/**
	 * Loads the user's information from a file.
	 *
	 * @param fileName the name of the file to load from.
	 * @throws IOException if an I/O error occurs.
	 */
	public void loadUserFromFile(String fileName) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			name = reader.readLine();
			age = Integer.parseInt(reader.readLine());
			weight = Float.parseFloat(reader.readLine());
			height = Float.parseFloat(reader.readLine());
			gender = reader.readLine();
			fitnessLevel = reader.readLine();
			// Check if there's a password in the file
			String passwordLine = reader.readLine();
			if (passwordLine != null) {
				password = passwordLine;
			}
		}
	}

	public void setPassword(String text) {
		password = text;
	}

	public String getPassword() {
		return password;
	}
}
