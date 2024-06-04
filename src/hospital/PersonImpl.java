package hospital;

public class PersonImpl implements Person {
	
	private float weight;
	private float height;
	private int age;
	private Gender gender;
	
	public PersonImpl(float weight, float height, int age, Gender gender) {
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.gender = gender;
	}
	
	public PersonImpl(float height, Gender gender) {
		this.height = height;
		this.gender = gender;
	}
	
	@Override
    public float weight() {
        return weight;
    }

    @Override
    public float height() {
        return height;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public int age() {
        return age;
    }

}
