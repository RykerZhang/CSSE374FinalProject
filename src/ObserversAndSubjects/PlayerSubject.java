package ObserversAndSubjects;

public interface PlayerSubject {
    public void registerObserver(PlayerObserver o);
    public void removeObserver(PlayerObserver o);
    public void notifyObservers();
}

