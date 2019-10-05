package br.org.itriad.testeitriad.ui.base;

public class BaseContract {

    interface Presenter<T> {
        public void subscribe();
        public void unsubscribe();
        public void attach(T views);
    }

    interface View {

    }
}
