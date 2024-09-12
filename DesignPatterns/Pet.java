public class Pet {
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public Pet(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    private String name;
    private Owner owner;
}
