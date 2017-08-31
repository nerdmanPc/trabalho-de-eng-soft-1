import java.util.ArrayList;

public abstract class Subject
{
    private ArrayList<Observer> observers;
    
    public abstract void registrarObserver(Observer o);
    public abstract void removerObserver(Observer o);
    public abstract void notificarObservers(); //pode ser implementado aqui, também
}
