import java.util.ArrayList;

public abstract class Subject
{
    private ArrayList<Observer> observers;
    
    public void registrarObserver(Observer o){
        observers.add(o);
    }
    
    public void removerObserver(Observer o){
        observers.remove(o);
    }
    
    public void notificarObservers(){
        for (Observer o: observers){
            o.atualizar(this);
        }
    }
}
