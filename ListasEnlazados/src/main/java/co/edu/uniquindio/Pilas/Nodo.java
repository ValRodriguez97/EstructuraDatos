package co.edu.uniquindio.Pilas;

public class Nodo<T> {

        private T cima;
        private Nodo<T> proximo;
        private Nodo<T>anterior;

        public Nodo(T cima) {
            this.cima = cima;
            this.proximo = null;
            this.anterior = null;
        }

        public T getCima() {
            return cima;
        }

        public void setCima(T cima) {
            this.cima = cima;
        }

        public Nodo<T> getProximo() {
            return proximo;
        }

        public void setProximo(Nodo<T> proximo) {
            this.proximo = proximo;
        }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}
