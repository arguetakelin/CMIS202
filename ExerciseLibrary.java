// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package weightloss;

import java.util.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
/**

ExerciseLibrary class represents a collection of exercises.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseLibrary {
	private List<Exercise> exercises;

	/**
	 * Constructor to create a new ExerciseLibrary object with an empty exercise
	 * list.
	 */
	public ExerciseLibrary() {
		this.exercises = new ArrayList<>();
	}
	
	public void addExercisesFromFile(String filePath) {
	    try {
	        File file = new File(filePath);
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(",");
	            String name = parts[0].trim();
	            String description = parts[1].trim();
	            String muscleGroup = parts[2].trim();
	            String equipment = parts[3].trim();
	            String difficultyLevel = parts[4].trim();
	            Exercise exercise = new Exercise(name, description, muscleGroup, equipment, difficultyLevel);
	            exercises.add(exercise);
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + filePath);
	    }
	}
	/**
	 * Adds an exercise to the exercise list.
	 * 
	 * @param exercise the exercise to be added to the list
	 */
	public void addExercise(Exercise exercise) {
		exercises.add(exercise);
	}

	/**
	 * Removes an exercise from the exercise list.
	 * 
	 * @param exercise the exercise to be removed from the list
	 */
	public void removeExercise(Exercise exercise) {
		exercises.remove(exercise);
	}

	/**
	 * Searches for an exercise in the exercise list by name.
	 * 
	 * @param name the name of the exercise to be searched for
	 * @return a list of exercises with matching names
	 */
	public LinkedList<Exercise> searchExerciseByName(String name) {
		LinkedList<Exercise> results = new LinkedList<>();
		for (Exercise exercise : exercises) {
			if (exercise.getName().equalsIgnoreCase(name)) {
				results.add(exercise);
			}
		}
		return results;
	}

	/**
	 * Searches for an exercise in the exercise list by muscle group.
	 * 
	 * @param muscleGroup the muscle group targeted by the exercise to be searched
	 *                    for
	 * @return a list of exercises targeting the specified muscle group
	 */
	public LinkedList<Exercise> searchExerciseByMuscleGroup(String muscleGroup) {
		LinkedList<Exercise> results = new LinkedList<>();
		for (Exercise exercise : exercises) {
			if (exercise.getMuscleGroup().equalsIgnoreCase(muscleGroup)) {
				results.add(exercise);
			}
		}
		return results;
	}

	/**
	 * Returns a list of beginner workouts.
	 * 
	 * @return a list of exercises with difficulty level set to "Beginner"
	 */
	public LinkedList<Exercise> getBeginnerWorkouts() {
		LinkedList<Exercise> results = new LinkedList<>();
		for (Exercise exercise : exercises) {
			if (exercise.getDifficultyLevel().equalsIgnoreCase("Beginner")) {
				results.add(exercise);
			}
		}
		return results;
	}

	/**
	 * Returns a list of intermediate workouts.
	 * 
	 * @return a list of exercises with difficulty level set to "Intermediate"
	 */
	public LinkedList<Exercise> getIntermediateWorkouts() {
		LinkedList<Exercise> results = new LinkedList<>();
		for (Exercise exercise : exercises) {
			if (exercise.getDifficultyLevel().equalsIgnoreCase("Intermediate")) {
				results.add(exercise);
			}
		}
		return results;
	}
}
