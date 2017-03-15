package treningsdagbok;

public class Exercise {
	
	private int id;
	private double duration;
	private int workout;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getWorkout() {
		return workout;
	}
	public void setWorkout(int workout) {
		this.workout = workout;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Exercise [id=" + id + ", name=" + name + ", duration="
                + duration + "]";
	}
	
	
	
}
