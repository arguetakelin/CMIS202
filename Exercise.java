// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package weightloss;

/**
 * The Exercise class represents a single exercise in the gym.
 */
public class Exercise {
    private String name;
    private String description;
    private String muscleGroup;
    private String equipment;
    private String difficultyLevel;

    public Exercise(String name, String description, String muscleGroup, String equipment,
			String difficultyLevel) {
		this.name = name;
		this.description = description;
		this.muscleGroup = muscleGroup;
		this.equipment = equipment;
		this.difficultyLevel = difficultyLevel;
	}

	/**
     * Returns the name of the exercise.
     *
     * @return The name of the exercise as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the exercise.
     *
     * @param name The name of the exercise as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the exercise.
     *
     * @return The description of the exercise as a String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the exercise.
     *
     * @param description The description of the exercise as a String.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the muscle group targeted by the exercise.
     *
     * @return The muscle group targeted by the exercise as a String.
     */
    public String getMuscleGroup() {
        return muscleGroup;
    }

    /**
     * Sets the muscle group targeted by the exercise.
     *
     * @param muscleGroup The muscle group targeted by the exercise as a String.
     */
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    /**
     * Returns the equipment needed for the exercise.
     *
     * @return The equipment needed for the exercise as a String.
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * Sets the equipment needed for the exercise.
     *
     * @param equipment The equipment needed for the exercise as a String.
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * Returns the difficulty level of the exercise.
     *
     * @return The difficulty level of the exercise as a String.
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Sets the difficulty level of the exercise.
     *
     * @param difficultyLevel The difficulty level of the exercise as a String.
     */
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return name+","+equipment+","+muscleGroup+","+description;
    }
}
