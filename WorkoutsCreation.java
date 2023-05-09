// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package weightloss;

import java.util.LinkedList;

public class WorkoutsCreation {
    private ExerciseLibrary exerciseLibrary;

    public WorkoutsCreation(ExerciseLibrary exerciseLibrary) {
        this.exerciseLibrary = exerciseLibrary;
    }
 

    /**
     * Allows the user to select exercises from the exercise library and create a custom workout
     * with exercises of the given difficulty level. Returns a Workout object.
     *
     * @param user      the user who is creating the workout
     * @return a Workout object with exercises of the given difficulty level
     */
    public Workout createWorkout(User user) {
        LinkedList<Exercise> selectedExercises = exerciseLibrary.getBeginnerWorkouts();
        int duration = 5;
        int dificulty = 8;
        if(user.getFitnessLevel().equalsIgnoreCase("Intermediate")) {
        	duration = 15;
        	dificulty = 12;
        	selectedExercises = exerciseLibrary.getIntermediateWorkouts();
        } 
        return new Workout(selectedExercises,duration, dificulty);
    } 
    /**
     * Adds a new Exercise object to the exercise library.
     *
     * @param exercise the Exercise object to be added to the exercise library
     */
    public void addExerciseToLibrary(Exercise exercise) {
        exerciseLibrary.addExercise(exercise);
    }

    /**
     * Removes an Exercise object from the exercise library.
     *
     * @param exercise the Exercise object to be removed from the exercise library
     */
    public void removeExerciseFromLibrary(Exercise exercise) {
        exerciseLibrary.removeExercise(exercise);
    }
 
}
