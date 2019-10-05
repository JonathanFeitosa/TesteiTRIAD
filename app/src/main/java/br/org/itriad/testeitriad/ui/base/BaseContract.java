package br.org.itriad.testeitriad.ui.base;

public class BaseContract {

    public interface Presenter<T> {
     //   public void subscribe();
     //   public void unsubscribe();
        public void attach(T views);
    }

    public interface View {

    }
}
