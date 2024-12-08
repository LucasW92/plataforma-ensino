package entities;

public abstract class Lesson {

    protected String title;

    public abstract int duration();

    public Lesson(String title) {
        this.title = title;
    }

}
