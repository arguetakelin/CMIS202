// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package weightloss;

import java.util.LinkedList;

public class Workout {
    private LinkedList<Exercise> exercises;
    private int duration;
    private int difficulty;

    public Workout(LinkedList<Exercise> exercises, int duration, int difficulty) {
        this.exercises = exercises;
        this.duration = duration;
        this.difficulty = difficulty;
    }

    /**
     * Adds an Exercise object to the workout.
     *
     * @param exercise the Exercise object to add.
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    /**
     * Removes an Exercise object from the workout.
     *
     * @param exercise the Exercise object to remove.
     */
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    /**
     * Updates an existing Exercise object in the workout.
     *
     * @param exercise the Exercise object to update.
     */
    public void updateExercise(Exercise exercise) {
        int index = exercises.indexOf(exercise);
        if (index >= 0) {
            exercises.set(index, exercise);
        }
    }

    /**
     * Calculates the estimated number of calories burned during the workout based on the user's weight and the intensity level of the workout.
     *
     * @param user the User object for whom the calories are being calculated.
     * @return the estimated number of calories burned during the workout.
     */
    public float calculateCaloriesBurned(User user) {
        float intensityLevel = (float) difficulty / 10.0f;
        return user.getWeight() * duration * intensityLevel * 6.0f;
    }

    // Getters and setters

    public LinkedList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(LinkedList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}

